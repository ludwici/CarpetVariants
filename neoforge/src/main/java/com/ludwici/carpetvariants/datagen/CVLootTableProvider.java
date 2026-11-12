package com.ludwici.carpetvariants.datagen;

import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;
import java.util.Set;

public class CVLootTableProvider extends LootTableProvider {
    public CVLootTableProvider() {
        super(Set.of(), List.of(new SubProviderEntry(CVLootTableGenerator::new, LootContextParamSets.BLOCK)));
    }
}
