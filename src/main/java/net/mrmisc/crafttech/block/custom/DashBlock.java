package net.mrmisc.crafttech.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.goat.Goat;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class DashBlock extends Block {
    public DashBlock(Properties pProperties) {
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
                        Vec3 addend = new Vec3(5.0, 0.0, 0.0);
                        player.addDeltaMovement(addend);
                       }
                    }
                }
            }
        super.stepOn(pLevel, pPos, pState, pEntity);
    }
}
