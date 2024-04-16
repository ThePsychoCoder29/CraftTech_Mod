package net.mrmisc.crafttech.effect;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameType;
import net.mrmisc.crafttech.CraftTech;

import java.util.Random;

public class GamemodeEffect extends MobEffect {
    Random randomInt = new Random();
    int gamemode = randomInt.nextInt(11);
    public GamemodeEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        if(pLivingEntity instanceof Player) {
            if (pLivingEntity instanceof ServerPlayer) {
                if (gamemode == 1 || gamemode == 2) {
                    ((ServerPlayer) pLivingEntity).setGameMode(GameType.CREATIVE);
                } else if (gamemode == 3 || gamemode == 4 || gamemode == 5) {
                    ((ServerPlayer) pLivingEntity).setGameMode(GameType.SPECTATOR);
                }else if (gamemode == 6 || gamemode == 7) {
                    ((ServerPlayer) pLivingEntity).setGameMode(GameType.ADVENTURE);
                }
                else {
                    ((ServerPlayer) pLivingEntity).setGameMode(GameType.SURVIVAL);
                }
            }
        }
        super.applyEffectTick(pLivingEntity, pAmplifier);
    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return true;
    }
}
