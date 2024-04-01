package net.mrmisc.crafttech.item.custom;

import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.mrmisc.crafttech.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.List;


public class OreExtractorItem extends Item {

    private Level world;

    public OreExtractorItem(Properties pProperties) {
        super(pProperties);

    }



    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Level world = pContext.getLevel();
        this.world = world;
        if(!pContext.getLevel().isClientSide()) {
            BlockPos positionClicked = pContext.getClickedPos();
            Player player = pContext.getPlayer();
            boolean foundBlock = false;

            for(int i = 0; i<= positionClicked.getY() + 64; i++) {
                BlockPos targetPos = positionClicked.below(i);
                BlockState state = pContext.getLevel().getBlockState(targetPos);

                if (isValuableBlock(state)) {
                    outputValuableCoordinates(targetPos, player, state.getBlock());
                    foundBlock = true;
                    break;
                }

            }

            if(!foundBlock) {
                player.sendSystemMessage(Component.literal("No Valuables Found"));
            }


        }

        pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(),
                player -> player.broadcastBreakEvent(player.getUsedItemHand()));

        return InteractionResult.SUCCESS;
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("tooltip.crafttech.ore_extractor.tooltip"));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

    private void outputValuableCoordinates(BlockPos blockPos, Player player, Block block) {
        ItemStack itemStack = new ItemStack(block.asItem(), 1);
        player.getInventory().add(itemStack);

        world.destroyBlock(blockPos, false);
        player.sendSystemMessage(Component.literal("Found " + I18n.get(block.getDescriptionId()) + " at " +
                blockPos.getX() + " " + blockPos.getY() + " " + blockPos.getZ() + " " + "and was added to the inventory"));
    }

    private boolean isValuableBlock(BlockState state) {
        return state.is(ModTags.Blocks.ORE_EXTRACTOR_VALUABLES);
    }
}
