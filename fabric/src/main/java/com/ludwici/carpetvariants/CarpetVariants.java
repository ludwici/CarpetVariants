package com.ludwici.carpetvariants;

import com.ludwici.carpetvariants.registry.BlockRegistry;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CarpetVariants implements ModInitializer {
	public static final String MOD_ID = "carpetvariants";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		BlockRegistry.initialize();
	}
}