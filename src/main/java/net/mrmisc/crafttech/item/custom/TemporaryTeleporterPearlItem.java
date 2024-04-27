package net.mrmisc.crafttech.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.mrmisc.crafttech.entity.custom.TemporaryTeleporterPearlProjectileEntity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class TemporaryTeleporterPearlItem extends Item {
    public TemporaryTeleporterPearlItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        ItemStack stack = player.getItemInHand(usedHand);
        level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.ENDER_PEARL_THROW, SoundSource.NEUTRAL, 0.5f, 0.4f / (level.getRandom().nextFloat() * 0.4F + 0.8F));
        if(!level.isClientSide()){
            if (player.getCooldowns().isOnCooldown(stack.getItem())) {
                return InteractionResultHolder.fail(stack);
            }
            player.getCooldowns().addCooldown(stack.getItem(), 160);
            TemporaryTeleporterPearlProjectileEntity teleporterPearl = new TemporaryTeleporterPearlProjectileEntity(player, level);
            teleporterPearl.setItem(stack);
            teleporterPearl.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 1.5F, 1.0F);
            level.addFreshEntity(teleporterPearl);

            player.awardStat(Stats.ITEM_USED.get(this));
            if (!player.getAbilities().instabuild) {
                stack.shrink(1);
            }
        }
        return InteractionResultHolder.sidedSuccess(stack, level.isClientSide());
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @Nullable Level pLevel, @NotNull List<Component> pTooltipComponents, @NotNull TooltipFlag pIsAdvanced) {
        if(Screen.hasShiftDown()){
            pTooltipComponents.add(Component.translatable("tooltip.crafttech.temporary_teleporter_pearl_item_shift.tooltip").withStyle(ChatFormatting.BLUE));
        }
        else {
            pTooltipComponents.add(Component.translatable("tooltip.crafttech.temporary_teleporter_pearl_item.tooltip").withStyle(ChatFormatting.BLUE));
        }
        super.appendHoverText(stack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
