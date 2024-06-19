package com.ludwici.carpetvariants.platform.services;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface IRegistryHelper {

    public List<Block> getAllCarpets();
    public Map<String, Block> getReplaceMap();
//    public Block replace(Block block);

    default public Block replace(Block block) {
        String name = BuiltInRegistries.BLOCK.getKey(block).getPath();
        return getReplaceMap().get(name);
    }
}
