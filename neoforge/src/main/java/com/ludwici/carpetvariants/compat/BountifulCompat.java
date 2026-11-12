package com.ludwici.carpetvariants.compat;

import com.ludwici.carpetscore.CarpetsCore;
import com.ludwici.carpetvariants.blocks.BountifulCarpetVariant;
import com.ludwici.carpetvariants.registry.BlockRegistry;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.util.function.Supplier;

import static net.ultimatech.bountifulblocks.block.BBBlocks.*;

public class BountifulCompat {
    public static DeferredBlock<Block> WHITE_THREADED_CARPET_VARIANT = registerBountiful("white_threaded", WHITE_THREADED_CARPET);

    public static DeferredBlock<Block> registerBountiful(String name, DeferredBlock<Block> orig) {
        String identifier = name + "_carpet_variant";
        DeferredBlock<Block> ret = BlockRegistry.BLOCKS.register(identifier, bountiful(orig));
        CarpetsCore.register(name + "_carpet", ret);
        return ret;
    }

    private static <B extends Block> Supplier<BountifulCarpetVariant> bountiful(DeferredBlock<B> orig) {
        return () -> new BountifulCarpetVariant(orig.asItem(), 30, 60, BlockBehaviour.Properties.of());
    }

    public static void init() {
//        WHITE_THREADED_CARPET_VARIANT = registerBountiful("white_threaded", WHITE_THREADED_CARPET.get());
    }
}
