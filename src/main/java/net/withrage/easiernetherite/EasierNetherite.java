package net.withrage.easiernetherite;

import net.fabricmc.api.ModInitializer;
import net.withrage.easiernetherite.events.ModEvents;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EasierNetherite implements ModInitializer {
	public static final String MOD_ID = "easiernetherite";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModEvents.register();
		LOGGER.info("Mod EasierNetherite has been loaded!");
	}
}