package com.ludwici.carpetvariants.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;
import java.util.Set;

public class CVLootTableProvider extends LootTableProvider {
    public CVLootTableProvider(PackOutput pOutput) {
        super(pOutput, Set.of(), List.of(
                new LootTableProvider.SubProviderEntry(CVLootTableGenerator::new, LootContextParamSets.BLOCK)
        ));
    }
}