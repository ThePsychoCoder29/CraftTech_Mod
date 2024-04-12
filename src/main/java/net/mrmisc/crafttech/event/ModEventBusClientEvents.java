package net.mrmisc.crafttech.event;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.mrmisc.crafttech.CraftTech;
import net.mrmisc.crafttech.block.entity.ModBlockEntities;
import net.mrmisc.crafttech.block.entity.renderer.ElementMixerBlockEntityRenderer;
import net.mrmisc.crafttech.entity.client.ModModelLayers;
import net.mrmisc.crafttech.entity.custom.HippoModel;

@Mod.EventBusSubscriber(modid = CraftTech.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventBusClientEvents {
    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event){
        event.registerLayerDefinition(ModModelLayers.HIPPO_LAYER, HippoModel::createBodyLayer);
    }

    public static void registerBER(EntityRenderersEvent.RegisterRenderers event){
        event.registerBlockEntityRenderer(ModBlockEntities.ELEMENT_MIXER_BE.get(), ElementMixerBlockEntityRenderer::new);
    }
}
