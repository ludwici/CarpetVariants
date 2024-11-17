package com.ludwici.carpetvariants;

import com.ludwici.carpetvariants.registry.BlockRegistry;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(CarpetVariantsMod.MODID)
public final class CarpetVariantsModNeoForge {
    public CarpetVariantsModNeoForge(IEventBus modEventBus) {
        BlockRegistry.BLOCKS.register(modEventBus);
    }
}
