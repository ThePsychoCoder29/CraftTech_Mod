package net.mrmisc.crafttech.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.mrmisc.crafttech.CraftTech;
import net.mrmisc.crafttech.block.ModBlocks;
import net.mrmisc.crafttech.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_, CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, CraftTech.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.COCONUT_LOG.get().asItem())
                .add(ModBlocks.COCONUT_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_COCONUT_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_COCONUT_WOOD.get().asItem());
        this.tag(ModTags.Items.COCONUT_LOGS)
                .add(ModBlocks.COCONUT_LOG.get().asItem())
                .add(ModBlocks.COCONUT_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_COCONUT_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_COCONUT_WOOD.get().asItem());

        this.tag(ItemTags.PLANKS)
                .add(ModBlocks.COCONUT_PLANKS.get().asItem());
    }
}
