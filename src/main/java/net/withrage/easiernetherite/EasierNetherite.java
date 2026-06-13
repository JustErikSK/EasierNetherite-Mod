package net.withrage.easiernetherite;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
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

		ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
			entries.addAfter(Items.NETHERITE_SCRAP, ModItems.NETHERITE_NUGGET);
		});

		ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
			entries.addAfter(ModItems.NETHERITE_NUGGET, ModItems.RAW_NETHERITE);
		});
	}
}