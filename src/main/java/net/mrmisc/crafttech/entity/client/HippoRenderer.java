package net.mrmisc.crafttech.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.mrmisc.crafttech.CraftTech;
import net.mrmisc.crafttech.entity.custom.HippoEntity;
import net.mrmisc.crafttech.entity.custom.HippoModel;

public class HippoRenderer extends MobRenderer<HippoEntity, HippoModel<HippoEntity>>{

    public HippoRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new HippoModel<>(pContext.bakeLayer(ModModelLayers.HIPPO_LAYER)), 2f);
    }

    @Override
    public ResourceLocation getTextureLocation(HippoEntity hippoEntity) {
        return new ResourceLocation(CraftTech.MOD_ID, "textures/entity/hippo.png");
    }

    @Override
    public void render(HippoEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        if (pEntity.isBaby()){
            pMatrixStack.scale(0.5f, 0.5f, 0.5f );
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}