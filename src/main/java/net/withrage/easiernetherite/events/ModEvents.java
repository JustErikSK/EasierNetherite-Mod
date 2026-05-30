package net.withrage.easiernetherite.events;

import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class ModEvents {
    public static void register() {
        PlayerBlockBreakEvents.AFTER.register(
                ((world, player, pos, state, blockEntity) -> {
                    if (world.isClient()) return;
                    if (!state.isOf(Blocks.ANCIENT_DEBRIS)) return;

                    ItemStack tool = player.getMainHandStack();

                    int silkTouch = EnchantmentHelper.getLevel(Enchantments.SILK_TOUCH, tool);
                    if (silkTouch > 0) {
                        return;
                    }

                    int fortune = EnchantmentHelper.getLevel(Enchantments.FORTUNE, tool);
                    int amount = 1;
                    if (fortune > 0) {
                        amount += world.random.nextInt(fortune + 1);
                    }

                    Block.dropStack(world, pos, new ItemStack(Items.NETHERITE_SCRAP, amount));
                })
        );
    }
}
