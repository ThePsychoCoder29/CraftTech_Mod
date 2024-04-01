package net.mrmisc.crafttech.datagen.loot;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;
import net.mrmisc.crafttech.block.ModBlocks;
import net.mrmisc.crafttech.item.ModItems;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.SAPPHIRE_BLOCK.get());
        this.dropSelf(ModBlocks.RUBY_BLOCK.get());
        this.dropSelf(ModBlocks.TOPAZ_BLOCK.get());
        this.dropSelf(ModBlocks.ADAMANTINE_BLOCK.get());
        this.dropSelf(ModBlocks.COBALT_BLOCK.get());
        this.dropSelf(ModBlocks.PLATINUM_BLOCK.get());
        this.dropSelf(ModBlocks.TITANIUM_BLOCK.get());
        this.dropSelf(ModBlocks.COCONUT_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_COCONUT_LOG.get());
        this.dropSelf(ModBlocks.COCONUT_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_COCONUT_WOOD.get());
        this.dropSelf(ModBlocks.COCONUT_PLANKS.get());
        this.dropSelf(ModBlocks.COCONUT_SAPLING.get());

        this.add(ModBlocks.COCONUT_LEAVES.get(),
                block -> createLeavesDrops(block, ModBlocks.COCONUT_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        this.add(ModBlocks.SAPPHIRE_ORE.get(),
                block -> createCopperLikeOreDrops(ModBlocks.SAPPHIRE_ORE.get(), ModItems.SAPPHIRE.get()));
        this.add(ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get(),
                block -> createCopperLikeOreDrops(ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get(), ModItems.SAPPHIRE.get()));
        this.add(ModBlocks.NETHER_SAPPHIRE_ORE.get(),
                block -> createCopperLikeOreDrops(ModBlocks.NETHER_SAPPHIRE_ORE.get(), ModItems.SAPPHIRE.get()));
        this.add(ModBlocks.RUBY_ORE.get(),
                block -> createCopperLikeOreDrops(ModBlocks.RUBY_ORE.get(), ModItems.RUBY.get()));
        this.add(ModBlocks.DEEPSLATE_RUBY_ORE.get(),
                block -> createCopperLikeOreDrops(ModBlocks.DEEPSLATE_RUBY_ORE.get(), ModItems.RUBY.get()));
        this.add(ModBlocks.NETHER_RUBY_ORE.get(),
                block -> createCopperLikeOreDrops(ModBlocks.NETHER_RUBY_ORE.get(), ModItems.RUBY.get()));
        this.add(ModBlocks.TOPAZ_ORE.get(),
                block -> createCopperLikeOreDrops(ModBlocks.TOPAZ_ORE.get(), ModItems.TOPAZ.get()));
        this.add(ModBlocks.DEEPSLATE_TOPAZ_ORE.get(),
                block -> createCopperLikeOreDrops(ModBlocks.DEEPSLATE_TOPAZ_ORE.get(), ModItems.TOPAZ.get()));
        this.add(ModBlocks.NETHER_TOPAZ_ORE.get(),
                block -> createCopperLikeOreDrops(ModBlocks.NETHER_TOPAZ_ORE.get(), ModItems.TOPAZ.get()));
        this.add(ModBlocks.ADAMANTINE_ORE.get(),
                block -> createCopperLikeOreDrops(ModBlocks.ADAMANTINE_ORE.get(), ModItems.ADAMANTINE_INGOT.get()));
        this.add(ModBlocks.DEEPSLATE_ADAMANTINE_ORE.get(),
                block -> createCopperLikeOreDrops(ModBlocks.DEEPSLATE_ADAMANTINE_ORE.get(), ModItems.ADAMANTINE_INGOT.get()));
        this.add(ModBlocks.NETHER_ADAMANTINE_ORE.get(),
                block -> createCopperLikeOreDrops(ModBlocks.NETHER_ADAMANTINE_ORE.get(), ModItems.ADAMANTINE_INGOT.get()));
        this.add(ModBlocks.COBALT_ORE.get(),
                block -> createCopperLikeOreDrops(ModBlocks.COBALT_ORE.get(), ModItems.COBALT_INGOT.get()));
        this.add(ModBlocks.DEEPSLATE_COBALT_ORE.get(),
                block -> createCopperLikeOreDrops(ModBlocks.DEEPSLATE_COBALT_ORE.get(), ModItems.COBALT_INGOT.get()));
        this.add(ModBlocks.NETHER_COBALT_ORE.get(),
                block -> createCopperLikeOreDrops(ModBlocks.NETHER_COBALT_ORE.get(), ModItems.COBALT_INGOT.get()));
        this.add(ModBlocks.PLATINUM_ORE.get(),
                block -> createCopperLikeOreDrops(ModBlocks.PLATINUM_ORE.get(), ModItems.PLATINUM_INGOT.get()));
        this.add(ModBlocks.DEEPSLATE_PLATINUM_ORE.get(),
                block -> createCopperLikeOreDrops(ModBlocks.DEEPSLATE_PLATINUM_ORE.get(), ModItems.PLATINUM_INGOT.get()));
        this.add(ModBlocks.NETHER_PLATINUM_ORE.get(),
                block -> createCopperLikeOreDrops(ModBlocks.NETHER_PLATINUM_ORE.get(), ModItems.PLATINUM_INGOT.get()));
        this.add(ModBlocks.TITANIUM_ORE.get(),
                block -> createCopperLikeOreDrops(ModBlocks.TITANIUM_ORE.get(), ModItems.TITANIUM_INGOT.get()));
        this.add(ModBlocks.DEEPSLATE_TITANIUM_ORE.get(),
                block -> createCopperLikeOreDrops(ModBlocks.DEEPSLATE_TITANIUM_ORE.get(), ModItems.TITANIUM_INGOT.get()));
        this.add(ModBlocks.NETHER_TITANIUM_ORE.get(),
                block -> createCopperLikeOreDrops(ModBlocks.NETHER_TITANIUM_ORE.get(), ModItems.TITANIUM_INGOT.get()));


    }

    protected LootTable.Builder createCopperLikeOreDrops(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock,
                        this.applyExplosionDecay
                                (pBlock, LootItem.lootTableItem(item)
                                        .apply(SetItemCountFunction.setCount
                                                (UniformGenerator.between(2.0F, 5.0F)))
                                        .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
