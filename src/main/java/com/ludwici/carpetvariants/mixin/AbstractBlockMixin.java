package com.ludwici.carpetvariants.mixin;

import com.ludwici.carpetvariants.CarpetVariantsMod;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CarpetBlock;
import net.minecraft.item.BlockItemUseContext;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AbstractBlock.class)
public abstract class AbstractBlockMixin {

    @Inject(method = "isReplaceable", at = @At("RETURN"), cancellable = true)
    private void replaced(BlockState pState, BlockItemUseContext pUseContext, CallbackInfoReturnable<Boolean> cir) {
        Block block = pState.getBlock();
        if (block instanceof CarpetBlock) {
            Block deferredBlock = CarpetVariantsMod.replace(block);
            if (deferredBlock != null) {
                cir.setReturnValue(true);
            }
        }
    }

}
