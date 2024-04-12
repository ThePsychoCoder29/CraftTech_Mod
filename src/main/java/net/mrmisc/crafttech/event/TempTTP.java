/*package net.mrmisc.crafttech.event;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class TemporaryTeleporterPearlEvent {

    private static final String POS_X_KEY = "pPosX";
    private static final String POS_Y_KEY = "pPosY";
    private static final String POS_Z_KEY = "pPosZ";
    private static final String TICKER_TIME_KEY = "tickerTime";

    @SubscribeEvent
    public static void playerData(PlayerEvent event) {
        Player player = event.getEntity();
        CompoundTag playerDataWriter = player.getPersistentData();
        playerDataWriter.putDouble(POS_X_KEY, player.getX());
        playerDataWriter.putDouble(POS_Y_KEY, player.getY());
        playerDataWriter.putDouble(POS_Z_KEY, player.getZ());
        playerDataWriter.putInt(TICKER_TIME_KEY, 1);
    }

    @SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
    public static void onPlayerTick(TickEvent.PlayerTickEvent tickEvent) {
        if (tickEvent.phase == TickEvent.Phase.START) {
            Player player = tickEvent.player;

            CompoundTag playerData = player.getPersistentData();
            int tickerTime = playerData.getInt(TICKER_TIME_KEY);

            if (tickerTime < 100) {
                tickerTime++;
                playerData.putInt(TICKER_TIME_KEY, tickerTime);
            } else {
                playerData.putInt(TICKER_TIME_KEY, 0);
                double posX = playerData.getDouble(POS_X_KEY);
                double posY = playerData.getDouble(POS_Y_KEY);
                double posZ = playerData.getDouble(POS_Z_KEY);
                player.teleportTo(posX, posY, posZ);
            }
        }
    }
}
*/
