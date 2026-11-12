package com.ludwici.carpetvariants;

import com.ludwici.carpetvariants.compat.BountifulCompat;
import com.ludwici.carpetvariants.registry.BlockRegistry;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.registries.RegisterEvent;

@Mod(CarpetVariantsMod.MODID)
public final class CarpetVariantsModNeoForge {
    public CarpetVariantsModNeoForge(IEventBus modEventBus) {
        BlockRegistry.BLOCKS.register(modEventBus);
        if (ModList.get().isLoaded("bountifulblocks")) {
            BountifulCompat.init();
        }
//        modEventBus.addListener(EventPriority.LOW, this::commonSetup);
    }

//    private void commonSetup(RegisterEvent event) {
////        event.enqueueWork(() -> {
//            if (ModList.get().isLoaded("bountifulblocks")) {
//                BountifulCompat.init();
//            }
////        });
//    }
}
