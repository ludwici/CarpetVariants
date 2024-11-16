package com.ludwici.carpetvariants.datagen;

import com.ludwici.carpetscore.datagen.BlockStateHelper;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.data.models.BlockModelGenerators;

import static com.ludwici.carpetvariants.registry.BlockRegistry.*;
import static net.minecraft.world.level.block.Blocks.*;

public class ModelGenerator extends BlockStateHelper {

    public ModelGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator) {
        super.generateBlockStateModels(blockStateModelGenerator);
        createVariantCarpet(WHITE_CARPET_VARIANT, WHITE_WOOL);
        createVariantCarpet(ORANGE_CARPET_VARIANT, ORANGE_WOOL);
        createVariantCarpet(MAGENTA_CARPET_VARIANT, MAGENTA_WOOL);
        createVariantCarpet(LIGHT_BLUE_CARPET_VARIANT, LIGHT_BLUE_WOOL);
        createVariantCarpet(YELLOW_CARPET_VARIANT, YELLOW_WOOL);
        createVariantCarpet(LIME_CARPET_VARIANT, LIME_WOOL);
        createVariantCarpet(PINK_CARPET_VARIANT, PINK_WOOL);
        createVariantCarpet(GRAY_CARPET_VARIANT, GRAY_WOOL);
        createVariantCarpet(LIGHT_GRAY_CARPET_VARIANT, LIGHT_GRAY_WOOL);
        createVariantCarpet(CYAN_CARPET_VARIANT, CYAN_WOOL);
        createVariantCarpet(PURPLE_CARPET_VARIANT, PURPLE_WOOL);
        createVariantCarpet(BLUE_CARPET_VARIANT, BLUE_WOOL);
        createVariantCarpet(BROWN_CARPET_VARIANT, BROWN_WOOL);
        createVariantCarpet(GREEN_CARPET_VARIANT, GREEN_WOOL);
        createVariantCarpet(RED_CARPET_VARIANT, RED_WOOL);
        createVariantCarpet(BLACK_CARPET_VARIANT, BLACK_WOOL);
        createVariantCarpet(MOSS_CARPET_VARIANT, MOSS_BLOCK);
    }
}
