package com.ludwici.carpetvariants.platform.services;

import net.minecraft.core.Registry;
import net.minecraft.world.level.block.Block;

import java.util.Map;

public interface IRegistryHelper {

    public Map<String, Block> getReplaceMap();

    default public Block replace(Block block) {
        String name = Registry.BLOCK.getKey(block).getPath();
        return getReplaceMap().get(name);
    }
}
