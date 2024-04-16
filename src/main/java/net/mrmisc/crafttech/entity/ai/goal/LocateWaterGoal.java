package net.mrmisc.crafttech.entity.ai.goal;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.Vec3;
import net.mrmisc.crafttech.entity.custom.HippoEntity;

import javax.annotation.Nullable;
import java.util.EnumSet;

public class LocateWaterGoal extends Goal {

    @Override
    public boolean canUse() {
        return false;
    }

    static class HippoGoToWaterGoal extends MoveToBlockGoal {
        private final HippoEntity hippo;

        HippoGoToWaterGoal(HippoEntity hippo, double pSpeedModifier) {
            super(hippo, pSpeedModifier, 20, 4);
            this.hippo = hippo;
        }

        public BlockPos getMoveToTarget() {
            return this.blockPos;
        }

        public boolean canContinueToUse() {
            return !this.hippo.isInWater() && this.isValidTarget(this.hippo.level(), this.blockPos);
        }

        public boolean canUse() {
            return !this.hippo.isInLava() && super.canUse();
        }

        public boolean shouldRecalculatePath() {
            return this.tryTicks % 20 == 0;
        }

        protected boolean isValidTarget(LevelReader pLevel, BlockPos pPos) {
            return pLevel.getBlockState(pPos).is(Blocks.WATER) && pLevel.getBlockState(pPos.above()).isPathfindable(pLevel, pPos, PathComputationType.LAND);
        }
    }
}
