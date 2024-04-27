package net.mrmisc.crafttech.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.player.Player;

public class DurationCheckEffect extends MobEffect {
    protected DurationCheckEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        if(!pLivingEntity.level().isClientSide()){
            if(pLivingEntity instanceof Player player){
                player.setSwimming(player.getPose() == Pose.SWIMMING);
            }
        }
        super.applyEffectTick(pLivingEntity, pAmplifier);
    }
}
