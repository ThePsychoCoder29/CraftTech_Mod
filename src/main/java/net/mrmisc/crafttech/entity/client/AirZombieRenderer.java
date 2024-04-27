package net.mrmisc.crafttech.entity.client;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.ZombieRenderer;
import net.minecraft.resources.ResourceLocation;
import net.mrmisc.crafttech.CraftTech;
import net.mrmisc.crafttech.entity.custom.AirZombie;
import net.mrmisc.crafttech.entity.custom.AirZombieEntity;
import net.mrmisc.crafttech.entity.custom.HippoModel;

public class AirZombieRenderer extends MobRenderer<AirZombieEntity, AirZombie<AirZombieEntity>> {
    public AirZombieRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new AirZombie<>(pContext.bakeLayer(ModModelLayers.AIR_ZOMBIE_LAYER)), 2f);
    }

    @Override
    public ResourceLocation getTextureLocation(AirZombieEntity airZombieEntity) {
        return new ResourceLocation(CraftTech.MOD_ID, "textures/entity/air_zombie.png");
    }
}
