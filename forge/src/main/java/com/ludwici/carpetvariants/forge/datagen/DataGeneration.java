package com.ludwici.carpetvariants.forge.datagen;

import com.ludwici.carpetvariants.CarpetVariantsMod;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = CarpetVariantsMod.MODID)
public class DataGeneration {

    @SubscribeEvent
    public static void onGatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        generator.addProvider(new CVBlockStateProvider(generator, existingFileHelper));
        generator.addProvider(new CVLootTableProvider(generator));
    }

}