package com.ludwici.carpetvariants.fabric;

import com.ludwici.carpetvariants.fabric.registry.BlockRegistry;
import net.fabricmc.api.ModInitializer;

public final class CarpetVariantsModFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        BlockRegistry.init();
    }
}
