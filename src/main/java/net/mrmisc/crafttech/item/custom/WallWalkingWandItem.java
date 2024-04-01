package net.mrmisc.crafttech.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

public class WallWalkingWandItem extends Item {
    public WallWalkingWandItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level world, Player player, @NotNull InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);

        if (player.getCooldowns().isOnCooldown(stack.getItem())) {
            return InteractionResultHolder.fail(stack);
        }
        if (!world.isClientSide) {
            player.getCooldowns().addCooldown(stack.getItem(), 200);
            if (isFacingWall(player)) {
                activateWallWalking(player);
            }
            else if(!player.getCooldowns().isOnCooldown(stack.getItem()) && player.isNoGravity()) {
                deactivateWallWalking(player);
            }
        }
        return InteractionResultHolder.success(stack);
    }

    public static boolean isFacingWall(Player player) {
        BlockPos playerPos = player.blockPosition();
        BlockPos blockPosFront = playerPos.relative(player.getDirection());
        BlockPos blockPosAboveFront = blockPosFront.above();
        Level world = player.getCommandSenderWorld();
        BlockState blockStateFront = world.getBlockState(blockPosFront);
        BlockState blockStateAboveFront = world.getBlockState(blockPosAboveFront);
        return !blockStateFront.isAir() && !blockStateAboveFront.isAir();
    }

    public static void activateWallWalking(Player player) {
        player.setYRot(player.getYRot() + 90);
        player.setXRot(90.0f);
        player.setNoGravity(true);
        Vec3 newPos = new Vec3(player.getX(), player.getY() + 1, player.getZ());
        player.teleportTo(newPos.x, newPos.y, newPos.z);
    }

    private void deactivateWallWalking(Player player) {
        // Example: Reset the player's orientation and gravity to normal
        player.setYRot(player.getYRot() - 90); // Reset the rotation
        player.setNoGravity(false); // Enable gravity
        // You may need to adjust the player's position back to normal
        // Example: Move the player's position back to the ground
        Vec3 newPos = new Vec3(player.getX(), player.getY() - 1, player.getZ()); // Example: Move the player one block down
        player.teleportTo(newPos.x, newPos.y, newPos.z);
    }
}




