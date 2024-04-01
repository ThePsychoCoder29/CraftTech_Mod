package net.mrmisc.crafttech.worldgen.tree;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.mrmisc.crafttech.worldgen.ModTrunkPlacerTypes;
import org.jetbrains.annotations.NotNull;
import java.util.List;
import java.util.function.BiConsumer;

public class CoconutTrunkPlacer extends TrunkPlacer {
    public static final Codec<CoconutTrunkPlacer> CODEC = RecordCodecBuilder.create(coconutTrunkPlacerInstance ->
            trunkPlacerParts(coconutTrunkPlacerInstance).apply(coconutTrunkPlacerInstance, CoconutTrunkPlacer::new)
    );
    public CoconutTrunkPlacer(int pBaseHeight, int pHeightRandA, int pHeightRandB) {
        super(pBaseHeight, pHeightRandA, pHeightRandB);
    }

    @Override
    protected @NotNull TrunkPlacerType<?> type() {
        return ModTrunkPlacerTypes.COCONUT_TRUNK_PLACER.get();
    }


    @Override
    public @NotNull List<FoliagePlacer.FoliageAttachment> placeTrunk(@NotNull LevelSimulatedReader pLevel, @NotNull BiConsumer<BlockPos, BlockState> pBlockSetter, @NotNull RandomSource pRandom, int pFreeHeight, BlockPos pPos, @NotNull TreeConfiguration pConfig) {
        setDirtAt(pLevel, pBlockSetter, pRandom, pPos.below(), pConfig);
        int height = pFreeHeight + pRandom.nextInt(5);

        for (int i = 0; i < height; i++) {
            placeLog(pLevel, pBlockSetter, pRandom, pPos.above(i), pConfig);
        }

        for (int i = 0; i < 6; i++) {
            BlockPos branchPosNorth = pPos.above(height - 1).relative(Direction.NORTH, i == 0 ? -1 : 2);
            BlockPos branchPosSouth = pPos.above(height - 1).relative(Direction.SOUTH, i == 0 ? -1 : 2);
            BlockPos branchPosWest = pPos.above(height - 1).relative(Direction.WEST, i == 0 ? -1 : 2);
            BlockPos branchPosEast = pPos.above(height - 1).relative(Direction.EAST, i == 0 ? -1 : 2);

            pBlockSetter.accept(branchPosNorth, pConfig.trunkProvider.getState(pRandom, pPos).setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z));
            pBlockSetter.accept(branchPosSouth, pConfig.trunkProvider.getState(pRandom, pPos).setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z));
            pBlockSetter.accept(branchPosWest, pConfig.trunkProvider.getState(pRandom, pPos).setValue(RotatedPillarBlock.AXIS, Direction.Axis.X));
            pBlockSetter.accept(branchPosEast, pConfig.trunkProvider.getState(pRandom, pPos).setValue(RotatedPillarBlock.AXIS, Direction.Axis.X));

