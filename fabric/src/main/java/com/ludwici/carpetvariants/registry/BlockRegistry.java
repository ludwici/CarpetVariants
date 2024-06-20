package com.ludwici.carpetvariants.registry;

import com.ludwici.carpetvariants.block.CarpetVariantBlock;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import static com.ludwici.carpetvariants.CarpetVariantsMod.MODID;


public class BlockRegistry {

    public static final Block WHITE_CARPET_VARIANT = registerCarpet("white", Blocks.WHITE_CARPET);
    public static final Block ORANGE_CARPET_VARIANT = registerCarpet("orange", Blocks.ORANGE_CARPET);
    public static final Block MAGENTA_CARPET_VARIANT = registerCarpet("magenta", Blocks.MAGENTA_CARPET);
    public static final Block LIGHT_BLUE_CARPET_VARIANT = registerCarpet("light_blue", Blocks.LIGHT_BLUE_CARPET);
    public static final Block YELLOW_CARPET_VARIANT = registerCarpet("yellow", Blocks.YELLOW_CARPET);
    public static final Block LIME_CARPET_VARIANT = registerCarpet("lime", Blocks.LIME_CARPET);
    public static final Block PINK_CARPET_VARIANT = registerCarpet("pink", Blocks.PINK_CARPET);
    public static final Block GRAY_CARPET_VARIANT = registerCarpet("gray", Blocks.GRAY_CARPET);
    public static final Block LIGHT_GRAY_CARPET_VARIANT = registerCarpet("light_gray", Blocks.LIGHT_GRAY_CARPET);
    public static final Block CYAN_CARPET_VARIANT = registerCarpet("cyan", Blocks.CYAN_CARPET);
    public static final Block PURPLE_CARPET_VARIANT = registerCarpet("purple", Blocks.PURPLE_CARPET);
    public static final Block BLUE_CARPET_VARIANT = registerCarpet("blue", Blocks.BLUE_CARPET);
    public static final Block BROWN_CARPET_VARIANT = registerCarpet("brown", Blocks.BROWN_CARPET);
    public static final Block GREEN_CARPET_VARIANT = registerCarpet("green", Blocks.GREEN_CARPET);
    public static final Block RED_CARPET_VARIANT = registerCarpet("red", Blocks.RED_CARPET);
    public static final Block BLACK_CARPET_VARIANT = registerCarpet("black", Blocks.BLACK_CARPET);
    public static final Block MOSS_CARPET_VARIANT = registerCarpet("moss", Blocks.MOSS_CARPET);

    private static Block registerCarpet(String name, Block orig) {
        return Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(MODID, name + "_carpet_variant"), new CarpetVariantBlock(orig.asItem(), BlockBehaviour.Properties.copy(orig)));
    }

    public static void init() {}
}
