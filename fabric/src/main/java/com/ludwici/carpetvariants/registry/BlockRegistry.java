package com.ludwici.carpetvariants.registry;

import com.ludwici.carpetscore.CarpetsCore;
import com.ludwici.carpetscore.api.block.CarpetVariantBlock;
import com.ludwici.carpetvariants.CarpetVariants;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.PushReaction;

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
        String identifier = name + "_carpet_variant";
        BlockBehaviour.Properties properties = BlockBehaviour.Properties.ofFullCopy(orig).pushReaction(PushReaction.DESTROY).overrideDescription(orig.getDescriptionId()).setId(keyOfBlock(identifier));
        Block ret = Registry.register(BuiltInRegistries.BLOCK, keyOfBlock(identifier), new CarpetVariantBlock(orig.asItem(), properties));
        CarpetsCore.register(name + "_carpet", ret);
        return ret;
    }

    private static ResourceKey<Block> keyOfBlock(String name) {
        return ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(CarpetVariants.MOD_ID, name));
    }

    public static void initialize() {}
}
