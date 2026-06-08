package net.withrage.easiernetherite.events;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.server.ServerAboutToStartEvent;
import net.withrage.easiernetherite.EasierNetherite;

import java.util.List;

@EventBusSubscriber(modid = EasierNetherite.MOD_ID)
public class RecipeEvents {

    private static final ResourceLocation NETHERITE_INGOT =
            ResourceLocation.fromNamespaceAndPath("minecraft", "netherite_ingot");

    @SubscribeEvent
    public static void removeRecipes(ServerAboutToStartEvent event) {
        List<RecipeHolder<?>> filteredRecipes = event.getServer()
                .getRecipeManager()
                .getRecipes()
                .stream()
                .filter(recipe -> !recipe.id().equals(NETHERITE_INGOT))
                .toList();

        event.getServer().getRecipeManager().replaceRecipes(filteredRecipes);
    }
}