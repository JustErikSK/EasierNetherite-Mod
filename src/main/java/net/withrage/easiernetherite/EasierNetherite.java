package net.withrage.easiernetherite;

import com.mojang.logging.LogUtils;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.withrage.easiernetherite.items.ModItems;
import org.slf4j.Logger;

@Mod(EasierNetherite.MOD_ID)
public class EasierNetherite {
	public static final String MOD_ID = "easiernetherite";
	public static final Logger LOGGER = LogUtils.getLogger();

	public EasierNetherite(IEventBus eventBus) {
		ModItems.register(eventBus);
		eventBus.addListener(this::addCreative);
		LOGGER.info("Mod EasierNetherite has been loaded!");
	}

	private void addCreative(BuildCreativeModeTabContentsEvent event) {
		if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
			event.insertAfter(
					new ItemStack(Items.NETHERITE_SCRAP),
					new ItemStack(ModItems.NETHERITE_NUGGET.get()),
					CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS
			);
		}
		if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
			event.insertAfter(
					new ItemStack(ModItems.NETHERITE_NUGGET.get()),
					new ItemStack(ModItems.RAW_NETHERITE.get()),
					CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS
			);
		}
	}
}