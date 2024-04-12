package net.mrmisc.crafttech.event;

import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.mrmisc.crafttech.CraftTech;
import net.mrmisc.crafttech.entity.ModEntities;
import net.mrmisc.crafttech.entity.custom.HippoEntity;

@Mod.EventBusSubscriber(modid = CraftTech.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event){
        event.put(ModEntities.HIPPO.get(), HippoEntity.createAttributes().build());
    }
}
