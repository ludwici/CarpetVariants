package com.ludwici.carpetvariants;

import com.ludwici.carpetvariants.registry.BlockRegistry;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;

@Mod(CarpetVariantsMod.MODID)
public class CarpetVariantsMod
{
    public static final String MODID = "carpetvariants";

    public CarpetVariantsMod(IEventBus modEventBus, ModContainer modContainer)
    {
        BlockRegistry.BLOCKS.register(modEventBus);
    }
}
