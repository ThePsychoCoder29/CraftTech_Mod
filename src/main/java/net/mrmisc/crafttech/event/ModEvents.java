package net.mrmisc.crafttech.event;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.mrmisc.crafttech.CraftTech;
import net.mrmisc.crafttech.block.ModBlocks;
import net.mrmisc.crafttech.item.ModItems;
import net.mrmisc.crafttech.villager.ModVillagers;

import java.util.List;

@Mod.EventBusSubscriber(modid = CraftTech.MOD_ID)
public class ModEvents {
    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event) {
        if (event.getType() == ModVillagers.ORE_DIGGER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            // Level 1
            trades.get(1).add((entity, randomSource) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 2),
                    new ItemStack(ModItems.SAPPHIRE.get(), 2),
                    10, 6, 0.02f
            ));

            // Level 2
            trades.get(2).add((entity, randomSource) -> new MerchantOffer(
                    new ItemStack(Items.GOLD_INGOT, 2),
                    new ItemStack(ModItems.RUBY.get(), 2),
                    10, 6, 0.02f
            ));

            // Level 3
            trades.get(3).add((entity, randomSource) -> new MerchantOffer(
                    new ItemStack(Items.DIAMOND, 5),
                    new ItemStack(ModItems.PLATINUM_INGOT.get(), 2),
                    4, 12, 0.02f
            ));

            // Level 4
            trades.get(4).add((entity, randomSource) -> new MerchantOffer(
                    new ItemStack(Items.DIAMOND, 5),
                    new ItemStack(ModItems.TITANIUM_INGOT.get(), 2),
                    10, 6, 0.02f
            ));

            // Level 5
            trades.get(1).add((entity, randomSource) -> new MerchantOffer(
                    new ItemStack(Items.NETHERITE_SCRAP, 3),
                    new ItemStack(ModItems.ADAMANTINE_INGOT.get(), 1),
                    10, 15, 0.02f
            ));
        }

        if (event.getType() == VillagerProfession.WEAPONSMITH) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            trades.get(4).add((entity, randomSource) -> new MerchantOffer(
                    new ItemStack(Items.GOLD_INGOT, 2),
                    new ItemStack(Items.EMERALD, 2),
                    new ItemStack(ModBlocks.ELEMENT_MIXER.get(), 1),
                    5, 10, 0.02f
            ));
        }
    }
    @SubscribeEvent
    public static void addCustomWanderingTraderTrades(WandererTradesEvent event){
        List<VillagerTrades.ItemListing> genericTrades = event.getGenericTrades();
        List<VillagerTrades.ItemListing> rareTrades = event.getRareTrades();

        genericTrades.add((entity, randomSource) -> new MerchantOffer(
                new ItemStack(Items.GOLDEN_APPLE, 2),
                new ItemStack(ModItems.ORE_EXTRACTOR.get(), 1),
                5, 4, 0.01f
        ));
    }
}
