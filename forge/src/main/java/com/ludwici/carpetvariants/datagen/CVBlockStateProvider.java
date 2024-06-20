package com.ludwici.carpetvariants.datagen;

import com.ludwici.carpetvariants.CarpetVariantsMod;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

import static com.ludwici.carpetvariants.registry.BlockRegistry.*;
import static net.minecraft.world.level.block.Blocks.*;

public class CVBlockStateProvider extends BlockStateProvider {

    public CVBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, CarpetVariantsMod.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        createVariantCarpet(WHITE_CARPET_VARIANT.get(), WHITE_WOOL);
        createVariantCarpet(ORANGE_CARPET_VARIANT.get(), ORANGE_WOOL);
        createVariantCarpet(MAGENTA_CARPET_VARIANT.get(), MAGENTA_WOOL);
        createVariantCarpet(LIGHT_BLUE_CARPET_VARIANT.get(), LIGHT_BLUE_WOOL);
        createVariantCarpet(YELLOW_CARPET_VARIANT.get(), YELLOW_WOOL);
        createVariantCarpet(LIME_CARPET_VARIANT.get(), LIME_WOOL);
        createVariantCarpet(PINK_CARPET_VARIANT.get(), PINK_WOOL);
        createVariantCarpet(GRAY_CARPET_VARIANT.get(), GRAY_WOOL);
        createVariantCarpet(LIGHT_GRAY_CARPET_VARIANT.get(), LIGHT_GRAY_WOOL);
        createVariantCarpet(CYAN_CARPET_VARIANT.get(), CYAN_WOOL);
        createVariantCarpet(PURPLE_CARPET_VARIANT.get(), PURPLE_WOOL);
        createVariantCarpet(BLUE_CARPET_VARIANT.get(), BLUE_WOOL);
        createVariantCarpet(BROWN_CARPET_VARIANT.get(), BROWN_WOOL);
        createVariantCarpet(GREEN_CARPET_VARIANT.get(), GREEN_WOOL);
        createVariantCarpet(RED_CARPET_VARIANT.get(), RED_WOOL);
        createVariantCarpet(BLACK_CARPET_VARIANT.get(), BLACK_WOOL);
        createVariantCarpet(MOSS_CARPET_VARIANT.get(), MOSS_BLOCK);
    }

    private void createVariantCarpet(Block variant, Block orig) {
        ModelFile model = new ConfiguredModel(models().singleTexture(name(variant), new ResourceLocation(CarpetVariantsMod.MODID, "block/carpet_north"), "wool", blockTexture(orig))).model;

        getMultipartBuilder(variant)
                .part().modelFile(model).addModel().condition(BlockStateProperties.NORTH, true).end()
                .part().modelFile(model).rotationY(90).uvLock(true).addModel().condition(BlockStateProperties.EAST, true).end()
                .part().modelFile(model).rotationY(180).uvLock(true).addModel().condition(BlockStateProperties.SOUTH, true).end()
                .part().modelFile(model).rotationY(270).uvLock(true).addModel().condition(BlockStateProperties.WEST, true).end()
                .part().modelFile(model).rotationX(270).uvLock(true).addModel().condition(BlockStateProperties.UP, true).end()
                .part().modelFile(model).rotationX(90).uvLock(true).addModel().condition(BlockStateProperties.DOWN, true).end()
        ;

    }

    protected String name(Block block) {
        return key(block).getPath();
    }

    protected ResourceLocation key(Block block) {
        return BuiltInRegistries.BLOCK.getKey(block);
    }
}