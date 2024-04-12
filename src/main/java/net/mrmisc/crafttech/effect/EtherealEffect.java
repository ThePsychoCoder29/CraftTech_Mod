package net.mrmisc.crafttech.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class EtherealEffect extends MobEffect {

    private Level world;

    public EtherealEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        super.applyEffectTick(entity, amplifier);
        if (!world.isClientSide()) {
            if (entity instanceof Player) {
                Player player = (Player) entity;
                player.noPhysics = true;
                super.applyEffectTick(player, 1);
            }
        }
    }
}
