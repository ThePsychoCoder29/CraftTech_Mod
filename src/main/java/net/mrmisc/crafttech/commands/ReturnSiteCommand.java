package net.mrmisc.crafttech.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.mrmisc.crafttech.CraftTech;

public class ReturnSiteCommand {
    public ReturnSiteCommand(CommandDispatcher<CommandSourceStack> dispatcher){
        dispatcher.register(Commands.literal("site").then(Commands.literal("return").then(Commands.literal("to")).executes((commandContext -> {
            return returnSite(commandContext.getSource());
        }))));
    }

    private int returnSite(CommandSourceStack source) throws CommandSyntaxException {
        ServerPlayer player = source.getPlayer();
        assert player != null;

        CompoundTag data = player.getPersistentData();
        boolean hasHomePos = data.getIntArray(CraftTech.MOD_ID + "sitepos").length != 0;
        if(hasHomePos){
            int[] playerPos = data.getIntArray(CraftTech.MOD_ID + "sitepos");
            player.teleportTo(playerPos[0], playerPos[1], playerPos[2]);
            source.sendSuccess(()-> Component.literal("Returned to the site"), true);
            return 1;
        }
        else {
            source.sendSuccess(()-> Component.literal("No Site Position has been set !"), true);
            return -1;
        }
    }
}
