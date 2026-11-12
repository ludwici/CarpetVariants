package com.ludwici.carpetvariants;

import com.ludwici.carpetvariants.registry.BlockRegistry;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

import static com.ludwici.carpetvariants.registry.BlockRegistry.GLASS_PANE_VARIANT;

@Mod(CarpetVariantsMod.MODID)
public final class CarpetVariantsModNeoForge {
    public CarpetVariantsModNeoForge(IEventBus modEventBus) {
        BlockRegistry.BLOCKS.register(modEventBus);
        BlockRegistry.ITEMS.register(modEventBus);
        modEventBus.addListener(this::addCreative);
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.COLORED_BLOCKS) {
            event.accept(GLASS_PANE_VARIANT);
        }
    }
}
