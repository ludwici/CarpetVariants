package com.ludwici.carpetvariants.mixin;


import com.ludwici.carpetvariants.CarpetVariantsMod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CarpetBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BlockItem.class)
public abstract class BlockItemMixin {

    @Shadow public abstract Block getBlock();

    @Inject(method = "getStateForPlacement", at = @At("RETURN"), cancellable = true)
    private void blockPlace(BlockItemUseContext pContext, CallbackInfoReturnable<BlockState> cir) {
        Block block = getBlock();
        if (block instanceof CarpetBlock) {
            Block deferredBlock = CarpetVariantsMod.replace(block);

            if (deferredBlock != null) {
                BlockState blockstate = deferredBlock.getStateForPlacement(pContext);

                BlockState blockstate1 = null;

                World levelreader = pContext.getWorld();
                BlockPos blockpos = pContext.getPos();

                if (blockstate != null && blockstate.isValidPosition(levelreader, blockpos)) {
                    blockstate1 = blockstate;
                }
                boolean val1 = levelreader.placedBlockCollides(blockstate1, blockpos, ISelectionContext.dummy());
                cir.setReturnValue(blockstate1 != null && val1 ? blockstate1 : null);
            }
        }
    }

}
