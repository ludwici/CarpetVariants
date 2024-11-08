package com.ludwici.carpetvariants.block;

import com.google.common.collect.ImmutableMap;
import net.minecraft.block.*;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.DyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;

import javax.annotation.Nullable;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CarpetVariantBlock extends CarpetBlock {
    public static final IntegerProperty FACE_COUNT = IntegerProperty.create("face_count", 0, 6);
    public static final BooleanProperty UP = SixWayBlock.UP;
    public static final BooleanProperty DOWN = SixWayBlock.DOWN;
    public static final BooleanProperty NORTH = SixWayBlock.NORTH;
    public static final BooleanProperty EAST = SixWayBlock.EAST;
    public static final BooleanProperty SOUTH = SixWayBlock.SOUTH;
    public static final BooleanProperty WEST = SixWayBlock.WEST;

    public static final Map<Direction, BooleanProperty> PROPERTY_BY_DIRECTION = SixWayBlock.FACING_TO_PROPERTY_MAP
            .entrySet()
            .stream()
            .collect(Util.toMapCollector());

    private static final VoxelShape UP_AABB = Block.makeCuboidShape(0.0, 15.0, 0.0, 16.0, 16.0, 16.0);
    private static final VoxelShape DOWN_AABB = Block.makeCuboidShape(0.0, 0.0, 0.0, 16.0, 1.0, 16.0);
    private static final VoxelShape WEST_AABB = Block.makeCuboidShape(0.0, 0.0, 0.0, 1.0, 16.0, 16.0);
    private static final VoxelShape EAST_AABB = Block.makeCuboidShape(15.0, 0.0, 0.0, 16.0, 16.0, 16.0);
    private static final VoxelShape NORTH_AABB = Block.makeCuboidShape(0.0, 0.0, 0.0, 16.0, 16.0, 1.0);
    private static final VoxelShape SOUTH_AABB = Block.makeCuboidShape(0.0, 0.0, 15.0, 16.0, 16.0, 16.0);
    private final Map<BlockState, VoxelShape> shapesCache;

    protected final Item replaceItem;

    public CarpetVariantBlock(Item replaceItem, DyeColor dyeColor, AbstractBlock.Properties pProperties) {
        super(dyeColor, pProperties);
        this.replaceItem = replaceItem;
        this.setDefaultState(
                this.stateContainer
                        .getBaseState()
                        .with(UP, Boolean.FALSE)
                        .with(DOWN, Boolean.FALSE)
                        .with(NORTH, Boolean.FALSE)
                        .with(EAST, Boolean.FALSE)
                        .with(SOUTH, Boolean.FALSE)
                        .with(WEST, Boolean.FALSE)
                        .with(FACE_COUNT, 0)
        );

        this.shapesCache = ImmutableMap.copyOf(
                this.stateContainer.getValidStates().stream().collect(Collectors.toMap(Function.identity(), CarpetVariantBlock::calculateShape))
        );
    }

    private static VoxelShape calculateShape(BlockState pState) {
        VoxelShape voxelshape = VoxelShapes.empty();

        if (pState.get(UP)) {
            voxelshape = UP_AABB;
        }

        if (pState.get(DOWN)) {
            voxelshape = VoxelShapes.or(voxelshape, DOWN_AABB);
        }

        if (pState.get(NORTH)) {
            voxelshape = VoxelShapes.or(voxelshape, NORTH_AABB);
        }

        if (pState.get(SOUTH)) {
            voxelshape = VoxelShapes.or(voxelshape, SOUTH_AABB);
        }

        if (pState.get(EAST)) {
            voxelshape = VoxelShapes.or(voxelshape, EAST_AABB);
        }

        if (pState.get(WEST)) {
            voxelshape = VoxelShapes.or(voxelshape, WEST_AABB);
        }

        return voxelshape.isEmpty() ? VoxelShapes.fullCube() : voxelshape;
    }

    @Override
    public VoxelShape getShape(BlockState pState, IBlockReader pLevel, BlockPos pPos, ISelectionContext pContext) {
        return this.shapesCache.get(pState);
    }

    private static boolean canAttachTo(IWorldReader blockGetter, Direction direction, BlockPos blockPos, BlockState blockState) {
        return Block.doesSideFillSquare(blockState.getCollisionShape(blockGetter, blockPos), direction.getOpposite());
    }

    public static boolean isAcceptableNeighbour(IWorldReader pBlockReader, BlockPos pNeighborPos, Direction pAttachedFace) {
        return canAttachTo(pBlockReader, pAttachedFace, pNeighborPos, pBlockReader.getBlockState(pNeighborPos));
    }

    public static BooleanProperty getPropertyForFace(Direction pFace) {
        return PROPERTY_BY_DIRECTION.get(pFace);
    }

    private boolean canSupportAtFace(IWorldReader pLevel, BlockPos pPos, Direction pDirection) {
        BlockPos blockpos = pPos.offset(pDirection);
        if (isAcceptableNeighbour(pLevel, blockpos, pDirection)) {
            return true;
        } else {
            BooleanProperty booleanproperty = PROPERTY_BY_DIRECTION.get(pDirection);
            BlockState blockstate = pLevel.getBlockState(pPos.up());
            return blockstate.matchesBlock(this) && blockstate.get(booleanproperty);
        }
    }

    @Override
    public boolean isReplaceable(BlockState pState, BlockItemUseContext pUseContext) {
        BlockState blockstate = pUseContext.getWorld().getBlockState(pUseContext.getPos());

        boolean hasParts = false;
        ItemStack itemStack = pUseContext.getItem();
        boolean same = itemStack.getItem() == this.asItem() || itemStack.getItem() == replaceItem;
        for (Direction direction : pUseContext.getNearestLookingDirections()) {
            BooleanProperty booleanproperty = getPropertyForFace(direction);
            boolean flag1 = blockstate.get(booleanproperty);
            if (!flag1 && same && this.canSupportAtFace(pUseContext.getWorld(), pUseContext.getPos(), direction)) {
                hasParts = true;
                break;
            }
        }

        int faces = this.countFaces(blockstate);

        if (same && pUseContext.replacingClickedOnBlock()) {
            if (pUseContext.getFace() == Direction.UP && !hasParts) {
                return false;
            }
        }

        return (blockstate.matchesBlock(this) && same) && faces < PROPERTY_BY_DIRECTION.size();
    }

    private BlockState getUpdatedState(BlockState pState, IWorldReader pLevel, BlockPos pPos) {
        BlockPos blockpos = pPos.up();

        BlockState blockstate = null;

        int count = 0;

        for (Direction direction : Direction.Plane.HORIZONTAL) {
            BooleanProperty booleanproperty = getPropertyForFace(direction);
            if (pState.get(booleanproperty)) {
                boolean flag = this.canSupportAtFace(pLevel, pPos, direction);
                if (!flag) {
                    if (blockstate == null) {
                        blockstate = pLevel.getBlockState(blockpos);
                    }

                    flag = blockstate.matchesBlock(this) && blockstate.get(booleanproperty);
                }

                pState = pState.with(booleanproperty, flag);
                if (flag) {
                    count += 1;
                }
            }
        }

        count = count + (pState.get(DOWN) ? 1 : 0) + (pState.get(UP) ? 1 : 0);
        pState = pState.with(FACE_COUNT, count);
        return pState;
    }

    private boolean hasFaces(BlockState pState) {
        return this.countFaces(pState) > 0;
    }

    public int countFaces(BlockState pState) {
        int i = 0;

        for (BooleanProperty booleanproperty : PROPERTY_BY_DIRECTION.values()) {
            if (pState.get(booleanproperty)) {
                i++;
            }
        }
        return i;
    }

    @Override
    public boolean isValidPosition(BlockState pState, IWorldReader pLevel, BlockPos pPos) {
        return this.hasFaces(this.getUpdatedState(pState, pLevel, pPos)) || (pState.get(DOWN) && super.isValidPosition(pState, pLevel, pPos));
    }

    @Override
    public BlockState updatePostPlacement(BlockState pState, Direction pFacing, BlockState pFacingState, IWorld pLevel, BlockPos pCurrentPos, BlockPos pFacingPos) {
        int faces = this.countFaces(pState);
        if (faces == 1) {
            if ((pState.get(UP) && pLevel.isAirBlock(pCurrentPos.up())) || (pState.get(DOWN) && pLevel.isAirBlock(pCurrentPos.down()))) {
                return Blocks.AIR.getDefaultState();
            }
        }
        BlockState blockstate = this.getUpdatedState(pState, pLevel, pCurrentPos);
        return !this.hasFaces(blockstate) ? Blocks.AIR.getDefaultState() : blockstate;
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext pContext) {
        BlockPos blockpos = pContext.getPos();
        BlockState blockstate = pContext.getWorld().getBlockState(blockpos);
        BlockState blockstate1;
        boolean flag = false;
        if (blockstate.matchesBlock(this)) {
            blockstate1 = blockstate;
            flag = true;
        } else if (blockstate.getBlock() instanceof CarpetBlock) {
            blockstate1 = this.getDefaultState().with(DOWN, true).with(FACE_COUNT, 1);
        }
        else {
            blockstate1 = this.getDefaultState();
        }

        for (Direction direction : pContext.getNearestLookingDirections()) {
            BooleanProperty booleanproperty = getPropertyForFace(direction);
            boolean flag1 = flag && blockstate.get(booleanproperty);
            if (!flag1 && this.canSupportAtFace(pContext.getWorld(), pContext.getPos(), direction)) {
                return blockstate1.with(booleanproperty, Boolean.TRUE).with(FACE_COUNT, blockstate1.get(FACE_COUNT) + 1);
            }
        }

        if (!flag) {
            return blockstate1.with(DOWN, true).with(FACE_COUNT, 1);
        }

        return blockstate1;
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(UP, DOWN, NORTH, EAST, SOUTH, WEST, FACE_COUNT);
    }

    @Override
    public BlockState rotate(BlockState pState, Rotation pRotate) {
        switch (pRotate) {
            case CLOCKWISE_180:
                return pState.with(NORTH, pState.get(SOUTH))
                        .with(EAST, pState.get(WEST))
                        .with(SOUTH, pState.get(NORTH))
                        .with(WEST, pState.get(EAST));
            case COUNTERCLOCKWISE_90:
                return pState.with(NORTH, pState.get(EAST))
                        .with(EAST, pState.get(SOUTH))
                        .with(SOUTH, pState.get(WEST))
                        .with(WEST, pState.get(NORTH));
            case CLOCKWISE_90:
                return pState.with(NORTH, pState.get(WEST))
                        .with(EAST, pState.get(NORTH))
                        .with(SOUTH, pState.get(EAST))
                        .with(WEST, pState.get(SOUTH));
            default:
                return pState;
        }
    }
    
    @Override
    public BlockState mirror(BlockState pState, Mirror pMirror) {
        switch (pMirror) {
            case LEFT_RIGHT:
                return pState.with(NORTH, pState.get(SOUTH)).with(SOUTH, pState.get(NORTH));
            case FRONT_BACK:
                return pState.with(EAST, pState.get(WEST)).with(WEST, pState.get(EAST));
        }
        return super.mirror(pState, pMirror);
    }

}
