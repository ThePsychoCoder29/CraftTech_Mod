package net.mrmisc.crafttech.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.entity.ai.goal.Goal;
import org.jetbrains.annotations.NotNull;
public class FreezeEffect extends MobEffect {
    private static final int DURATION_TICKS = 200;
    public FreezeEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }
    @Override
    public void applyEffectTick(@NotNull LivingEntity entity, int amplifier) {
        if (entity instanceof Zombie || entity instanceof Husk || entity instanceof Creeper ||
                entity instanceof AbstractSkeleton ||
                entity instanceof Spider || entity instanceof CaveSpider) {
            double x = entity.getX();
            double y = entity.getY();
            double z = entity.getZ();
            entity.teleportTo(x, y, z);
            entity.setDeltaMovement(0, 0, 0);
            ((Monster) entity).getNavigation().stop();
            ((Monster) entity).setTarget(null);
            ((Monster) entity).goalSelector.disableControlFlag(Goal.Flag.TARGET);
            ((Monster) entity).targetSelector.disableControlFlag(Goal.Flag.TARGET);
        }
    }
    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return duration % DURATION_TICKS == 0;
    }
}