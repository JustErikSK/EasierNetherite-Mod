package net.withrage.easiernetherite.items;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.withrage.easiernetherite.EasierNetherite;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(EasierNetherite.MOD_ID);
    public static final DeferredItem<Item> RAW_NETHERITE = ITEMS.register("raw_netherite", () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
        EasierNetherite.LOGGER.info("Registering items for Easier Netherite mod...");
    }
}
