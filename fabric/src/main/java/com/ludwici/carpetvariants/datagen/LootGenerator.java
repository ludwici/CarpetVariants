package com.ludwici.carpetvariants.datagen;

import com.ludwici.carpetscore.datagen.LootTableHelper;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.world.item.Items;

import static com.ludwici.carpetvariants.registry.BlockRegistry.*;

public class LootGenerator extends LootTableHelper {
    protected LootGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        createVariantItemTable(WHITE_CARPET_VARIANT, Items.WHITE_CARPET);
        createVariantItemTable(ORANGE_CARPET_VARIANT, Items.ORANGE_CARPET);
        createVariantItemTable(MAGENTA_CARPET_VARIANT, Items.MAGENTA_CARPET);
        createVariantItemTable(LIGHT_BLUE_CARPET_VARIANT, Items.LIGHT_BLUE_CARPET);
        createVariantItemTable(YELLOW_CARPET_VARIANT, Items.YELLOW_CARPET);
        createVariantItemTable(LIME_CARPET_VARIANT, Items.LIME_CARPET);
        createVariantItemTable(PINK_CARPET_VARIANT, Items.PINK_CARPET);
        createVariantItemTable(GRAY_CARPET_VARIANT, Items.GRAY_CARPET);
        createVariantItemTable(LIGHT_GRAY_CARPET_VARIANT, Items.LIME_CARPET);
        createVariantItemTable(CYAN_CARPET_VARIANT, Items.CYAN_CARPET);
        createVariantItemTable(PURPLE_CARPET_VARIANT, Items.PURPLE_CARPET);
        createVariantItemTable(BLUE_CARPET_VARIANT, Items.BLUE_CARPET);
        createVariantItemTable(BROWN_CARPET_VARIANT, Items.BROWN_CARPET);
        createVariantItemTable(GREEN_CARPET_VARIANT, Items.GREEN_CARPET);
        createVariantItemTable(RED_CARPET_VARIANT, Items.RED_CARPET);
        createVariantItemTable(BLACK_CARPET_VARIANT, Items.BLACK_CARPET);
        createVariantItemTable(MOSS_CARPET_VARIANT, Items.MOSS_CARPET);
    }
}
