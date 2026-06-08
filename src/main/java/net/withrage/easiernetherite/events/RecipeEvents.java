package net.withrage.easiernetherite.events;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.RecipeMap;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.server.ServerAboutToStartEvent;
import net.withrage.easiernetherite.EasierNetherite;

import java.lang.reflect.Field;
import java.util.List;

@EventBusSubscriber(modid = EasierNetherite.MOD_ID)
public class RecipeEvents {

    private static final ResourceKey<Recipe<?>> NETHERITE_INGOT =
            ResourceKey.create(
                    Registries.RECIPE,
                    Identifier.fromNamespaceAndPath("minecraft", "netherite_ingot")
            );

    @SubscribeEvent
    public static void removeRecipes(ServerAboutToStartEvent event) {
        RecipeManager recipeManager = event.getServer().getRecipeManager();

        List<RecipeHolder<?>> filteredRecipes = recipeManager.getRecipes()
                .stream()
                .filter(recipe -> !recipe.id().equals(NETHERITE_INGOT))
                .toList();

        try {
            Field recipesField = RecipeManager.class.getDeclaredField("recipes");
            recipesField.setAccessible(true);

            recipesField.set(recipeManager, RecipeMap.create(filteredRecipes));

            EasierNetherite.LOGGER.info("Removed vanilla Netherite Ingot recipe.");
        } catch (Exception e) {
            EasierNetherite.LOGGER.error("Failed to remove vanilla Netherite Ingot recipe.", e);
        }
    }
}