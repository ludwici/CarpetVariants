package com.ludwici.carpetvariants.mixin;

import com.ludwici.carpetvariants.CarpetReplacer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CarpetBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.neoforged.neoforge.registries.DeferredBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BlockItem.class)
public abstract class BlockItemMixin {

    @Shadow public abstract Block getBlock();

    @Inject(method = "getPlacementState", at = @At("RETURN"), cancellable = true)
    private void blockPlace(BlockPlaceContext pContext, CallbackInfoReturnable<BlockState> cir) {
        Block block = getBlock();
        if (block instanceof CarpetBlock) {
            DeferredBlock<Block> deferredBlock = CarpetReplacer.replace(block);

            if (deferredBlock != null) {
                BlockState blockstate = deferredBlock.get().getStateForPlacement(pContext);

                BlockState blockstate1 = null;

                LevelReader levelreader = pContext.getLevel();
                BlockPos blockpos = pContext.getClickedPos();

                if (blockstate != null && blockstate.canSurvive(levelreader, blockpos)) {
                    blockstate1 = blockstate;
                }

                cir.setReturnValue(blockstate1 != null && levelreader.isUnobstructed(blockstate1, blockpos, CollisionContext.empty()) ? blockstate1 : null);
            }
        }
    }

}
