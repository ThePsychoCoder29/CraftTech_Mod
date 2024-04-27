package net.mrmisc.crafttech.item.custom;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class PetHypnotizerWandItem extends Item {
    public PetHypnotizerWandItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public @NotNull InteractionResult interactLivingEntity(@NotNull ItemStack pStack, Player player, @NotNull LivingEntity entity, @NotNull InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        if (player.level() instanceof ServerLevel level &&
                entity instanceof TamableAnimal newTamableAnimal) {
            if (stack.hasTag()) {
                CompoundTag data = stack.getTag();
                if (data.contains("tamed") &&
                        level.getEntity(data.getUUID("tamed")) instanceof TamableAnimal prevTamedAnimal) {
                    prevTamedAnimal.setTame(false);
                    prevTamedAnimal.setInSittingPose(false);
                }
            }
            newTamableAnimal.tame(player);
            stack.getOrCreateTag().putUUID("tamed", entity.getUUID());
            player.sendSystemMessage(Component.literal(stack.getTag().getUUID("tamed").toString()));
        }
        return InteractionResult.SUCCESS;
    }
}
