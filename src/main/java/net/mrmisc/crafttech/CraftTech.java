package net.mrmisc.crafttech;

import com.mojang.logging.LogUtils;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.mrmisc.crafttech.block.ModBlocks;
import net.mrmisc.crafttech.block.entity.ModBlockEntities;
import net.mrmisc.crafttech.effect.ModEffects;
import net.mrmisc.crafttech.entity.ModEntities;
import net.mrmisc.crafttech.entity.client.AirZombieRenderer;
import net.mrmisc.crafttech.entity.client.HippoRenderer;
import net.mrmisc.crafttech.entity.client.ModBoatRenderer;
import net.mrmisc.crafttech.item.ModCreativeModTabs;
import net.mrmisc.crafttech.item.ModItems;
import net.mrmisc.crafttech.potion.ModPotions;
import net.mrmisc.crafttech.recipe.ModRecipes;
import net.mrmisc.crafttech.screen.ElementMixerScreen;
import net.mrmisc.crafttech.screen.ModMenuTypes;
import net.mrmisc.crafttech.sound.ModSounds;
import net.mrmisc.crafttech.util.ModWoodTypes;
import net.mrmisc.crafttech.villager.ModVillagers;
import net.mrmisc.crafttech.worldgen.ModTrunkPlacerTypes;
import net.mrmisc.crafttech.worldgen.tree.ModFoliagePlacers;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(CraftTech.MOD_ID)
public class CraftTech {
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "crafttech";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();

    public CraftTech() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModCreativeModTabs.register(modEventBus);
        ModEntities.register(modEventBus);
        ModEffects.register(modEventBus);
        ModTrunkPlacerTypes.register(modEventBus);
        ModFoliagePlacers.register(modEventBus);
        ModBlockEntities.register(modEventBus);
        ModMenuTypes.register(modEventBus);
        ModVillagers.register(modEventBus);
        ModSounds.register(modEventBus);
        ModRecipes.register(modEventBus);
        ModPotions.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);

    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {

    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            Sheets.addWoodType(ModWoodTypes.COCONUT);
            EntityRenderers.register(ModEntities.KUNAI.get(), ThrownItemRenderer::new);
            EntityRenderers.register(ModEntities.TEMPORARY_TELEPORTER_PEARL.get(), ThrownItemRenderer::new);
            EntityRenderers.register(ModEntities.HIPPO.get(), HippoRenderer::new);
            EntityRenderers.register(ModEntities.AIR_ZOMBIE.get(), AirZombieRenderer::new);
            EntityRenderers.register(ModEntities.MOD_BOAT.get(), context -> new ModBoatRenderer(context, false));
            EntityRenderers.register(ModEntities.MOD_CHEST_BOAT.get(), context -> new ModBoatRenderer(context, true));
            MenuScreens.register(ModMenuTypes.ELEMENT_MIXER_MENU.get(), ElementMixerScreen::new);
        }
    }
}

