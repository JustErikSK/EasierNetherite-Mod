package net.withrage.easiernetherite.items;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.bus.BusGroup;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.withrage.easiernetherite.EasierNetherite;


public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, EasierNetherite.MOD_ID);
    public static final RegistryObject<Item> RAW_NETHERITE = ITEMS.register("raw_netherite", () -> new Item(new Item.Properties().setId(itemKey("raw_netherite"))));

    private static ResourceKey<Item> itemKey(String name) {
        return ResourceKey.create(
                Registries.ITEM,
                Identifier.fromNamespaceAndPath(EasierNetherite.MOD_ID, name)
        );
    }

    public static void register(BusGroup eventBus) {
        ITEMS.register(eventBus);
        EasierNetherite.LOGGER.info("Registering items for Easier Netherite mod...");
    }
}
