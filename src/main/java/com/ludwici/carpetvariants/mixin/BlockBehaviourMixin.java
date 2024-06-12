package com.ludwici.carpetvariants.mixin;

import com.ludwici.carpetvariants.CarpetReplacer;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CarpetBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.registries.DeferredBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BlockBehaviour.class)
public abstract class BlockBehaviourMixin {

    @Inject(method = "canBeReplaced", at = @At("RETURN"), cancellable = true)
    private void replaced(BlockState pState, BlockPlaceContext pUseContext, CallbackInfoReturnable<Boolean> cir) {
        if (pState.getBlock() instanceof CarpetBlock block) {
            DeferredBlock<Block> deferredBlock = CarpetReplacer.replace(block);
            if (deferredBlock != null) {
                cir.setReturnValue(true);
            }
        }
    }

}
