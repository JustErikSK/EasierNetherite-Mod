package net.withrage.easiernetherite.mixin;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeMap;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.stream.Stream;

@Mixin(RecipeMap.class)
public class RecipeMapMixin {

    @Redirect(
            method = "create",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/core/HolderLookup;listElements()Ljava/util/stream/Stream;"
            )
    )
    private static Stream<? extends Holder.Reference<Recipe<?>>> easierNetherite$removeVanillaNetheriteRecipe(
            HolderLookup<Recipe<?>> recipes
    ) {
        return recipes.listElements()
                .filter(recipe ->
                        !recipe.key().identifier().equals(
                                Identifier.fromNamespaceAndPath(
                                        "minecraft",
                                        "netherite_ingot"
                                )
                        )
                );
    }
}