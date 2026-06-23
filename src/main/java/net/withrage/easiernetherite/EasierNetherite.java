package net.withrage.easiernetherite;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;
import net.withrage.easiernetherite.items.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EasierNetherite implements ModInitializer {
	public static final String MOD_ID = "easiernetherite";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.register();
		LOGGER.info("Mod EasierNetherite has been loaded!");

		CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register(output -> {
			output.insertAfter(Items.NETHERITE_SCRAP, ModItems.NETHERITE_NUGGET);
		});

		CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register(output -> {
			output.insertAfter(ModItems.NETHERITE_NUGGET, ModItems.RAW_NETHERITE);
		});
	}
}