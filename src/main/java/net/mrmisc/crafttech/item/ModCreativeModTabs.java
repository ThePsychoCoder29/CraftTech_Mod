package net.mrmisc.crafttech.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.mrmisc.crafttech.CraftTech;
import net.mrmisc.crafttech.block.ModBlocks;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CraftTech.MOD_ID);

    public static final RegistryObject<CreativeModeTab> CRAFTTECH_TAB =
            CREATIVE_MODE_TABS.register("crafttech_tab", () -> CreativeModeTab.builder().icon(
                    ()-> new ItemStack(ModItems.RUBY.get()))
                    .title(Component.translatable("creativetab.crafttech_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.HARMONIC_PACIFIER.get());
                        output.accept(ModItems.ORE_EXTRACTOR.get());
                        output.accept(ModItems.WALL_WALKING_WAND.get());
                        output.accept(ModItems.KUNAI.get());
                        output.accept(ModItems.TEMPORARY_TELEPORTER_PEARL.get());
                        output.accept(ModItems.ETHEREAL_ELIXIR.get());
                        output.accept(ModItems.WEATHER_REMOTE.get());
                        output.accept(ModItems.HIPPO_SPAWN_EGG.get());
                        output.accept(ModItems.RUBY.get());
                        output.accept(ModItems.SAPPHIRE.get());
                        output.accept(ModItems.TOPAZ.get());
                        output.accept(ModItems.PLATINUM_INGOT.get());
                        output.accept(ModItems.TITANIUM_INGOT.get());
                        output.accept(ModItems.ADAMANTINE_INGOT.get());
                        output.accept(ModItems.COBALT_INGOT.get());


                        output.accept(ModBlocks.RUBY_ORE.get());
                        output.accept(ModBlocks.DEEPSLATE_RUBY_ORE.get());
                        output.accept(ModBlocks.NETHER_RUBY_ORE.get());
                        output.accept(ModBlocks.RUBY_BLOCK.get());
                        output.accept(ModBlocks.SAPPHIRE_ORE.get());
                        output.accept(ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get());
                        output.accept(ModBlocks.NETHER_SAPPHIRE_ORE.get());
                        output.accept(ModBlocks.SAPPHIRE_BLOCK.get());
                        output.accept(ModBlocks.PLATINUM_ORE.get());
                        output.accept(ModBlocks.DEEPSLATE_PLATINUM_ORE.get());
                        output.accept(ModBlocks.NETHER_PLATINUM_ORE.get());
                        output.accept(ModBlocks.PLATINUM_BLOCK.get());
                        output.accept(ModBlocks.TITANIUM_ORE.get());
                        output.accept(ModBlocks.DEEPSLATE_TITANIUM_ORE.get());
                        output.accept(ModBlocks.NETHER_TITANIUM_ORE.get());
                        output.accept(ModBlocks.TITANIUM_BLOCK.get());
                        output.accept(ModBlocks.TOPAZ_ORE.get());
                        output.accept(ModBlocks.DEEPSLATE_TOPAZ_ORE.get());
                        output.accept(ModBlocks.NETHER_TOPAZ_ORE.get());
                        output.accept(ModBlocks.TOPAZ_BLOCK.get());
                        output.accept(ModBlocks.ADAMANTINE_ORE.get());
                        output.accept(ModBlocks.DEEPSLATE_ADAMANTINE_ORE.get());
                        output.accept(ModBlocks.NETHER_ADAMANTINE_ORE.get());
                        output.accept(ModBlocks.ADAMANTINE_BLOCK.get());
                        output.accept(ModBlocks.COBALT_ORE.get());
                        output.accept(ModBlocks.DEEPSLATE_COBALT_ORE.get());
                        output.accept(ModBlocks.NETHER_COBALT_ORE.get());
                        output.accept(ModBlocks.COBALT_BLOCK.get());


                        output.accept(ModBlocks.GREEN_COCONUT.get());
                        output.accept(ModBlocks.COCONUT.get());
                        output.accept(ModBlocks.COCONUT_LOG.get());
                        output.accept(ModBlocks.STRIPPED_COCONUT_LOG.get());
                        output.accept(ModBlocks.COCONUT_WOOD.get());
                        output.accept(ModBlocks.STRIPPED_COCONUT_WOOD.get());
                        output.accept(ModBlocks.COCONUT_PLANKS.get());
                        output.accept(ModBlocks.COCONUT_LEAVES.get());
                        output.accept(ModBlocks.COCONUT_STAIRS.get());
                        output.accept(ModBlocks.COCONUT_BUTTON.get());
                        output.accept(ModBlocks.COCONUT_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.COCONUT_FENCE.get());
                        output.accept(ModBlocks.COCONUT_FENCE_GATE.get());
                        output.accept(ModBlocks.COCONUT_DOOR.get());
                        output.accept(ModBlocks.COCONUT_TRAPDOOR.get());

                        output.accept(ModBlocks.ELEMENT_MIXER.get());

                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
