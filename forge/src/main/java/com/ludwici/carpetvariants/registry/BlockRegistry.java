package com.ludwici.carpetvariants.registry;

import com.ludwici.carpetvariants.CarpetVariantsMod;
import com.ludwici.carpetvariants.block.CarpetVariantBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockRegistry {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, CarpetVariantsMod.MODID);

    public static final RegistryObject<Block> WHITE_CARPET_VARIANT = registerCarpet("white", Blocks.WHITE_CARPET);
    public static final RegistryObject<Block> ORANGE_CARPET_VARIANT = registerCarpet("orange", Blocks.ORANGE_CARPET);
    public static final RegistryObject<Block> MAGENTA_CARPET_VARIANT = registerCarpet("magenta", Blocks.MAGENTA_CARPET);
    public static final RegistryObject<Block> LIGHT_BLUE_CARPET_VARIANT = registerCarpet("light_blue", Blocks.LIGHT_BLUE_CARPET);
    public static final RegistryObject<Block> YELLOW_CARPET_VARIANT = registerCarpet("yellow", Blocks.YELLOW_CARPET);
    public static final RegistryObject<Block> LIME_CARPET_VARIANT = registerCarpet("lime", Blocks.LIME_CARPET);
    public static final RegistryObject<Block> PINK_CARPET_VARIANT = registerCarpet("pink", Blocks.PINK_CARPET);
    public static final RegistryObject<Block> GRAY_CARPET_VARIANT = registerCarpet("gray", Blocks.GRAY_CARPET);
    public static final RegistryObject<Block> LIGHT_GRAY_CARPET_VARIANT = registerCarpet("light_gray", Blocks.LIGHT_GRAY_CARPET);
    public static final RegistryObject<Block> CYAN_CARPET_VARIANT = registerCarpet("cyan", Blocks.CYAN_CARPET);
    public static final RegistryObject<Block> PURPLE_CARPET_VARIANT = registerCarpet("purple", Blocks.PURPLE_CARPET);
    public static final RegistryObject<Block> BLUE_CARPET_VARIANT = registerCarpet("blue", Blocks.BLUE_CARPET);
    public static final RegistryObject<Block> BROWN_CARPET_VARIANT = registerCarpet("brown", Blocks.BROWN_CARPET);
    public static final RegistryObject<Block> GREEN_CARPET_VARIANT = registerCarpet("green", Blocks.GREEN_CARPET);
    public static final RegistryObject<Block> RED_CARPET_VARIANT = registerCarpet("red", Blocks.RED_CARPET);
    public static final RegistryObject<Block> BLACK_CARPET_VARIANT = registerCarpet("black", Blocks.BLACK_CARPET);
    public static final RegistryObject<Block> MOSS_CARPET_VARIANT = registerCarpet("moss", Blocks.MOSS_CARPET);

    private static RegistryObject<Block> registerCarpet(String name, Block orig) {
        return BLOCKS.register(name + "_carpet_variant", () -> new CarpetVariantBlock(orig.asItem(), BlockBehaviour.Properties.copy(orig)));
    }

}
