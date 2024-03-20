package net.mrmisc.crafttech.item.custom;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class HarmonicPacifierItem extends Item {

    private static final int PACIFICATION_DURATION = 200;


    public HarmonicPacifierItem(Properties pProperties) {
        super(pProperties);

    }


    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(Level world, Player pPlayer, @NotNull InteractionHand pHand) {
        ItemStack stack = pPlayer.getItemInHand(pHand);
        pPlayer.getCooldowns().addCooldown(this, 200);

        if (!world.isClientSide) {
            playLullabySound(world, pPlayer);

            freezeEntities(world, pPlayer);
        }

        stack.shrink(1);
        return InteractionResultHolder.sidedSuccess(stack, world.isClientSide());
    }

    private void playLullabySound(Level world, Player player) {
        SoundEvent soundEvent = SoundEvents.MUSIC_DISC_WAIT;

        world.playSound(null, player.getX(), player.getY(), player.getZ(), soundEvent, player.getSoundSource(), 1.0f, 1.0f);
    }


    public void stopLullabySound(Level world, Player player) {
        SoundEvent soundEvent = SoundEvents.MUSIC_DISC_WAIT;
        world.playSound(null, player.getX(), player.getY(), player.getZ(), soundEvent, player.getSoundSource(), 0.0f, 0.0f);
    }


    private void freezeEntities(Level world, Player player) {
        AABB areaOfEffect = player.getBoundingBox().inflate(5.0);
        List<Entity> entities = world.getEntitiesOfClass(Entity.class, areaOfEffect,
                entity -> entity instanceof LivingEntity && !(entity instanceof Player) && entity.isAlive());

        Map<LivingEntity, Long> pacifiedEntities = new HashMap<>();

        for (Entity entity : entities) {
            if (entity instanceof LivingEntity livingEntity) {
                if (livingEntity instanceof Zombie ||
                        livingEntity instanceof Creeper || livingEntity instanceof AbstractSkeleton ||
                        livingEntity instanceof Spider || livingEntity instanceof CaveSpider) {
                    AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "Frozen", -0.7, AttributeModifier.Operation.ADDITION);
                    livingEntity.getAttribute(Attributes.MOVEMENT_SPEED).addTransientModifier(modifier);

                    ((Monster) livingEntity).setTarget(null);
                    livingEntity.setLastHurtByMob(null);
                    pacifiedEntities.put(livingEntity, world.getGameTime());
                }
            }
        }

        long currentTime = world.getGameTime();
        Iterator<Map.Entry<LivingEntity, Long>> iterator = pacifiedEntities.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<LivingEntity, Long> entry = iterator.next();
            LivingEntity entity = entry.getKey();
            long startTime = entry.getValue();
            if (currentTime - startTime >= PACIFICATION_DURATION) {
                entity.getAttribute(Attributes.MOVEMENT_SPEED).removeModifier(UUID.fromString("Frozen"));

                ((Monster) entity).setTarget(player);
                entity.setLastHurtByMob(player);

                stopLullabySound(world, player);

                iterator.remove();
            }
        }
    }

}
