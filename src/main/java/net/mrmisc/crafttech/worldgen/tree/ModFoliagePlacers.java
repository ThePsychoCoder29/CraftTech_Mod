package net.mrmisc.crafttech.worldgen.tree;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.mrmisc.crafttech.CraftTech;

public class ModFoliagePlacers {
    public static final DeferredRegister<FoliagePlacerType<?>> FOLIAGE_PLACERS =
            DeferredRegister.create(Registries.FOLIAGE_PLACER_TYPE , CraftTech.MOD_ID);

    public static final RegistryObject<FoliagePlacerType<CoconutFoliagePlacer>> COCONUT_FOLIAGE_PLACER =
            FOLIAGE_PLACERS.register("coconut_foliage_placer", ()-> new FoliagePlacerType<>(CoconutFoliagePlacer.CODEC));

    public static void register(IEventBus eventBus){
        FOLIAGE_PLACERS.register(eventBus);
    }
}
