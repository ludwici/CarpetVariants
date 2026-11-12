package com.ludwici.carpetvariants.datagen;

import com.ludwici.carpetscore.api.datagen.LootTableHelper;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.stream.Collectors;

import static com.ludwici.carpetvariants.registry.BlockRegistry.*;
import static com.ludwici.carpetvariants.registry.BlockRegistry.MOSS_CARPET_VARIANT;

public class CVLootTableGenerator extends LootTableHelper {
    protected CVLootTableGenerator(LootTableSubProvider.Context context) {
        super(context);
    }

    @Override
    protected void generate() {
        createVariantItemTable(WHITE_CARPET_VARIANT, Items.CARPET.white());
        createVariantItemTable(ORANGE_CARPET_VARIANT, Items.CARPET.orange());
        createVariantItemTable(MAGENTA_CARPET_VARIANT, Items.CARPET.magenta());
        createVariantItemTable(LIGHT_BLUE_CARPET_VARIANT, Items.CARPET.lightBlue());
        createVariantItemTable(YELLOW_CARPET_VARIANT, Items.CARPET.yellow());
        createVariantItemTable(LIME_CARPET_VARIANT, Items.CARPET.lime());
        createVariantItemTable(PINK_CARPET_VARIANT, Items.CARPET.pink());
        createVariantItemTable(GRAY_CARPET_VARIANT, Items.CARPET.gray());
        createVariantItemTable(LIGHT_GRAY_CARPET_VARIANT, Items.CARPET.lightGray());
        createVariantItemTable(CYAN_CARPET_VARIANT, Items.CARPET.cyan());
        createVariantItemTable(PURPLE_CARPET_VARIANT, Items.CARPET.purple());
        createVariantItemTable(BLUE_CARPET_VARIANT, Items.CARPET.blue());
        createVariantItemTable(BROWN_CARPET_VARIANT, Items.CARPET.brown());
        createVariantItemTable(GREEN_CARPET_VARIANT, Items.CARPET.green());
        createVariantItemTable(RED_CARPET_VARIANT, Items.CARPET.red());
        createVariantItemTable(BLACK_CARPET_VARIANT, Items.CARPET.black());
        createVariantItemTable(MOSS_CARPET_VARIANT, Items.MOSS_CARPET);
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return BLOCKS.getEntries().stream().map(DeferredHolder::value).collect(Collectors.toList());
    }
}
