package net.mrmisc.crafttech.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class RapidityBlock extends Block {
    public RapidityBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void stepOn(Level pLevel, @NotNull BlockPos pPos, @NotNull BlockState pState, Entity pEntity) {
        int px = pEntity.getBlockX();
        int py = pEntity.getBlockY();
        int pz = pEntity.getBlockZ();
        BlockPos playerRelativeToBlockCheck = new BlockPos(px, py - 1, pz);
        if(!pLevel.isClientSide()){
            if(pState.is(this)){
                if(pEntity instanceof Player player){
                    if(pPos.equals(playerRelativeToBlockCheck)){
                        player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 100, 2));
                        if(Objects.requireNonNull(player.getEffect(MobEffects.MOVEMENT_SPEED)).getDuration() <= 1){
                            player.removeEffect(MobEffects.MOVEMENT_SPEED);
                        }
                    }
                }
            }
        }
        super.stepOn(pLevel, pPos, pState, pEntity);
    }
}