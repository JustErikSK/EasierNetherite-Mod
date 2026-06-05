package net.withrage.easiernetherite;

import com.mojang.logging.LogUtils;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.bus.BusGroup;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.withrage.easiernetherite.items.ModItems;
import org.slf4j.Logger;

@Mod(EasierNetherite.MOD_ID)
public class EasierNetherite {
	public static final String MOD_ID = "easiernetherite";
	public static final Logger LOGGER = LogUtils.getLogger();

	public EasierNetherite(FMLJavaModLoadingContext context) {
		BusGroup eventBus = context.getModBusGroup();
		ModItems.register(eventBus);
		BuildCreativeModeTabContentsEvent.BUS.addListener(this::addCreative);
		LOGGER.info("Mod EasierNetherite has been loaded!");
	}

	private void addCreative(BuildCreativeModeTabContentsEvent event) {
		if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
			event.getEntries().putAfter(
					new ItemStack(Items.NETHERITE_SCRAP),
					new ItemStack(ModItems.RAW_NETHERITE.get()),
					CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS
			);
		}
	}
}