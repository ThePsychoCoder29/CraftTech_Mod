package net.mrmisc.crafttech.entity.custom;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.common.util.ITeleporter;
import net.minecraftforge.event.entity.EntityTeleportEvent;
import net.mrmisc.crafttech.entity.ModEntities;
import net.mrmisc.crafttech.item.ModItems;
import net.mrmisc.crafttech.item.custom.TemporaryTeleporterPearlItem;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class TemporaryTeleporterPearlEntity extends ThrowableItemProjectile {
    private Level world;
    public double endTime;

    Entity entity = this.getOwner();
    ServerPlayer player = (ServerPlayer) entity;

    public long cd = 100;
    TemporaryTeleporterPearlItem vars = new TemporaryTeleporterPearlItem(new Item.Properties());
    public TemporaryTeleporterPearlEntity(EntityType<? extends ThrowableItemProjectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }
    public TemporaryTeleporterPearlEntity(Level pLevel) {
        super(ModEntities.TEMPORARY_TELEPORTER_PEARL.get(), pLevel);
    }
    public TemporaryTeleporterPearlEntity(Level pLevel, LivingEntity livingEntity) {
        super(ModEntities.TEMPORARY_TELEPORTER_PEARL.get(), livingEntity, pLevel);
    }

    @Override
    protected @NotNull Item getDefaultItem() {
        return ModItems.TEMPORARY_TELEPORTER_PEARL.get();
    }

    @Override
    protected void onHit(@NotNull HitResult pResult) {
        super.onHit(pResult);
        long currentTime = this.level().getGameTime();
        if(!(currentTime - vars.useTime >= cd)){
        if (!this.level().isClientSide && !this.isRemoved()) {
            Entity entity = this.getOwner();
            if (entity instanceof ServerPlayer serverplayer) {
                if (serverplayer.connection.isAcceptingMessages() && serverplayer.level() == this.level() && !serverplayer.isSleeping()) {
                    EntityTeleportEvent event = new EntityTeleportEvent(entity, this.getX(), this.getY(), this.getZ());
                    if (!event.isCanceled()) {
                        if (entity.isPassenger()) {
                            serverplayer.dismountTo(this.getX(), this.getY(), this.getZ());
                        } else {
                            entity.teleportTo(this.getX(), this.getY(), this.getZ());
                        }

                        entity.teleportTo(event.getTargetX(), event.getTargetY(), event.getTargetZ());
                        entity.resetFallDistance();
                        entity.hurt(this.damageSources().fall(), 5f);
                    }
                }
            }
            else if (entity != null) {
                entity.teleportTo(this.getX(), this.getY(), this.getZ());
                entity.resetFallDistance();
            }
            this.discard();
            }
        }
        entity.teleportTo(vars.playerX, vars.playerY, vars.playerZ);
    }

    public void tick() {
        Entity entity = this.getOwner();
        if (entity instanceof Player && !entity.isAlive()) {
            this.discard();
        } else {
            while (!(endTime - vars.useTime >= cd)) {
                endTime = this.world.getGameTime();
            }
            super.tick();
        }
    }

    @Nullable
    public Entity changeDimension(@NotNull ServerLevel serverLevel, @NotNull ITeleporter iTeleporter) {
        Entity entity = this.getOwner();
        if (entity != null && entity.level().dimension() != serverLevel.dimension()) {
            this.setOwner(null);
        }

        return super.changeDimension(serverLevel, iTeleporter);
    }
}
