package net.mrmisc.crafttech.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.mrmisc.crafttech.CraftTech;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> ORE_EXTRACTOR_VALUABLES = tag("ore_extractor_valuables");
        public static final TagKey<Block> HIPPO_LIQUIDS = tag("hippo_liquids");
        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(CraftTech.MOD_ID, name));
        }
    }
    public static class Items {

        public static final TagKey<Item> COCONUT_LOGS = tag("coconut_logs");
        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(CraftTech.MOD_ID, name));

        }
    }
}
