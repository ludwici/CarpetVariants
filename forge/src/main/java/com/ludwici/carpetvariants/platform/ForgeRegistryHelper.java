package com.ludwici.carpetvariants.platform;

import com.ludwici.carpetvariants.platform.services.IRegistryHelper;
import net.minecraft.world.level.block.Block;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.ludwici.carpetvariants.registry.BlockRegistry.*;

public class ForgeRegistryHelper implements IRegistryHelper {

    protected Map<String, Block> replaceMap;

    public ForgeRegistryHelper() {
        replaceMap = new HashMap<>();
        replaceMap.put("white_carpet", WHITE_CARPET_VARIANT.get());
        replaceMap.put("orange_carpet", ORANGE_CARPET_VARIANT.get());
        replaceMap.put("magenta_carpet", MAGENTA_CARPET_VARIANT.get());
        replaceMap.put("light_blue_carpet", LIGHT_BLUE_CARPET_VARIANT.get());
        replaceMap.put("yellow_carpet", YELLOW_CARPET_VARIANT.get());
        replaceMap.put("lime_carpet", LIME_CARPET_VARIANT.get());
        replaceMap.put("pink_carpet", PINK_CARPET_VARIANT.get());
        replaceMap.put("gray_carpet", GRAY_CARPET_VARIANT.get());
        replaceMap.put("light_gray_carpet", LIGHT_GRAY_CARPET_VARIANT.get());
        replaceMap.put("cyan_carpet", CYAN_CARPET_VARIANT.get());
        replaceMap.put("purple_carpet", PURPLE_CARPET_VARIANT.get());
        replaceMap.put("blue_carpet", BLUE_CARPET_VARIANT.get());
        replaceMap.put("brown_carpet", BROWN_CARPET_VARIANT.get());
        replaceMap.put("green_carpet", GREEN_CARPET_VARIANT.get());
        replaceMap.put("red_carpet", RED_CARPET_VARIANT.get());
        replaceMap.put("black_carpet", BLACK_CARPET_VARIANT.get());
        replaceMap.put("moss_carpet", MOSS_CARPET_VARIANT.get());
    }

    @Override
    public List<Block> getAllCarpets() {
        return List.of();
    }

    @Override
    public Map<String, Block> getReplaceMap() {
        return replaceMap;
    }

//    @Override
//    public Block replace(Block block) {
//        String name = BuiltInRegistries.BLOCK.getKey(block).getPath();
//        return replaceMap.get(name);
//    }
}
