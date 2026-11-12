package com.ludwici.carpetvariants.datagen;

import com.ludwici.carpetvariants.CarpetVariantsMod;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;

import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.neoforged.neoforge.data.event.GatherDataRegistryEntriesEvent;
import net.minecraft.core.registries.Registries;

@EventBusSubscriber(modid = CarpetVariantsMod.MODID)
public class DataGeneration {

    @SubscribeEvent
    public static void onGatherData(GatherDataEvent.Client event) {
        event.createProvider(CVBlockStateProvider::new);
    }

    @SubscribeEvent
    public static void onGatherDataRegistryEntries(GatherDataRegistryEntriesEvent event) {
        event.add(Registries.LOOT_TABLE, new CVLootTableProvider());
    }

}
