package net.mrmisc.crafttech.entity.client;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import net.mrmisc.crafttech.CraftTech;

public class ModModelLayers {
    public static final ModelLayerLocation HIPPO_LAYER = new ModelLayerLocation(
            new ResourceLocation(CraftTech.MOD_ID, "hippo"), "main");
    public static final ModelLayerLocation PINE_BOAT_LAYER = new ModelLayerLocation(
            new ResourceLocation(CraftTech.MOD_ID, "boat/coconut"), "main");
    public static final ModelLayerLocation PINE_CHEST_BOAT_LAYER = new ModelLayerLocation(
            new ResourceLocation(CraftTech.MOD_ID, "chest_boat/coconut"), "main");
}
