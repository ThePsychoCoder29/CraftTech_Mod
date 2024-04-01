package net.mrmisc.crafttech.item.custom;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.mrmisc.crafttech.entity.custom.TemporaryTeleporterPearlEntity;
import org.jetbrains.annotations.NotNull;


public class TemporaryTeleporterPearlItem extends Item {
    public TemporaryTeleporterPearlItem(Properties pProperties) {
        super(pProperties);
    }
    private Level world;
    public long useTime;
    public double playerX;
    public double playerY;
    public double playerZ;

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, @NotNull InteractionHand pHand) {
        ItemStack stack = pPlayer.getItemInHand(pHand);
        this.playerX = pPlayer.getX();
        this.playerY = pPlayer.getY();
        this.playerZ = pPlayer.getZ();
        this.useTime = world.getGameTime();
        pLevel.playSound(null, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(), SoundEvents.SNOWBALL_THROW, SoundSource.NEUTRAL, 0.5F, 0.4F / (pLevel.getRandom().nextFloat() * 0.4F + 0.8F));
        if (!pLevel.isClientSide) {
            TemporaryTeleporterPearlEntity temporaryTeleporterPearlEntity = new TemporaryTeleporterPearlEntity(pLevel, pPlayer);
            temporaryTeleporterPearlEntity.setItem(stack);
            temporaryTeleporterPearlEntity.shootFromRotation(pPlayer, pPlayer.getXRot(), pPlayer.getYRot(), 0.0F, 1.5F, 1.0F);
            pLevel.addFreshEntity(temporaryTeleporterPearlEntity);
        }

        pPlayer.awardStat(Stats.ITEM_USED.get(this));
        if (!pPlayer.getAbilities().instabuild) {
            stack.shrink(1);
        }

        return InteractionResultHolder.sidedSuccess(stack, pLevel.isClientSide());
    }
}
