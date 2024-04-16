//package net.mrmisc.crafttech.entity.custom;
//
//import net.minecraft.world.entity.Entity;
//import net.minecraft.world.entity.EntityType;
//import net.minecraft.world.entity.LivingEntity;
//import net.minecraft.world.entity.player.Player;
//import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
//import net.minecraft.world.item.Item;
//import net.minecraft.world.level.Level;
//import net.minecraft.world.phys.BlockHitResult;
//import net.mrmisc.crafttech.entity.ModEntities;
//import net.mrmisc.crafttech.item.ModItems;
//import org.jetbrains.annotations.NotNull;
//
//public class TemporaryTeleporterPearlProjectileEntity extends ThrowableItemProjectile {
//    public TemporaryTeleporterPearlProjectileEntity(EntityType<? extends ThrowableItemProjectile> pEntityType, Level pLevel) {
//        super(pEntityType, pLevel);
//    }
//    public TemporaryTeleporterPearlProjectileEntity(Level level) {
//        super(ModEntities.TEMPORARY_TELEPORTER_PEARL.get(), level);
//    }
//    public TemporaryTeleporterPearlProjectileEntity(LivingEntity livingEntity , Level Level) {
//        super(ModEntities.TEMPORARY_TELEPORTER_PEARL.get(), livingEntity, Level);
//    }
//
//    @Override
//    protected @NotNull Item getDefaultItem() {
//        return ModItems.TEMPORARY_TELEPORTER_PEARL.get();
//    }
//
//    @Override
//    protected void onHitBlock(@NotNull BlockHitResult blockHit) {
//        Player player = (Player) this.getOwner();
//        if (player != null && !this.level().isClientSide() && !this.isRemoved()) {
//            TemporaryTeleporterPearlEvent.setTeleportTicks(player, 100); // Teleport after 5 seconds (100 ticks)
//
//            double newPosX = blockHit.getBlockPos().getX() + 0.5;
//            double newPosY = blockHit.getBlockPos().getY() + 1;
//            double newPosZ = blockHit.getBlockPos().getZ() + 0.5;
//
//            player.teleportTo(newPosX, newPosY, newPosZ);
//        }
//        this.discard();
//        super.onHitBlock(blockHit);
//    }
//
//    public void tick() {
//        Entity entity = this.getOwner();
//        if (entity instanceof Player && !entity.isAlive()) {
//            this.discard();
//        } else {
//            super.tick();
//        }
//
//    }
//
//}
