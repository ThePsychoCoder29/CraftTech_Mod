package net.mrmisc.crafttech.item.custom;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.mrmisc.crafttech.effect.ModEffects;
import net.minecraft.world.effect.MobEffectInstance;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class HarmonicPacifierItem extends Item {
    private static final int EFFECT_RADIUS = 10; // Adjust as needed
    private static final int FREEZE_DURATION = 200; // 10 seconds (20 ticks per second)

    public HarmonicPacifierItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level world, Player player, @NotNull InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);

        if (player.getCooldowns().isOnCooldown(stack.getItem())) {
            return InteractionResultHolder.fail(stack);
        }

        if (!world.isClientSide) {
            applyFreezeEffect(world, player);
            player.getCooldowns().addCooldown(stack.getItem(), FREEZE_DURATION);
            stack.shrink(1);
        }

        return InteractionResultHolder.success(stack);
    }

    private void applyFreezeEffect(Level world, Player player) {
        AABB areaOfEffect = player.getBoundingBox().inflate(EFFECT_RADIUS);
        List<Monster> entities = world.getEntitiesOfClass(Monster.class, areaOfEffect);
        List<Monster> entitiesCopy = new ArrayList<>(entities);
        for (Monster entity : entitiesCopy) {
            entity.addEffect(new MobEffectInstance(ModEffects.FREEZE.get(), FREEZE_DURATION, 1));
        }
    }
}