            if (i == 1) {
                BlockPos secondBranchPosNorth = pPos.above(height).relative(Direction.NORTH, 2);
                BlockPos secondBranchPosSouth = pPos.above(height).relative(Direction.SOUTH, 2);
                BlockPos secondBranchPosWest = pPos.above(height).relative(Direction.WEST, 2);
                BlockPos secondBranchPosEast = pPos.above(height).relative(Direction.EAST, 2);

                pBlockSetter.accept(secondBranchPosNorth, pConfig.trunkProvider.getState(pRandom, pPos));
                pBlockSetter.accept(secondBranchPosSouth, pConfig.trunkProvider.getState(pRandom, pPos));
                pBlockSetter.accept(secondBranchPosWest, pConfig.trunkProvider.getState(pRandom, pPos));
                pBlockSetter.accept(secondBranchPosEast, pConfig.trunkProvider.getState(pRandom, pPos));

                pBlockSetter.accept(secondBranchPosNorth.relative(Direction.NORTH), pConfig.trunkProvider.getState(pRandom, pPos));
                pBlockSetter.accept(secondBranchPosSouth.relative(Direction.SOUTH), pConfig.trunkProvider.getState(pRandom, pPos));
                pBlockSetter.accept(secondBranchPosWest.relative(Direction.WEST), pConfig.trunkProvider.getState(pRandom, pPos));
                pBlockSetter.accept(secondBranchPosEast.relative(Direction.EAST), pConfig.trunkProvider.getState(pRandom, pPos));
            }
            if (i == 2) {
                BlockPos thirdBranchPosNorth = pPos.above(height+1).relative(Direction.NORTH, 3);
                BlockPos thirdBranchPosSouth = pPos.above(height+1).relative(Direction.SOUTH, 3);
                BlockPos thirdBranchPosWest = pPos.above(height+1).relative(Direction.WEST, 3);
                BlockPos thirdBranchPosEast = pPos.above(height+1).relative(Direction.EAST, 3);

                pBlockSetter.accept(thirdBranchPosNorth, pConfig.trunkProvider.getState(pRandom, pPos));
                pBlockSetter.accept(thirdBranchPosSouth, pConfig.trunkProvider.getState(pRandom, pPos));
                pBlockSetter.accept(thirdBranchPosWest, pConfig.trunkProvider.getState(pRandom, pPos));
                pBlockSetter.accept(thirdBranchPosEast, pConfig.trunkProvider.getState(pRandom, pPos));

            }
            if (i == 3) {
                BlockPos fourthBranchPosNorth = pPos.above(height+2).relative(Direction.NORTH, 3);
                BlockPos fourthBranchPosSouth = pPos.above(height+2).relative(Direction.SOUTH, 3);
                BlockPos fourthBranchPosWest = pPos.above(height+2).relative(Direction.WEST, 3);
                BlockPos fourthBranchPosEast = pPos.above(height+2).relative(Direction.EAST, 3);

                pBlockSetter.accept(fourthBranchPosNorth, pConfig.trunkProvider.getState(pRandom, pPos));
                pBlockSetter.accept(fourthBranchPosSouth, pConfig.trunkProvider.getState(pRandom, pPos));
                pBlockSetter.accept(fourthBranchPosWest, pConfig.trunkProvider.getState(pRandom, pPos));
                pBlockSetter.accept(fourthBranchPosEast, pConfig.trunkProvider.getState(pRandom, pPos));

            }
            if (i == 4) {
                BlockPos fifthBranchPosNorth = pPos.above(height+3).relative(Direction.NORTH, 3);
                BlockPos fifthBranchPosSouth = pPos.above(height+3).relative(Direction.SOUTH, 3);
                BlockPos fifthBranchPosWest = pPos.above(height+3).relative(Direction.WEST, 3);
                BlockPos fifthBranchPosEast = pPos.above(height+3).relative(Direction.EAST, 3);

                pBlockSetter.accept(fifthBranchPosNorth, pConfig.trunkProvider.getState(pRandom, pPos));
                pBlockSetter.accept(fifthBranchPosSouth, pConfig.trunkProvider.getState(pRandom, pPos));
                pBlockSetter.accept(fifthBranchPosWest, pConfig.trunkProvider.getState(pRandom, pPos));
                pBlockSetter.accept(fifthBranchPosEast, pConfig.trunkProvider.getState(pRandom, pPos));

            }
            if (i == 5) {
                BlockPos sixthBranchPosNorth = pPos.above(height + 4).relative(Direction.NORTH, 3);
                BlockPos sixthBranchPosSouth = pPos.above(height + 4).relative(Direction.SOUTH, 3);
                BlockPos sixthBranchPosWest = pPos.above(height + 4).relative(Direction.WEST, 3);
                BlockPos sixthBranchPosEast = pPos.above(height + 4).relative(Direction.EAST, 3);

                pBlockSetter.accept(sixthBranchPosNorth, pConfig.trunkProvider.getState(pRandom, pPos));
                pBlockSetter.accept(sixthBranchPosSouth, pConfig.trunkProvider.getState(pRandom, pPos));
                pBlockSetter.accept(sixthBranchPosWest, pConfig.trunkProvider.getState(pRandom, pPos));
                pBlockSetter.accept(sixthBranchPosEast, pConfig.trunkProvider.getState(pRandom, pPos));

                pBlockSetter.accept(sixthBranchPosNorth.relative(Direction.NORTH), pConfig.trunkProvider.getState(pRandom, pPos));
                pBlockSetter.accept(sixthBranchPosSouth.relative(Direction.SOUTH), pConfig.trunkProvider.getState(pRandom, pPos));
                pBlockSetter.accept(sixthBranchPosWest.relative(Direction.WEST), pConfig.trunkProvider.getState(pRandom, pPos));
                pBlockSetter.accept(sixthBranchPosEast.relative(Direction.EAST), pConfig.trunkProvider.getState(pRandom, pPos));
            }
        }
        return ImmutableList.of(new FoliagePlacer.FoliageAttachment(pPos.above(height), 0, false));
    }

}

