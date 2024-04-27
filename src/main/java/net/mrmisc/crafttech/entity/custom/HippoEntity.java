package net.mrmisc.crafttech.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Strider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.level.pathfinder.PathFinder;
import net.minecraft.world.level.pathfinder.WalkNodeEvaluator;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.mrmisc.crafttech.entity.ModEntities;
import net.mrmisc.crafttech.util.ModTags;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class HippoEntity extends Animal {
    public HippoEntity(EntityType<? extends Animal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public final AnimationState idle = new AnimationState();
    private int idleAnimTimeout = 0;

    @Override
    public void tick() {
        super.tick();
        this.floatHippo();
        this.checkInsideBlocks();
        if(this.level().isClientSide()){
            setupAnimationStates();
        }
    }

    private void setupAnimationStates(){
        if(this.idleAnimTimeout <= 0){
            this.idleAnimTimeout = this.random.nextInt(40) + 80;
            this.idle.start(this.tickCount);
        }
        else{
            --this.idleAnimTimeout;
        }
    }

    @Override
    protected void updateWalkAnimation(float pPartialTick) {
        float f;
        if(this.getPose() == Pose.STANDING){
            f = Math.min(pPartialTick * 6f, 1f);
        }
        else{
            f = 0f;
        }
        this.walkAnimation.update(f, 0.2f);
    }

    public static AttributeSupplier.Builder createAttributes(){
        return Animal.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 60D)
                .add(Attributes.MOVEMENT_SPEED, 0.35D)
                .add(Attributes.FOLLOW_RANGE, 20D)
                .add(Attributes.ARMOR_TOUGHNESS, 0.1f)
                .add(Attributes.ATTACK_KNOCKBACK, 1f)
                .add(Attributes.KNOCKBACK_RESISTANCE, 100)
                .add(Attributes.ATTACK_DAMAGE, 6f);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new BreedGoal(this, 1.150D));
        this.goalSelector.addGoal(2, new TemptGoal(this, 1.2D, Ingredient.of(Items.MELON, Items.MELON_SLICE, Items.COOKED_CHICKEN, Items.COOKED_BEEF), false));
        this.goalSelector.addGoal(3, new FollowParentGoal(this, 1.2D));
        this.goalSelector.addGoal(3, new HippoGoToWaterGoal(this, 2f));
        this.goalSelector.addGoal(4, new TryFindWaterGoal(this));
        this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 5f));
        this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));
    }

    static class HippoGoToWaterGoal extends MoveToBlockGoal {
        private final HippoEntity hippo;

        HippoGoToWaterGoal(HippoEntity hippo, double pSpeedModifier) {
            super(hippo, pSpeedModifier, 20, 4);
            this.hippo = hippo;
        }

        public @NotNull BlockPos getMoveToTarget() {
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

        protected boolean isValidTarget(LevelReader pLevel, @NotNull BlockPos pPos) {
            return pLevel.getBlockState(pPos).is(Blocks.WATER) && pLevel.getBlockState(pPos.above()).isPathfindable(pLevel, pPos, PathComputationType.LAND);
        }
    }

    static class HippoPathNavigation extends GroundPathNavigation {
        HippoPathNavigation(HippoEntity hippo, Level pLevel) {
            super(hippo, pLevel);
        }

        protected @NotNull PathFinder createPathFinder(int pMaxVisitedNodes) {
            this.nodeEvaluator = new WalkNodeEvaluator();
            this.nodeEvaluator.setCanPassDoors(true);
            return new PathFinder(this.nodeEvaluator, pMaxVisitedNodes);
        }

        protected boolean hasValidPathType(@NotNull BlockPathTypes pPathType) {
            return pPathType == BlockPathTypes.WATER || pPathType == BlockPathTypes.WATER_BORDER || super.hasValidPathType(pPathType);
        }

        public boolean isStableDestination(@NotNull BlockPos pPos) {
            return this.level.getBlockState(pPos).is(Blocks.WATER) || super.isStableDestination(pPos);
        }
    }
    protected @NotNull PathNavigation createNavigation(@NotNull Level pLevel) {
        return new HippoEntity.HippoPathNavigation(this, pLevel);
    }

    private void floatHippo() {
        if (this.isInWater()) {
            CollisionContext collisionContext = CollisionContext.of(this);
            if (collisionContext.isAbove(LiquidBlock.STABLE_SHAPE, this.blockPosition(), true) && !this.level().getFluidState(this.blockPosition().above()).is(FluidTags.WATER)) {
                this.setOnGround(true);
            } else {
                this.setDeltaMovement(this.getDeltaMovement().scale(0.75).add(0.0, 0.08, 0.0));
            }
        }
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(@NotNull ServerLevel serverLevel, @NotNull AgeableMob ageableMob) {
        return ModEntities.HIPPO.get().create(serverLevel);
    }

    @Override
    public boolean isFood(ItemStack pStack) {
        return pStack.is(Items.COOKED_BEEF);
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.RAVAGER_AMBIENT;
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(@NotNull DamageSource pDamageSource) {
        return SoundEvents.RAVAGER_HURT;
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.RAVAGER_DEATH;
    }

}
