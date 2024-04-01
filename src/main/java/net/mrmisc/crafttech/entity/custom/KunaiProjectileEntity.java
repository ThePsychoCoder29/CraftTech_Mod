package net.mrmisc.crafttech.entity.custom;

import net.minecraft.core.Holder;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageSources;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.mrmisc.crafttech.entity.ModEntities;
import net.mrmisc.crafttech.item.ModItems;
import org.jetbrains.annotations.NotNull;

public class KunaiProjectileEntity extends ThrowableItemProjectile {
    public KunaiProjectileEntity(EntityType<? extends ThrowableItemProjectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }
    public KunaiProjectileEntity(Level pLevel) {
        super(ModEntities.KUNAI.get(), pLevel);
    }

    public KunaiProjectileEntity(Level pLevel, LivingEntity livingEntity) {
        super(ModEntities.KUNAI.get(), livingEntity, pLevel);
    }

    @Override
    protected @NotNull Item getDefaultItem() {
        return ModItems.KUNAI.get();
    }


    @Override
    protected void onHitEntity(@NotNull EntityHitResult pResult) {

        if(!this.level().isClientSide) {
            pResult.getEntity().hurt(this.damageSources().thrown(this, this.getOwner()), 5f);
        }
        super.onHitEntity(pResult);
    }
}
