package com.ludwici.carpetvariants.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class CVLootTableProvider extends LootTableProvider {
    public CVLootTableProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, Set.of(), List.of(
                new LootTableProvider.SubProviderEntry(CVLootTableGenerator::new, LootContextParamSets.BLOCK)
        ), pRegistries);
    }
}
