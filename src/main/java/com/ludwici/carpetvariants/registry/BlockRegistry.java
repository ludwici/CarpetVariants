package com.ludwici.carpetvariants.registry;

import com.ludwici.carpetvariants.CarpetVariantsMod;
import com.ludwici.carpetvariants.block.CarpetVariantBlock;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;


public class BlockRegistry {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(CarpetVariantsMod.MODID);

    public static final DeferredBlock<Block> WHITE_CARPET_VARIANT = BLOCKS.register("white_carpet_variant", () -> new CarpetVariantBlock(Items.WHITE_CARPET, BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CARPET)));
    public static final DeferredBlock<Block> ORANGE_CARPET_VARIANT = BLOCKS.register("orange_carpet_variant", () -> new CarpetVariantBlock(Items.ORANGE_CARPET, BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_CARPET)));
    public static final DeferredBlock<Block> MAGENTA_CARPET_VARIANT = BLOCKS.register("magenta_carpet_variant", () -> new CarpetVariantBlock(Items.MAGENTA_CARPET, BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_CARPET)));
    public static final DeferredBlock<Block> LIGHT_BLUE_CARPET_VARIANT = BLOCKS.register("light_blue_carpet_variant", () -> new CarpetVariantBlock(Items.LIGHT_BLUE_CARPET, BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_CARPET)));
    public static final DeferredBlock<Block> YELLOW_CARPET_VARIANT = BLOCKS.register("yellow_carpet_variant", () -> new CarpetVariantBlock(Items.YELLOW_CARPET, BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_CARPET)));
    public static final DeferredBlock<Block> LIME_CARPET_VARIANT = BLOCKS.register("lime_carpet_variant", () -> new CarpetVariantBlock(Items.LIME_CARPET, BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_CARPET)));
    public static final DeferredBlock<Block> PINK_CARPET_VARIANT = BLOCKS.register("pink_carpet_variant", () -> new CarpetVariantBlock(Items.PINK_CARPET, BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_CARPET)));
    public static final DeferredBlock<Block> GRAY_CARPET_VARIANT = BLOCKS.register("gray_carpet_variant", () -> new CarpetVariantBlock(Items.GRAY_CARPET, BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_CARPET)));
    public static final DeferredBlock<Block> LIGHT_GRAY_CARPET_VARIANT = BLOCKS.register("light_gray_carpet_variant", () -> new CarpetVariantBlock(Items.LIGHT_GRAY_CARPET, BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_CARPET)));
    public static final DeferredBlock<Block> CYAN_CARPET_VARIANT = BLOCKS.register("cyan_carpet_variant", () -> new CarpetVariantBlock(Items.CYAN_CARPET, BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_CARPET)));
    public static final DeferredBlock<Block> PURPLE_CARPET_VARIANT = BLOCKS.register("purple_carpet_variant", () -> new CarpetVariantBlock(Items.PURPLE_CARPET, BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_CARPET)));
    public static final DeferredBlock<Block> BLUE_CARPET_VARIANT = BLOCKS.register("blue_carpet_variant", () -> new CarpetVariantBlock(Items.BLUE_CARPET, BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_CARPET)));
    public static final DeferredBlock<Block> BROWN_CARPET_VARIANT = BLOCKS.register("brown_carpet_variant", () -> new CarpetVariantBlock(Items.BROWN_CARPET, BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_CARPET)));
    public static final DeferredBlock<Block> GREEN_CARPET_VARIANT = BLOCKS.register("green_carpet_variant", () -> new CarpetVariantBlock(Items.GREEN_CARPET, BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_CARPET)));
    public static final DeferredBlock<Block> RED_CARPET_VARIANT = BLOCKS.register("red_carpet_variant", () -> new CarpetVariantBlock(Items.RED_CARPET, BlockBehaviour.Properties.ofFullCopy(Blocks.RED_CARPET)));
    public static final DeferredBlock<Block> BLACK_CARPET_VARIANT = BLOCKS.register("black_carpet_variant", () -> new CarpetVariantBlock(Items.BLACK_CARPET, BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_CARPET)));
    public static final DeferredBlock<Block> MOSS_CARPET_VARIANT = BLOCKS.register("moss_carpet_variant", () -> new CarpetVariantBlock(Items.MOSS_CARPET, BlockBehaviour.Properties.ofFullCopy(Blocks.MOSS_CARPET)));

}
