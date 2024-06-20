package com.ludwici.carpetvariants.registry;

import com.ludwici.carpetvariants.CarpetVariantsMod;
import com.ludwici.carpetvariants.block.CarpetVariantBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class BlockRegistry {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(CarpetVariantsMod.MODID);

    public static final DeferredBlock<Block> WHITE_CARPET_VARIANT = registerCarpet("white", Blocks.WHITE_CARPET);
    public static final DeferredBlock<Block> ORANGE_CARPET_VARIANT = registerCarpet("orange", Blocks.ORANGE_CARPET);
    public static final DeferredBlock<Block> MAGENTA_CARPET_VARIANT = registerCarpet("magenta", Blocks.MAGENTA_CARPET);
    public static final DeferredBlock<Block> LIGHT_BLUE_CARPET_VARIANT = registerCarpet("light_blue", Blocks.LIGHT_BLUE_CARPET);
    public static final DeferredBlock<Block> YELLOW_CARPET_VARIANT = registerCarpet("yellow", Blocks.YELLOW_CARPET);
    public static final DeferredBlock<Block> LIME_CARPET_VARIANT = registerCarpet("lime", Blocks.LIME_CARPET);
    public static final DeferredBlock<Block> PINK_CARPET_VARIANT = registerCarpet("pink", Blocks.PINK_CARPET);
    public static final DeferredBlock<Block> GRAY_CARPET_VARIANT = registerCarpet("gray", Blocks.GRAY_CARPET);
    public static final DeferredBlock<Block> LIGHT_GRAY_CARPET_VARIANT = registerCarpet("light_gray", Blocks.LIGHT_GRAY_CARPET);
    public static final DeferredBlock<Block> CYAN_CARPET_VARIANT = registerCarpet("cyan", Blocks.CYAN_CARPET);
    public static final DeferredBlock<Block> PURPLE_CARPET_VARIANT = registerCarpet("purple", Blocks.PURPLE_CARPET);
    public static final DeferredBlock<Block> BLUE_CARPET_VARIANT = registerCarpet("blue", Blocks.BLUE_CARPET);
    public static final DeferredBlock<Block> BROWN_CARPET_VARIANT = registerCarpet("brown", Blocks.BROWN_CARPET);
    public static final DeferredBlock<Block> GREEN_CARPET_VARIANT = registerCarpet("green", Blocks.GREEN_CARPET);
    public static final DeferredBlock<Block> RED_CARPET_VARIANT = registerCarpet("red", Blocks.RED_CARPET);
    public static final DeferredBlock<Block> BLACK_CARPET_VARIANT = registerCarpet("black", Blocks.BLACK_CARPET);
    public static final DeferredBlock<Block> MOSS_CARPET_VARIANT = registerCarpet("moss", Blocks.MOSS_CARPET);

    private static DeferredBlock<Block> registerCarpet(String name, Block orig) {
        return BLOCKS.register(name + "_carpet_variant", () -> new CarpetVariantBlock(orig.asItem(), BlockBehaviour.Properties.ofFullCopy(orig)));
    }

}
