package net.mrmisc.crafttech.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.mrmisc.crafttech.CraftTech;
import net.mrmisc.crafttech.block.ModBlocks;
import net.mrmisc.crafttech.util.ModTags;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, CraftTech.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        this.tag(ModTags.Blocks.ORE_EXTRACTOR_VALUABLES)
                .add(ModBlocks.SAPPHIRE_ORE.get())
                .add(ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get())
                .add(ModBlocks.NETHER_SAPPHIRE_ORE.get())
                .add(ModBlocks.RUBY_ORE.get())
                .add(ModBlocks.DEEPSLATE_RUBY_ORE.get())
                .add(ModBlocks.NETHER_RUBY_ORE.get())
                .add(ModBlocks.TOPAZ_ORE.get())
                .add(ModBlocks.DEEPSLATE_TOPAZ_ORE.get())
                .add(ModBlocks.NETHER_TOPAZ_ORE.get())
                .add(ModBlocks.COBALT_ORE.get())
                .add(ModBlocks.DEEPSLATE_COBALT_ORE.get())
                .add(ModBlocks.NETHER_COBALT_ORE.get())
                .add(ModBlocks.PLATINUM_ORE.get())
                .add(ModBlocks.DEEPSLATE_PLATINUM_ORE.get())
                .add(ModBlocks.NETHER_PLATINUM_ORE.get())
                .add(ModBlocks.TITANIUM_ORE.get())
                .add(ModBlocks.DEEPSLATE_TITANIUM_ORE.get())
                .add(ModBlocks.NETHER_TITANIUM_ORE.get())
                .add(ModBlocks.ADAMANTINE_ORE.get())
                .add(ModBlocks.DEEPSLATE_ADAMANTINE_ORE.get())
                .add(ModBlocks.NETHER_ADAMANTINE_ORE.get())
                .addTag(Tags.Blocks.ORES);

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.SAPPHIRE_BLOCK.get())
                .add(ModBlocks.SAPPHIRE_ORE.get())
                .add(ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get())
                .add(ModBlocks.NETHER_SAPPHIRE_ORE.get())
                .add(ModBlocks.RUBY_BLOCK.get())
                .add(ModBlocks.RUBY_ORE.get())
                .add(ModBlocks.DEEPSLATE_RUBY_ORE.get())
                .add(ModBlocks.NETHER_RUBY_ORE.get())
                .add(ModBlocks.TOPAZ_BLOCK.get())
                .add(ModBlocks.TOPAZ_ORE.get())
                .add(ModBlocks.DEEPSLATE_TOPAZ_ORE.get())
                .add(ModBlocks.NETHER_TOPAZ_ORE.get())
                .add(ModBlocks.COBALT_BLOCK.get())
                .add(ModBlocks.COBALT_ORE.get())
                .add(ModBlocks.DEEPSLATE_COBALT_ORE.get())
                .add(ModBlocks.NETHER_COBALT_ORE.get())
                .add(ModBlocks.ADAMANTINE_BLOCK.get())
                .add(ModBlocks.ADAMANTINE_ORE.get())
                .add(ModBlocks.DEEPSLATE_ADAMANTINE_ORE.get())
                .add(ModBlocks.NETHER_ADAMANTINE_ORE.get())
                .add(ModBlocks.PLATINUM_BLOCK.get())
                .add(ModBlocks.PLATINUM_ORE.get())
                .add(ModBlocks.DEEPSLATE_PLATINUM_ORE.get())
                .add(ModBlocks.NETHER_PLATINUM_ORE.get())
                .add(ModBlocks.TITANIUM_BLOCK.get())
                .add(ModBlocks.TITANIUM_ORE.get())
                .add(ModBlocks.DEEPSLATE_TITANIUM_ORE.get())
                .add(ModBlocks.NETHER_TITANIUM_ORE.get());

        this.tag(BlockTags.MINEABLE_WITH_AXE)
                .add(ModBlocks.COCONUT_LOG.get())
                .add(ModBlocks.COCONUT_WOOD.get())
                .add(ModBlocks.STRIPPED_COCONUT_LOG.get())
                .add(ModBlocks.STRIPPED_COCONUT_WOOD.get())
                .add(ModBlocks.COCONUT_PLANKS.get());

        this.tag(BlockTags.MINEABLE_WITH_HOE);
        this.tag(BlockTags.MINEABLE_WITH_SHOVEL);

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.SAPPHIRE_BLOCK.get())
                .add(ModBlocks.SAPPHIRE_ORE.get())
                .add(ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get())
                .add(ModBlocks.COBALT_ORE.get())
                .add(ModBlocks.DEEPSLATE_COBALT_ORE.get())
                .add(ModBlocks.COBALT_BLOCK.get())
                .add(ModBlocks.RUBY_BLOCK.get())
                .add(ModBlocks.RUBY_ORE.get())
                .add(ModBlocks.DEEPSLATE_RUBY_ORE.get())
                .add(ModBlocks.COCONUT_LOG.get())
                .add(ModBlocks.COCONUT_WOOD.get())
                .add(ModBlocks.STRIPPED_COCONUT_LOG.get())
                .add(ModBlocks.STRIPPED_COCONUT_WOOD.get())
                .add(ModBlocks.COCONUT_PLANKS.get());

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.NETHER_SAPPHIRE_ORE.get())
                .add(ModBlocks.NETHER_COBALT_ORE.get())
                .add(ModBlocks.NETHER_RUBY_ORE.get())
                .add(ModBlocks.TOPAZ_BLOCK.get())
                .add(ModBlocks.TOPAZ_ORE.get())
                .add(ModBlocks.DEEPSLATE_TOPAZ_ORE.get());

        this.tag(BlockTags.NEEDS_STONE_TOOL)
            ;


        this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL)
                .add(ModBlocks.ADAMANTINE_BLOCK.get())
                .add(ModBlocks.ADAMANTINE_ORE.get())
                .add(ModBlocks.DEEPSLATE_ADAMANTINE_ORE.get())
                .add(ModBlocks.NETHER_ADAMANTINE_ORE.get())
                .add(ModBlocks.TITANIUM_BLOCK.get())
                .add(ModBlocks.TITANIUM_ORE.get())
                .add(ModBlocks.DEEPSLATE_TITANIUM_ORE.get())
                .add(ModBlocks.NETHER_TITANIUM_ORE.get())
                .add(ModBlocks.PLATINUM_ORE.get())
                .add(ModBlocks.DEEPSLATE_PLATINUM_ORE.get())
                .add(ModBlocks.NETHER_PLATINUM_ORE.get())
                .add(ModBlocks.PLATINUM_BLOCK.get());

        this.tag(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.COCONUT_LOG.get())
                .add(ModBlocks.COCONUT_WOOD.get())
                .add(ModBlocks.STRIPPED_COCONUT_LOG.get())
                .add(ModBlocks.STRIPPED_COCONUT_WOOD.get());

        this.tag(BlockTags.PLANKS)
                .add(ModBlocks.COCONUT_PLANKS.get());

        this.tag(Tags.Blocks.FENCES)
                .add(ModBlocks.COCONUT_FENCE.get());

        this.tag(Tags.Blocks.FENCE_GATES)
                .add(ModBlocks.COCONUT_FENCE_GATE.get());
    }
}
