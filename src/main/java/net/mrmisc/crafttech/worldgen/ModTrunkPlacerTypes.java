package net.mrmisc.crafttech.worldgen;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.mrmisc.crafttech.CraftTech;
import net.mrmisc.crafttech.worldgen.tree.CoconutTrunkPlacer;

public class ModTrunkPlacerTypes {
    public static final DeferredRegister<TrunkPlacerType<?>> TRUNK_PLACER =
            DeferredRegister.create(Registries.TRUNK_PLACER_TYPE, CraftTech.MOD_ID);

    public static final RegistryObject<TrunkPlacerType<CoconutTrunkPlacer>> COCONUT_TRUNK_PLACER =
            TRUNK_PLACER.register("coconut_trunk_placer", ()-> new TrunkPlacerType<>(CoconutTrunkPlacer.CODEC));

    public static void register(IEventBus eventBus) {
        TRUNK_PLACER.register(eventBus);
    }
}
