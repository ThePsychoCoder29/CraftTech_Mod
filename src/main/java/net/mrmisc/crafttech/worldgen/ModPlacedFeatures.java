package net.mrmisc.crafttech.worldgen;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.mrmisc.crafttech.CraftTech;
import net.mrmisc.crafttech.block.ModBlocks;

import java.util.List;

public class ModPlacedFeatures {
    public static final ResourceKey<PlacedFeature> SAPPHIRE_ORE_PLACED_KEY = registerKey("sapphire_ore_placed");
    public static final ResourceKey<PlacedFeature> NETHER_SAPPHIRE_ORE_PLACED_KEY = registerKey("nether_sapphire_ore_placed");
    public static final ResourceKey<PlacedFeature> RUBY_ORE_PLACED_KEY = registerKey("ruby_ore_placed");
    public static final ResourceKey<PlacedFeature> NETHER_RUBY_ORE_PLACED_KEY = registerKey("nether_ruby_ore_placed");
    public static final ResourceKey<PlacedFeature> COBALT_ORE_PLACED_KEY = registerKey("cobalt_ore_placed");
    public static final ResourceKey<PlacedFeature> NETHER_COBALT_ORE_PLACED_KEY = registerKey("nether_cobalt_ore_placed");
    public static final ResourceKey<PlacedFeature> TOPAZ_ORE_PLACED_KEY = registerKey("topaz_ore_placed");
    public static final ResourceKey<PlacedFeature> NETHER_TOPAZ_ORE_PLACED_KEY = registerKey("nether_topaz_ore_placed");
    public static final ResourceKey<PlacedFeature> PLATINUM_ORE_PLACED_KEY = registerKey("platinum_ore_placed");
    public static final ResourceKey<PlacedFeature> NETHER_PLATINUM_ORE_PLACED_KEY = registerKey("nether_platinum_ore_placed");
    public static final ResourceKey<PlacedFeature> TITANIUM_ORE_PLACED_KEY = registerKey("titanium_ore_placed");
    public static final ResourceKey<PlacedFeature> NETHER_TITANIUM_ORE_PLACED_KEY = registerKey("nether_titanium_ore_placed");
    public static final ResourceKey<PlacedFeature> ADAMANTINE_ORE_PLACED_KEY = registerKey("adamantine_ore_placed");
    public static final ResourceKey<PlacedFeature> NETHER_ADAMANTINE_ORE_PLACED_KEY = registerKey("nether_adamantine_ore_placed");
    public static final ResourceKey<PlacedFeature> COCONUT_PLACED_KEY = registerKey("coconut_placed");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, SAPPHIRE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_SAPPHIRE_ORE_KEY),
                ModOrePlacement.commonOrePlacement(12,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));
        register(context, NETHER_SAPPHIRE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.NETHER_SAPPHIRE_ORE_KEY),
                ModOrePlacement.commonOrePlacement(12,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(80))));

        register(context, RUBY_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_RUBY_ORE_KEY),
                ModOrePlacement.commonOrePlacement(12,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));
        register(context, NETHER_RUBY_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.NETHER_RUBY_ORE_KEY),
                ModOrePlacement.commonOrePlacement(12,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(80))));

        register(context, COBALT_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_COBALT_ORE_KEY),
                ModOrePlacement.commonOrePlacement(12,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(-10))));
        register(context, NETHER_COBALT_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.NETHER_COBALT_ORE_KEY),
                ModOrePlacement.commonOrePlacement(12,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(-10))));

        register(context, TOPAZ_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_TOPAZ_ORE_KEY),
                ModOrePlacement.commonOrePlacement(12,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));
        register(context, NETHER_TOPAZ_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.NETHER_TOPAZ_ORE_KEY),
                ModOrePlacement.commonOrePlacement(12,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(80))));

        register(context, PLATINUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_PLATINUM_ORE_KEY),
                ModOrePlacement.rareOrePlacement(3,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));
        register(context, NETHER_PLATINUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.NETHER_PLATINUM_ORE_KEY),
                ModOrePlacement.rareOrePlacement(5,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(20))));

        register(context, TITANIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_TITANIUM_ORE_KEY),
                ModOrePlacement.rareOrePlacement(4,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(-30))));
        register(context, NETHER_TITANIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.NETHER_TITANIUM_ORE_KEY),
                ModOrePlacement.rareOrePlacement(6,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(20))));

        register(context, ADAMANTINE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_ADAMANTINE_ORE_KEY),
                ModOrePlacement.rareOrePlacement(3,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(-34))));
        register(context, NETHER_ADAMANTINE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.NETHER_ADAMANTINE_ORE_KEY),
                ModOrePlacement.rareOrePlacement(6,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(20))));
        register(context, COCONUT_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.COCONUT_TREE_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(3,0.1f,2), ModBlocks.COCONUT_SAPLING.get()));
    }


    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(CraftTech.MOD_ID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
