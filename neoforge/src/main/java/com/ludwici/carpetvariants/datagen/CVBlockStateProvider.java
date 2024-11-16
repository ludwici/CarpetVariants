package com.ludwici.carpetvariants.datagen;

import com.ludwici.carpetscore.datagen.BlockStateHelper;
import com.ludwici.carpetvariants.CarpetVariantsMod;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import static com.ludwici.carpetvariants.registry.BlockRegistry.*;
import static net.minecraft.world.level.block.Blocks.*;

public class CVBlockStateProvider extends BlockStateProvider {
    private final BlockStateHelper stateHelper;

    public CVBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, CarpetVariantsMod.MODID, exFileHelper);
        stateHelper = new BlockStateHelper(this);
    }

    @Override
    protected void registerStatesAndModels() {
        stateHelper.createVariantCarpet(WHITE_CARPET_VARIANT.get(), WHITE_WOOL);
        stateHelper.createVariantCarpet(ORANGE_CARPET_VARIANT.get(), ORANGE_WOOL);
        stateHelper.createVariantCarpet(MAGENTA_CARPET_VARIANT.get(), MAGENTA_WOOL);
        stateHelper.createVariantCarpet(LIGHT_BLUE_CARPET_VARIANT.get(), LIGHT_BLUE_WOOL);
        stateHelper.createVariantCarpet(YELLOW_CARPET_VARIANT.get(), YELLOW_WOOL);
        stateHelper.createVariantCarpet(LIME_CARPET_VARIANT.get(), LIME_WOOL);
        stateHelper.createVariantCarpet(PINK_CARPET_VARIANT.get(), PINK_WOOL);
        stateHelper.createVariantCarpet(GRAY_CARPET_VARIANT.get(), GRAY_WOOL);
        stateHelper.createVariantCarpet(LIGHT_GRAY_CARPET_VARIANT.get(), LIGHT_GRAY_WOOL);
        stateHelper.createVariantCarpet(CYAN_CARPET_VARIANT.get(), CYAN_WOOL);
        stateHelper.createVariantCarpet(PURPLE_CARPET_VARIANT.get(), PURPLE_WOOL);
        stateHelper.createVariantCarpet(BLUE_CARPET_VARIANT.get(), BLUE_WOOL);
        stateHelper.createVariantCarpet(BROWN_CARPET_VARIANT.get(), BROWN_WOOL);
        stateHelper.createVariantCarpet(GREEN_CARPET_VARIANT.get(), GREEN_WOOL);
        stateHelper.createVariantCarpet(RED_CARPET_VARIANT.get(), RED_WOOL);
        stateHelper.createVariantCarpet(BLACK_CARPET_VARIANT.get(), BLACK_WOOL);
        stateHelper.createVariantCarpet(MOSS_CARPET_VARIANT.get(), MOSS_BLOCK);
    }
}