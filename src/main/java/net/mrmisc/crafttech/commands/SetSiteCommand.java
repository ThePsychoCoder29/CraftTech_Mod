package net.mrmisc.crafttech.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.mrmisc.crafttech.CraftTech;

public class SetSiteCommand {
    public SetSiteCommand(CommandDispatcher<CommandSourceStack> dispatcher){
        dispatcher.register(Commands.literal("site").then(Commands.literal("set").executes((commandContext -> {
            return setSite(commandContext.getSource());
        }))));
    }

    private int setSite(CommandSourceStack source) throws CommandSyntaxException {
        ServerPlayer player = source.getPlayer();
        assert player != null;
        BlockPos playerPos = player.getOnPos();
        String pos = "(" + playerPos.getX() + "," + playerPos.getY() + "," + playerPos.getZ() + ")";

        CompoundTag data = player.getPersistentData();
        data.putIntArray(CraftTech.MOD_ID + "sitepos",
                new int[]{playerPos.getX(), playerPos.getY(), playerPos.getZ()});

        source.sendSuccess(()-> Component.literal("Set the Site Position at " + pos), true);
        return 1;
    }
}
