package com.ludwici.carpetvariants.datagen;

import com.ludwici.carpetvariants.block.CarpetVariantBlock;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.PipeBlock;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.AlternativesEntry;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemEntityPropertyCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.Set;
import java.util.stream.Collectors;

import static com.ludwici.carpetvariants.registry.BlockRegistry.*;

public class CVLootTableGenerator extends BlockLootSubProvider {
    protected CVLootTableGenerator() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        createCarpetVariantItemTable(WHITE_CARPET_VARIANT.get(), Items.WHITE_CARPET);
        createCarpetVariantItemTable(ORANGE_CARPET_VARIANT.get(), Items.ORANGE_CARPET);
        createCarpetVariantItemTable(MAGENTA_CARPET_VARIANT.get(), Items.MAGENTA_CARPET);
        createCarpetVariantItemTable(LIGHT_BLUE_CARPET_VARIANT.get(), Items.LIGHT_BLUE_CARPET);
        createCarpetVariantItemTable(YELLOW_CARPET_VARIANT.get(), Items.YELLOW_CARPET);
        createCarpetVariantItemTable(LIME_CARPET_VARIANT.get(), Items.LIME_CARPET);
        createCarpetVariantItemTable(PINK_CARPET_VARIANT.get(), Items.PINK_CARPET);
        createCarpetVariantItemTable(GRAY_CARPET_VARIANT.get(), Items.GRAY_CARPET);
        createCarpetVariantItemTable(LIGHT_GRAY_CARPET_VARIANT.get(), Items.LIME_CARPET);
        createCarpetVariantItemTable(CYAN_CARPET_VARIANT.get(), Items.CYAN_CARPET);
        createCarpetVariantItemTable(PURPLE_CARPET_VARIANT.get(), Items.PURPLE_CARPET);
        createCarpetVariantItemTable(BLUE_CARPET_VARIANT.get(), Items.BLUE_CARPET);
        createCarpetVariantItemTable(BROWN_CARPET_VARIANT.get(), Items.BROWN_CARPET);
        createCarpetVariantItemTable(GREEN_CARPET_VARIANT.get(), Items.GREEN_CARPET);
        createCarpetVariantItemTable(RED_CARPET_VARIANT.get(), Items.RED_CARPET);
        createCarpetVariantItemTable(BLACK_CARPET_VARIANT.get(), Items.BLACK_CARPET);
        createCarpetVariantItemTable(MOSS_CARPET_VARIANT.get(), Items.MOSS_CARPET);
    }

    protected void createCarpetVariantItemTable(Block block, Item item) {
        this.add(block, lt -> LootTable.lootTable()
                .withPool(LootPool.lootPool()
//                        .when(LootItemEntityPropertyCondition.entityPresent(LootContext.EntityTarget.THIS))
                        .add(AlternativesEntry.alternatives(
                                AlternativesEntry.alternatives(
                                        CarpetVariantBlock.FACE_COUNT.getPossibleValues(),
                                        value -> LootItem.lootTableItem(item)
                                                .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CarpetVariantBlock.FACE_COUNT, value))
                                                )
                                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(value)))

                                )
                        ))
                )
        );
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return BLOCKS.getEntries().stream().map(DeferredHolder::value).collect(Collectors.toList());
    }
}
