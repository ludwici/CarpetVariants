package com.ludwici.carpetvariants.datagen;

import com.ludwici.carpetscore.api.datagen.BlockStateHelper;
import com.ludwici.carpetvariants.CarpetVariantsMod;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.data.PackOutput;

import static com.ludwici.carpetvariants.registry.BlockRegistry.*;
import static net.minecraft.world.level.block.Blocks.*;

public class CVBlockStateProvider extends ModelProvider {
    private BlockStateHelper stateHelper;

    public CVBlockStateProvider(PackOutput output) {
        super(output, CarpetVariantsMod.MODID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        stateHelper = new BlockStateHelper(blockModels);
        stateHelper.createVariantCarpet(WHITE_CARPET_VARIANT, WOOL.white());
        stateHelper.createVariantCarpet(ORANGE_CARPET_VARIANT, WOOL.orange());
        stateHelper.createVariantCarpet(MAGENTA_CARPET_VARIANT, WOOL.magenta());
        stateHelper.createVariantCarpet(LIGHT_BLUE_CARPET_VARIANT, WOOL.lightBlue());
        stateHelper.createVariantCarpet(YELLOW_CARPET_VARIANT, WOOL.yellow());
        stateHelper.createVariantCarpet(LIME_CARPET_VARIANT, WOOL.lime());
        stateHelper.createVariantCarpet(PINK_CARPET_VARIANT, WOOL.pink());
        stateHelper.createVariantCarpet(GRAY_CARPET_VARIANT, WOOL.gray());
        stateHelper.createVariantCarpet(LIGHT_GRAY_CARPET_VARIANT, WOOL.lightGray());
        stateHelper.createVariantCarpet(CYAN_CARPET_VARIANT, WOOL.cyan());
        stateHelper.createVariantCarpet(PURPLE_CARPET_VARIANT, WOOL.purple());
        stateHelper.createVariantCarpet(BLUE_CARPET_VARIANT, WOOL.blue());
        stateHelper.createVariantCarpet(BROWN_CARPET_VARIANT, WOOL.brown());
        stateHelper.createVariantCarpet(GREEN_CARPET_VARIANT, WOOL.green());
        stateHelper.createVariantCarpet(RED_CARPET_VARIANT, WOOL.red());
        stateHelper.createVariantCarpet(BLACK_CARPET_VARIANT, WOOL.black());
        stateHelper.createVariantCarpet(MOSS_CARPET_VARIANT, MOSS_BLOCK);
    }
}
