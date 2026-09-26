package net.withrage.easiernetherite.items;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.withrage.easiernetherite.EasierNetherite;
import java.util.function.Function;


public class ModItems {
    public static final Item RAW_NETHERITE = registerItem("raw_netherite");
    public static final Item NETHERITE_NUGGET = registerItem("netherite_nugget");

    public static Item registerItem(String name) {
        return register(name, Item::new, new Item.Properties());
    }

    private static <T extends Item> T register(String name, Function<Item.Properties, T> factory, Item.Properties properties) {
        ResourceKey<Item> itemKey = ResourceKey.create(
                Registries.ITEM,
                Identifier.fromNamespaceAndPath(EasierNetherite.MOD_ID, name)
        );

        T item = factory.apply(properties.setId(itemKey));
        return Registry.register(BuiltInRegistries.ITEM, itemKey, item);
    }

    public static void register() {
        EasierNetherite.LOGGER.info("Registering items for Easier Netherite mod...");
    }
}
