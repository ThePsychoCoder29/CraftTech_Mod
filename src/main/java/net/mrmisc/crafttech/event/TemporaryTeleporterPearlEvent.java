package net.mrmisc.crafttech.event;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class TemporaryTeleporterPearlEvent {
    private static boolean eventActive = false;
    private static final String POS_X_KEY = "pPosX";
    private static final String POS_Y_KEY = "pPosY";
    private static final String POS_Z_KEY = "pPosZ";
    private static final String TELEPORT_TICKS_KEY = "teleportTicks";

    @SubscribeEvent
    public static void playerData(PlayerEvent event) {
        Player player = event.getEntity();
        CompoundTag playerDataWriter = player.getPersistentData();
        playerDataWriter.putDouble(POS_X_KEY, player.getX());
        playerDataWriter.putDouble(POS_Y_KEY, player.getY());
        playerDataWriter.putDouble(POS_Z_KEY, player.getZ());
    }

    @SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
    public static void onPlayerTick(TickEvent.PlayerTickEvent tickEvent) {
        if (tickEvent.phase == TickEvent.Phase.START) {
            Player player = tickEvent.player;
            CompoundTag playerData = player.getPersistentData();

            if (playerData.contains(TELEPORT_TICKS_KEY)) {
                int teleportTicks = playerData.getInt(TELEPORT_TICKS_KEY);
                if (teleportTicks > 0) {
                    teleportTicks--;
                    eventActive = true;
                    if (teleportTicks == 0) {
                        double posX = playerData.getDouble(POS_X_KEY);
                        double posY = playerData.getDouble(POS_Y_KEY);
                        double posZ = playerData.getDouble(POS_Z_KEY);
                        player.teleportTo(posX, posY, posZ);
                        eventActive = false;
                    }

                    playerData.putInt(TELEPORT_TICKS_KEY, teleportTicks);
                }
            }
        }
    }

    public static void setTeleportTicks(Player player, int ticks) {
        CompoundTag playerData = player.getPersistentData();
        playerData.putInt(TELEPORT_TICKS_KEY, ticks);
        onPlayerTick(new TickEvent.PlayerTickEvent(TickEvent.Phase.START, player));
        if(!eventActive && playerData.getInt(TELEPORT_TICKS_KEY) == 0){
            onPlayerTick(new TickEvent.PlayerTickEvent(TickEvent.Phase.END, player));
            eventActive = true;
        }
        else if (!eventActive && playerData.getInt(TELEPORT_TICKS_KEY) != 0) {
            eventActive = false;
        }
    }
}
