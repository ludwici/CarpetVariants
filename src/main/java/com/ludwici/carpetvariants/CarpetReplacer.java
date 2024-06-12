package com.ludwici.carpetvariants;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.util.HashMap;
import java.util.Map;

import static com.ludwici.carpetvariants.registry.BlockRegistry.*;

public class CarpetReplacer {

    private static Map<String, DeferredBlock<Block>> replaceMap = new HashMap<>() {
        {
            put("white_carpet", WHITE_CARPET_VARIANT);
            put("orange_carpet", ORANGE_CARPET_VARIANT);
            put("magenta_carpet", MAGENTA_CARPET_VARIANT);
            put("light_blue_carpet", LIGHT_BLUE_CARPET_VARIANT);
            put("yellow_carpet", YELLOW_CARPET_VARIANT);
            put("lime_carpet", LIME_CARPET_VARIANT);
            put("pink_carpet", PINK_CARPET_VARIANT);
            put("gray_carpet", GRAY_CARPET_VARIANT);
            put("light_gray_carpet", LIGHT_GRAY_CARPET_VARIANT);
            put("cyan_carpet", CYAN_CARPET_VARIANT);
            put("purple_carpet", PURPLE_CARPET_VARIANT);
            put("blue_carpet", BLUE_CARPET_VARIANT);
            put("brown_carpet", BROWN_CARPET_VARIANT);
            put("green_carpet", GREEN_CARPET_VARIANT);
            put("red_carpet", RED_CARPET_VARIANT);
            put("black_carpet", BLACK_CARPET_VARIANT);
            put("moss_carpet", MOSS_CARPET_VARIANT);
        }
    };

    public static DeferredBlock<Block> replace(Block block) {
        String name = BuiltInRegistries.BLOCK.getKey(block).getPath();
        return replaceMap.get(name);
    }

}
