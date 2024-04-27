package net.mrmisc.crafttech.item.custom;

import com.mojang.authlib.GameProfile;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public class PlayerLogicHandler extends Player {
    private boolean canTakeItem = true;
    public PlayerLogicHandler(Level pLevel, BlockPos pPos, float pYRot, GameProfile pGameProfile) {
        super(pLevel, pPos, pYRot, pGameProfile);
    }

    @Override
    public boolean isSpectator() {
        return false;
    }

    @Override
    public boolean isCreative() {
        return false;
    }

    public void setCanTakeItem(boolean canTakeItem) {
        this.canTakeItem = canTakeItem;
    }

    @Override
    public boolean canTakeItem(ItemStack stack) {
        return canTakeItem && super.canTakeItem(stack);
    }
}
