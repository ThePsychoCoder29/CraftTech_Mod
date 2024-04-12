package net.mrmisc.crafttech.worldgen;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.mrmisc.crafttech.CraftTech;
import net.mrmisc.crafttech.block.ModBlocks;
import net.mrmisc.crafttech.worldgen.tree.CoconutFoliagePlacer;
import net.mrmisc.crafttech.worldgen.tree.CoconutTrunkPlacer;

import java.util.List;
import java.util.Random;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_SAPPHIRE_ORE_KEY = registerKey("sapphire_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_SAPPHIRE_ORE_KEY = registerKey("nether_sapphire_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_RUBY_ORE_KEY = registerKey("ruby_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_RUBY_ORE_KEY = registerKey("nether_ruby_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_TOPAZ_ORE_KEY = registerKey("topaz_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_TOPAZ_ORE_KEY = registerKey("nether_topaz_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_COBALT_ORE_KEY = registerKey("cobalt_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_COBALT_ORE_KEY = registerKey("nether_cobalt_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_PLATINUM_ORE_KEY = registerKey("platinum_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_PLATINUM_ORE_KEY = registerKey("nether_platinum_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_TITANIUM_ORE_KEY = registerKey("titanium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_TITANIUM_ORE_KEY = registerKey("nether_titanium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_ADAMANTINE_ORE_KEY = registerKey("adamantine_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_ADAMANTINE_ORE_KEY = registerKey("nether_adamantine_ore");

    public static final ResourceKey<ConfiguredFeature<?, ?>> COCONUT_TREE_KEY = registerKey("coconut_tree");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {

        Random random = new Random();
        int overworldVein = random.nextInt(5) + 3;
        int netherVein = random.nextInt(4) + 1;

        RuleTest stoneReplaceable = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherrackReplacables = new BlockMatchTest(Blocks.NETHERRACK);

        List<OreConfiguration.TargetBlockState> overworldSapphireOres = List.of(OreConfiguration.target(stoneReplaceable,
                        ModBlocks.SAPPHIRE_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get().defaultBlockState()));

        register(context, OVERWORLD_SAPPHIRE_ORE_KEY, Feature.ORE, new OreConfiguration(overworldSapphireOres, overworldVein));
        register(context, NETHER_SAPPHIRE_ORE_KEY, Feature.ORE, new OreConfiguration(netherrackReplacables,
                ModBlocks.NETHER_SAPPHIRE_ORE.get().defaultBlockState(), netherVein));

        List<OreConfiguration.TargetBlockState> overworldRubyOres = List.of(OreConfiguration.target(stoneReplaceable,
                        ModBlocks.RUBY_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.DEEPSLATE_RUBY_ORE.get().defaultBlockState()));

        register(context, OVERWORLD_RUBY_ORE_KEY, Feature.ORE, new OreConfiguration(overworldRubyOres, overworldVein));
        register(context, NETHER_RUBY_ORE_KEY, Feature.ORE, new OreConfiguration(netherrackReplacables,
                ModBlocks.NETHER_RUBY_ORE.get().defaultBlockState(), netherVein));

        List<OreConfiguration.TargetBlockState> overworldTopazOres = List.of(OreConfiguration.target(stoneReplaceable,
                        ModBlocks.TOPAZ_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.DEEPSLATE_TOPAZ_ORE.get().defaultBlockState()));

        register(context, OVERWORLD_TOPAZ_ORE_KEY, Feature.ORE, new OreConfiguration(overworldTopazOres, overworldVein));
        register(context, NETHER_TOPAZ_ORE_KEY, Feature.ORE, new OreConfiguration(netherrackReplacables,
                ModBlocks.NETHER_TOPAZ_ORE.get().defaultBlockState(), netherVein));

        List<OreConfiguration.TargetBlockState> overworldCobaltOres = List.of(OreConfiguration.target(stoneReplaceable,
                        ModBlocks.COBALT_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.DEEPSLATE_COBALT_ORE.get().defaultBlockState()));

        register(context, OVERWORLD_COBALT_ORE_KEY, Feature.ORE, new OreConfiguration(overworldCobaltOres, overworldVein));
        register(context, NETHER_COBALT_ORE_KEY, Feature.ORE, new OreConfiguration(netherrackReplacables,
                ModBlocks.NETHER_COBALT_ORE.get().defaultBlockState(), netherVein));

        List<OreConfiguration.TargetBlockState> overworldPlatinumOres = List.of(OreConfiguration.target(stoneReplaceable,
                        ModBlocks.PLATINUM_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.DEEPSLATE_PLATINUM_ORE.get().defaultBlockState()));

        register(context, OVERWORLD_PLATINUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldPlatinumOres, 6));
        register(context, NETHER_PLATINUM_ORE_KEY, Feature.ORE, new OreConfiguration(netherrackReplacables,
                ModBlocks.NETHER_PLATINUM_ORE.get().defaultBlockState(), 6));

        List<OreConfiguration.TargetBlockState> overworldTitaniumOres = List.of(OreConfiguration.target(stoneReplaceable,
                        ModBlocks.TITANIUM_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.DEEPSLATE_TITANIUM_ORE.get().defaultBlockState()));

        register(context, OVERWORLD_TITANIUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldTitaniumOres, 6));
        register(context, NETHER_TITANIUM_ORE_KEY, Feature.ORE, new OreConfiguration(netherrackReplacables,
                ModBlocks.NETHER_TITANIUM_ORE.get().defaultBlockState(), 6));

        List<OreConfiguration.TargetBlockState> overworldAdamantineOres = List.of(OreConfiguration.target(stoneReplaceable,
                        ModBlocks.ADAMANTINE_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.DEEPSLATE_ADAMANTINE_ORE.get().defaultBlockState()));

        register(context, OVERWORLD_ADAMANTINE_ORE_KEY, Feature.ORE, new OreConfiguration(overworldAdamantineOres, 3));
        register(context, NETHER_ADAMANTINE_ORE_KEY, Feature.SCATTERED_ORE, new OreConfiguration(netherrackReplacables,
                ModBlocks.NETHER_ADAMANTINE_ORE.get().defaultBlockState(), 6));

        register(context, COCONUT_TREE_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.COCONUT_LOG.get()),
                new CoconutTrunkPlacer(5,4,3),
                BlockStateProvider.simple(ModBlocks.COCONUT_LEAVES.get()),
                new CoconutFoliagePlacer(ConstantInt.of(3), ConstantInt.of(2), 3),
                new TwoLayersFeatureSize(1, 0, 2)).build());
    }
    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(CraftTech.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
