package net.mrmisc.crafttech.item.custom;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.mrmisc.crafttech.effect.ModEffects;
import org.jetbrains.annotations.NotNull;
public class EtherealElixirItem extends Item {
    public EtherealElixirItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, @NotNull InteractionHand pUsedHand) {
        ItemStack stack = pPlayer.getItemInHand(pUsedHand);
        if(!pLevel.isClientSide()){
            getUseAnimation(stack);
            applyEtherealEffect(stack, pLevel, pPlayer);
        }
        return InteractionResultHolder.success(stack);
    }

    @Override
    public @NotNull UseAnim getUseAnimation(@NotNull ItemStack pStack) {
        return UseAnim.DRINK;
    }
    private void applyEtherealEffect(ItemStack stack, Level world, LivingEntity livingEntity){
        if(!world.isClientSide()) {
            if (livingEntity instanceof Player player) {
                player.addEffect(new MobEffectInstance(ModEffects.ETHEREAL.get(), 200));
                stack.shrink(1);

            }
        }
    }


}
