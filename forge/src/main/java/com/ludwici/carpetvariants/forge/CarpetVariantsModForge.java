package com.ludwici.carpetvariants.forge;

import com.ludwici.carpetvariants.CarpetVariantsMod;
import com.ludwici.carpetvariants.forge.registry.BlockRegistry;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(CarpetVariantsMod.MODID)
public final class CarpetVariantsModForge {
    public CarpetVariantsModForge() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        BlockRegistry.BLOCKS.register(modEventBus);
    }
}
