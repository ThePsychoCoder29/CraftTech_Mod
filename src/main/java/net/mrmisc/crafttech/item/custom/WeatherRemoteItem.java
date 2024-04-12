package net.mrmisc.crafttech.item.custom;

import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class WeatherRemoteItem extends Item implements WeatherRemoteItemUseMethodInterface {
    public WeatherRemoteItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(Level level, @NotNull Player player, @NotNull InteractionHand hand, CommandSourceStack commandSourceStack) {
        ItemStack stack = player.getItemInHand(hand);
        if (!level.isClientSide()){
            setWeather(level, player, commandSourceStack);
        }
        return InteractionResultHolder.success(stack);
    }

    public void setWeather(Level level , Player player, CommandSourceStack sourceStack) {
        if(!level.isClientSide()){
            if(player.isShiftKeyDown()) {
                setRain(sourceStack);
            }
            if(player.getPose() == Pose.STANDING) {
                setThunder(sourceStack);
            }
        }
    }

    private static void setRain(CommandSourceStack pSource) {
        pSource.getLevel().setWeatherParameters(0, 200, true, false);
        pSource.sendSuccess(() -> Component.translatable("item.crafttech.weather_remote.rain"), true);
    }

    private static void setThunder(CommandSourceStack pSource) {
        pSource.getLevel().setWeatherParameters(0, 200, true, true);
        pSource.sendSuccess(() -> Component.translatable("item.crafttech.weather_remote.thunder"), true);
    }
}
