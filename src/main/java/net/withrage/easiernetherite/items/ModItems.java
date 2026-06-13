package net.withrage.easiernetherite.items;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.withrage.easiernetherite.EasierNetherite;


public class ModItems {
    public static final Item RAW_NETHERITE = registerItem("raw_netherite", new Item(new FabricItemSettings()));
    public static final Item NETHERITE_NUGGET = registerItem("netherite_nugget", new Item(new FabricItemSettings()));

    public static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier("easiernetherite", name), item);
    }

    public static void register() {
        EasierNetherite.LOGGER.info("Registering items for Easier Netherite mod...");
    }
}
