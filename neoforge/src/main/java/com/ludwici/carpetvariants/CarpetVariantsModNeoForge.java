package com.ludwici.carpetvariants;

import com.ludwici.carpetvariants.platform.Services;
import com.ludwici.carpetvariants.platform.services.IPlatformHelper;
import com.ludwici.carpetvariants.registry.BlockRegistry;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

import java.util.HashMap;
import java.util.Map;

import static com.ludwici.carpetvariants.registry.BlockRegistry.*;

@Mod(CarpetVariantsMod.MODID)
public final class CarpetVariantsModNeoForge {
    public CarpetVariantsModNeoForge(IEventBus modEventBus) {
        BlockRegistry.BLOCKS.register(modEventBus);

//        Services.REGISTRY.replaceMap = new HashMap<>();
    }
}
