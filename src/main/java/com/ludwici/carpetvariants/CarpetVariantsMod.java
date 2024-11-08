package com.ludwici.carpetvariants;

import com.ludwici.carpetvariants.registry.BlockRegistry;
import net.minecraft.block.Block;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static com.ludwici.carpetvariants.registry.BlockRegistry.*;

@Mod("carpetvariants")
public class CarpetVariantsMod
{
    public static final String MODID = "carpetvariants";
    private static final Logger LOGGER = LogManager.getLogger();
    private static Map<String, RegistryObject<Block>> replaceMap = new HashMap<>();

    public CarpetVariantsMod() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        eventBus.addListener(this::setup);
        eventBus.addListener(this::enqueueIMC);
        eventBus.addListener(this::processIMC);
        eventBus.addListener(this::doClientStuff);
        BlockRegistry.BLOCKS.register(eventBus);
        BlockRegistry.ITEMS.register(eventBus);

        MinecraftForge.EVENT_BUS.register(this);

        replaceMap = new HashMap<>();
        replaceMap.put("white_carpet", WHITE_CARPET_VARIANT);
        replaceMap.put("orange_carpet", ORANGE_CARPET_VARIANT);
        replaceMap.put("magenta_carpet", MAGENTA_CARPET_VARIANT);
        replaceMap.put("light_blue_carpet", LIGHT_BLUE_CARPET_VARIANT);
        replaceMap.put("yellow_carpet", YELLOW_CARPET_VARIANT);
        replaceMap.put("lime_carpet", LIME_CARPET_VARIANT);
        replaceMap.put("pink_carpet", PINK_CARPET_VARIANT);
        replaceMap.put("gray_carpet", GRAY_CARPET_VARIANT);
        replaceMap.put("light_gray_carpet", LIGHT_GRAY_CARPET_VARIANT);
        replaceMap.put("cyan_carpet", CYAN_CARPET_VARIANT);
        replaceMap.put("purple_carpet", PURPLE_CARPET_VARIANT);
        replaceMap.put("blue_carpet", BLUE_CARPET_VARIANT);
        replaceMap.put("brown_carpet", BROWN_CARPET_VARIANT);
        replaceMap.put("green_carpet", GREEN_CARPET_VARIANT);
        replaceMap.put("red_carpet", RED_CARPET_VARIANT);
        replaceMap.put("black_carpet", BLACK_CARPET_VARIANT);
    }

    public static Block replace(Block block) {
        String name = Registry.BLOCK.getKey(block).getPath();
        return replaceMap.get(name).get();
    }

    private void setup(final FMLCommonSetupEvent event)
    {
    }

    private void doClientStuff(final FMLClientSetupEvent event)
    {
    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {
        InterModComms.sendTo("carpetvariants", "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
    }

    private void processIMC(final InterModProcessEvent event)
    {
        LOGGER.info("Got IMC {}", event.getIMCStream().
                map(m->m.getMessageSupplier().get()).
                collect(Collectors.toList()));
    }

    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
    }

    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {

        }
    }
}
