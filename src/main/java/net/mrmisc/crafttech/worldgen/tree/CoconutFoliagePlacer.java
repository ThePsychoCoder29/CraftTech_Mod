package net.mrmisc.crafttech.worldgen.tree;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.mrmisc.crafttech.block.ModBlocks;
import org.jetbrains.annotations.NotNull;

public class CoconutFoliagePlacer extends FoliagePlacer {
    public static final Codec<CoconutFoliagePlacer> CODEC = RecordCodecBuilder.create(coconutFoliagePlacerInstance ->
            foliagePlacerParts(coconutFoliagePlacerInstance).and(Codec.intRange(0, 16).fieldOf("height")
                    .forGetter(fp -> fp.height)).apply(coconutFoliagePlacerInstance, CoconutFoliagePlacer::new));
    private final int height;
    public CoconutFoliagePlacer(IntProvider pRadius, IntProvider pOffset, int height) {
        super(pRadius, pOffset);
        this.height = height;
    }

    @Override
    protected @NotNull FoliagePlacerType<?> type() {
        return ModFoliagePlacers.COCONUT_FOLIAGE_PLACER.get();
    }

    @Override
    protected void createFoliage(@NotNull LevelSimulatedReader pLevel, @NotNull FoliageSetter pBlockSetter, @NotNull RandomSource pRandom, @NotNull TreeConfiguration pConfig, int pMaxFreeTreeHeight, @NotNull FoliageAttachment pAttachment, int pFoliageHeight, int pFoliageRadius, int pOffset) {
        BlockPos trunkPos = pAttachment.pos();
        int extendedRadius = pFoliageRadius + 2;
        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos().above(0),2, 1, pAttachment.doubleTrunk());
        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos().above(0),2, 2, pAttachment.doubleTrunk());
        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos().above(0),2, 3, pAttachment.doubleTrunk());

        for (int x = -extendedRadius; x <= extendedRadius; x++) {
            for (int z = -extendedRadius; z <= extendedRadius; z++) {
                for (int y = -2; y <= pFoliageHeight + 2; y++) {
                    BlockPos leafPos = trunkPos.offset(x, y, z);
                    if (isEmptyBlock(pLevel, leafPos) && isNeighborCoconutLog(pLevel, leafPos)) {
                        pBlockSetter.set(leafPos, ModBlocks.COCONUT_LEAVES.get().defaultBlockState());
                    }
                }
            }
        }
    }


        private boolean isEmptyBlock(LevelSimulatedReader level, BlockPos pos) {
        BlockState blockState = ((LevelReader) level).getBlockState(pos);

        return blockState.isAir();
    }

    private boolean isNeighborCoconutLog(LevelSimulatedReader level, BlockPos pos) {
        for (Direction direction : Direction.values()) {
            BlockPos neighborPos = pos.relative(direction);
            BlockState neighborState = ((LevelReader) level).getBlockState(neighborPos);
            BlockState posState = ((LevelReader) level).getBlockState(pos);

            if (posState.isAir() && neighborState.getBlock() == ModBlocks.COCONUT_LOG.get()) {
                return true;
            }
        }
        return false;
    }


    @Override
    public int foliageHeight(@NotNull RandomSource pRandom, int pHeight, @NotNull TreeConfiguration pConfig) {
        return this.height;
    }

    @Override
    protected boolean shouldSkipLocation(@NotNull RandomSource pRandom, int i, int i1, int i2, int i3, boolean b) {
        return false;
    }
}
