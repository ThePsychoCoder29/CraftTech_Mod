package net.mrmisc.crafttech.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.mrmisc.crafttech.effect.ModEffects;
import net.mrmisc.crafttech.entity.ModEntities;
import net.mrmisc.crafttech.item.ModItems;
import org.jetbrains.annotations.NotNull;
import java.util.Random;

public class TemporaryTeleporterPearlProjectileEntity extends ThrowableItemProjectile {
    public TemporaryTeleporterPearlProjectileEntity(EntityType<? extends ThrowableItemProjectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }
    public TemporaryTeleporterPearlProjectileEntity(Level level) {
        super(ModEntities.TEMPORARY_TELEPORTER_PEARL.get(), level);
    }
    public TemporaryTeleporterPearlProjectileEntity(LivingEntity livingEntity , Level Level) {
        super(ModEntities.TEMPORARY_TELEPORTER_PEARL.get(), livingEntity, Level);
    }

    @Override
    protected @NotNull Item getDefaultItem() {
        return ModItems.TEMPORARY_TELEPORTER_PEARL.get();
    }

    @Override
    protected void onHitBlock(@NotNull BlockHitResult blockHit) {
        if(!(this.getOwner() instanceof Player player)){
            return;
        }
        BlockPos blockPos = player.blockPosition();
        int playerOldX = blockPos.getX();
        int playerOldY = blockPos.getY();
        int playerOldZ = blockPos.getZ();
        Random random = new Random();
        MobEffect[] effects = {
                MobEffects.BLINDNESS,
                MobEffects.WEAKNESS,
                MobEffects.CONFUSION,
                MobEffects.DARKNESS,
                MobEffects.MOVEMENT_SLOWDOWN,
                MobEffects.DIG_SLOWDOWN,
                MobEffects.POISON
        };

        if (!this.level().isClientSide() && !this.isRemoved()) {
            double newPosX = blockHit.getBlockPos().getX() + 0.5;
            double newPosY = blockHit.getBlockPos().getY() + 1;
            double newPosZ = blockHit.getBlockPos().getZ() + 0.5;
            MobEffect randomEffect = effects[random.nextInt(effects.length)];
            MobEffect durationCheck = ModEffects.DURATION_CHECK.get();
            MobEffectInstance mobEffectInstance = new MobEffectInstance(randomEffect, 100, 1);
            MobEffectInstance mobEffectInstanceDurationCheck = new MobEffectInstance(durationCheck, 100, 1, false, false, false);
            player.teleportTo(newPosX, newPosY, newPosZ);
            player.addEffect(mobEffectInstance);
            player.addEffect(mobEffectInstanceDurationCheck);
            if(player.hasEffect(randomEffect) && player.hasEffect(durationCheck)) {
                double effectDuration = mobEffectInstance.getDuration();
                double effectDurationOfChecker = mobEffectInstanceDurationCheck.getDuration();
                if(effectDuration <= 1 && effectDurationOfChecker <= 1){
                    player.teleportTo(playerOldX, playerOldY, playerOldZ);
                    player.removeEffect(mobEffectInstance.getEffect());
                }
            }
        }

        this.discard();
        super.onHitBlock(blockHit);
    }

    @Override
    public void tick() {
        Player player = ((Player) this.getOwner());
        if (player instanceof Player && !player.isAlive()) {
            this.discard();
        } else {
            super.tick();
        }
    }
}