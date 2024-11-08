package com.ludwici.carpetvariants.datagen;

import com.ludwici.carpetvariants.block.CarpetVariantBlock;
import net.minecraft.advancements.criterion.StatePropertiesPredicate;
import net.minecraft.block.Block;
import net.minecraft.data.loot.BlockLootTables;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.ConstantRange;
import net.minecraft.loot.ItemLootEntry;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.conditions.BlockStateProperty;
import net.minecraft.loot.functions.SetCount;
import net.minecraftforge.fml.RegistryObject;

import static com.ludwici.carpetvariants.registry.BlockRegistry.*;

public class CVLootTableGenerator extends BlockLootTables {

    @Override
    protected void addTables() {
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
    }

    protected void createCarpetVariantItemTable(Block block, Item item) {
        registerLootTable(block, lt -> LootTable.builder()
                .addLootPool(
                        withExplosionDecay(
                                block, LootPool.builder().rolls(ConstantRange.of(1)).
                                        addEntry(
                                                ItemLootEntry.builder(item)
                                                        .acceptFunction(SetCount.builder(ConstantRange.of(0)).acceptCondition(BlockStateProperty.builder(block).fromProperties(StatePropertiesPredicate.Builder.newBuilder().withIntProp(CarpetVariantBlock.FACE_COUNT, 0))))
                                                        .acceptFunction(SetCount.builder(ConstantRange.of(1)).acceptCondition(BlockStateProperty.builder(block).fromProperties(StatePropertiesPredicate.Builder.newBuilder().withIntProp(CarpetVariantBlock.FACE_COUNT, 1))))
                                                        .acceptFunction(SetCount.builder(ConstantRange.of(2)).acceptCondition(BlockStateProperty.builder(block).fromProperties(StatePropertiesPredicate.Builder.newBuilder().withIntProp(CarpetVariantBlock.FACE_COUNT, 2))))
                                                        .acceptFunction(SetCount.builder(ConstantRange.of(3)).acceptCondition(BlockStateProperty.builder(block).fromProperties(StatePropertiesPredicate.Builder.newBuilder().withIntProp(CarpetVariantBlock.FACE_COUNT, 3))))
                                                        .acceptFunction(SetCount.builder(ConstantRange.of(4)).acceptCondition(BlockStateProperty.builder(block).fromProperties(StatePropertiesPredicate.Builder.newBuilder().withIntProp(CarpetVariantBlock.FACE_COUNT, 4))))
                                                        .acceptFunction(SetCount.builder(ConstantRange.of(5)).acceptCondition(BlockStateProperty.builder(block).fromProperties(StatePropertiesPredicate.Builder.newBuilder().withIntProp(CarpetVariantBlock.FACE_COUNT, 5))))
                                                        .acceptFunction(SetCount.builder(ConstantRange.of(6)).acceptCondition(BlockStateProperty.builder(block).fromProperties(StatePropertiesPredicate.Builder.newBuilder().withIntProp(CarpetVariantBlock.FACE_COUNT, 6))))
                                        )
                        )
                ));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
