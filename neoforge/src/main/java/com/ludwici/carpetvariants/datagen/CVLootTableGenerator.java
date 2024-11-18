package com.ludwici.carpetvariants.datagen;

import com.ludwici.carpetscore.datagen.LootTableHelper;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.stream.Collectors;

import static com.ludwici.carpetvariants.registry.BlockRegistry.*;

public class CVLootTableGenerator extends LootTableHelper {

    @Override
    protected void generate() {
        createVariantItemTable(WHITE_CARPET_VARIANT.get(), Items.WHITE_CARPET);
        createVariantItemTable(ORANGE_CARPET_VARIANT.get(), Items.ORANGE_CARPET);
        createVariantItemTable(MAGENTA_CARPET_VARIANT.get(), Items.MAGENTA_CARPET);
        createVariantItemTable(LIGHT_BLUE_CARPET_VARIANT.get(), Items.LIGHT_BLUE_CARPET);
        createVariantItemTable(YELLOW_CARPET_VARIANT.get(), Items.YELLOW_CARPET);
        createVariantItemTable(LIME_CARPET_VARIANT.get(), Items.LIME_CARPET);
        createVariantItemTable(PINK_CARPET_VARIANT.get(), Items.PINK_CARPET);
        createVariantItemTable(GRAY_CARPET_VARIANT.get(), Items.GRAY_CARPET);
        createVariantItemTable(LIGHT_GRAY_CARPET_VARIANT.get(), Items.LIME_CARPET);
        createVariantItemTable(CYAN_CARPET_VARIANT.get(), Items.CYAN_CARPET);
        createVariantItemTable(PURPLE_CARPET_VARIANT.get(), Items.PURPLE_CARPET);
        createVariantItemTable(BLUE_CARPET_VARIANT.get(), Items.BLUE_CARPET);
        createVariantItemTable(BROWN_CARPET_VARIANT.get(), Items.BROWN_CARPET);
        createVariantItemTable(GREEN_CARPET_VARIANT.get(), Items.GREEN_CARPET);
        createVariantItemTable(RED_CARPET_VARIANT.get(), Items.RED_CARPET);
        createVariantItemTable(BLACK_CARPET_VARIANT.get(), Items.BLACK_CARPET);
        createVariantItemTable(MOSS_CARPET_VARIANT.get(), Items.MOSS_CARPET);
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return BLOCKS.getEntries().stream().map(DeferredHolder::value).collect(Collectors.toList());
    }
}
