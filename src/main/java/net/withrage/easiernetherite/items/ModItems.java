package net.withrage.easiernetherite.items;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.withrage.easiernetherite.EasierNetherite;


public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, EasierNetherite.MOD_ID);
    public static final RegistryObject<Item> RAW_NETHERITE = ITEMS.register("raw_netherite", () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
        EasierNetherite.LOGGER.info("Registering items for Easier Netherite mod...");
    }
}
