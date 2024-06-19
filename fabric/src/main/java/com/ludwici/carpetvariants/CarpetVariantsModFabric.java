package com.ludwici.carpetvariants;

import com.ludwici.carpetvariants.registry.BlockRegistry;
import net.fabricmc.api.ModInitializer;

public final class CarpetVariantsModFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        BlockRegistry.init();
    }
}
