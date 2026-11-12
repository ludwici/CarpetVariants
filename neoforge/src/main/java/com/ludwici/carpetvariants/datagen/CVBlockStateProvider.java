package com.ludwici.carpetvariants.datagen;

import com.ludwici.carpetscore.CarpetsCore;
import com.ludwici.carpetscore.datagen.BlockStateHelper;
import com.ludwici.carpetvariants.CarpetVariantsMod;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import static com.ludwici.carpetvariants.compat.BountifulCompat.*;
import static com.ludwici.carpetvariants.registry.BlockRegistry.*;
import static net.minecraft.world.level.block.Blocks.*;
import static net.ultimatech.bountifulblocks.block.BBBlocks.WHITE_THREADED_CARPET;

public class CVBlockStateProvider extends BlockStateProvider {
    private final BlockStateHelper stateHelper;

    public CVBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, CarpetVariantsMod.MODID, exFileHelper);
        stateHelper = new BlockStateHelper(this);
    }

    @Override
    protected void registerStatesAndModels() {
        stateHelper.createVariantCarpet(WHITE_CARPET_VARIANT, WHITE_WOOL);
        stateHelper.createVariantCarpet(ORANGE_CARPET_VARIANT, ORANGE_WOOL);
        stateHelper.createVariantCarpet(MAGENTA_CARPET_VARIANT, MAGENTA_WOOL);
        stateHelper.createVariantCarpet(LIGHT_BLUE_CARPET_VARIANT, LIGHT_BLUE_WOOL);
        stateHelper.createVariantCarpet(YELLOW_CARPET_VARIANT, YELLOW_WOOL);
        stateHelper.createVariantCarpet(LIME_CARPET_VARIANT, LIME_WOOL);
        stateHelper.createVariantCarpet(PINK_CARPET_VARIANT, PINK_WOOL);
        stateHelper.createVariantCarpet(GRAY_CARPET_VARIANT, GRAY_WOOL);
        stateHelper.createVariantCarpet(LIGHT_GRAY_CARPET_VARIANT, LIGHT_GRAY_WOOL);
        stateHelper.createVariantCarpet(CYAN_CARPET_VARIANT, CYAN_WOOL);
        stateHelper.createVariantCarpet(PURPLE_CARPET_VARIANT, PURPLE_WOOL);
        stateHelper.createVariantCarpet(BLUE_CARPET_VARIANT, BLUE_WOOL);
        stateHelper.createVariantCarpet(BROWN_CARPET_VARIANT, BROWN_WOOL);
        stateHelper.createVariantCarpet(GREEN_CARPET_VARIANT, GREEN_WOOL);
        stateHelper.createVariantCarpet(RED_CARPET_VARIANT, RED_WOOL);
        stateHelper.createVariantCarpet(BLACK_CARPET_VARIANT, BLACK_WOOL);
        stateHelper.createVariantCarpet(MOSS_CARPET_VARIANT, MOSS_BLOCK);

        stateHelper.createVariantCarpet(WHITE_THREADED_CARPET_VARIANT, WHITE_THREADED_CARPET);
    }
}