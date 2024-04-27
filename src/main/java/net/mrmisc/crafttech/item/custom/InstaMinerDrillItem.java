package net.mrmisc.crafttech.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class InstaMinerDrillItem extends Item {
    public InstaMinerDrillItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public @NotNull InteractionResult useOn(UseOnContext pContext) {
        int blockX = pContext.getClickedPos().getX();
        int blockY = pContext.getClickedPos().getY();
        int blockZ = pContext.getClickedPos().getZ();
        BlockPos pos = new BlockPos(blockX, blockY, blockZ);
        Level world = pContext.getLevel();
        Player player = pContext.getPlayer();
        InteractionHand hand = pContext.getHand();
        assert player != null;
        ItemStack stack = player.getItemInHand(hand);
        if (!world.isClientSide()) {
            if (player.getItemInHand(hand) == stack) {
                pContext.getLevel().destroyBlock(pos, false);
            }
        }
        pContext.getItemInHand().hurtAndBreak(1, Objects.requireNonNull(pContext.getPlayer()),
                playerItemInHand -> playerItemInHand.broadcastBreakEvent(playerItemInHand.getUsedItemHand()));
        return InteractionResult.SUCCESS;
    }
}