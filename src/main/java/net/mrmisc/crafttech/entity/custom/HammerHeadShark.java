package net.mrmisc.crafttech.entity.custom;// Made with Blockbench 4.9.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.KeyframeAnimations;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.mrmisc.crafttech.entity.animations.ModAnimationDefinitions;
import org.joml.Vector3f;

public class HammerHeadShark<T extends Entity> extends HierarchicalModel<T> {
	private final ModelPart hammerhead_shark;

	public HammerHeadShark(ModelPart root) {
		this.hammerhead_shark = root.getChild("hammerhead_shark");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition hammerhead_shark = partdefinition.addOrReplaceChild("hammerhead_shark", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition body = hammerhead_shark.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(6.0F, -2.0F, 17.0F, 16.0F, 10.0F, 32.0F, new CubeDeformation(0.0F))
		.texOffs(0, 63).addBox(6.0F, -3.0F, 3.0F, 16.0F, 6.0F, 14.0F, new CubeDeformation(0.0F))
		.texOffs(9, 5).addBox(13.0F, -7.0F, 27.0F, 2.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(64, 0).addBox(-1.0F, -3.0F, -4.0F, 30.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-14.0F, -8.0F, -41.0F));

		PartDefinition cube_r1 = body.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(45, 84).addBox(12.0F, -3.0F, 6.0F, 15.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.3491F, 0.0F));

		PartDefinition cube_r2 = body.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(85, 84).addBox(0.0F, -3.0F, -4.0F, 15.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.3491F, 0.0F));

		PartDefinition cube_r3 = body.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, 0.0F, 2.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(13.0F, -5.8154F, 26.5979F, 0.9163F, 0.0F, 0.0F));

		PartDefinition jaw = hammerhead_shark.addOrReplaceChild("jaw", CubeListBuilder.create(), PartPose.offset(-1.0F, -4.0F, -25.0F));

		PartDefinition cube_r4 = jaw.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 83).addBox(-7.0F, -1.0F, -12.0F, 16.0F, 4.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0873F, 0.0F, 0.0F));

		PartDefinition tail = hammerhead_shark.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(18, 0).addBox(-1.0F, -7.0F, 7.0F, 2.0F, 4.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 15).addBox(-2.0F, -2.0F, 14.0F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -5.0F, 5.0F));

		PartDefinition cube_r5 = tail.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(58, 95).addBox(-1.0F, -2.0F, -1.0F, 15.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 18.0F, 0.0F, -0.6109F, 0.0F));

		PartDefinition cube_r6 = tail.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(93, 39).addBox(-14.0F, -2.0F, -1.0F, 15.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 18.0F, 0.0F, 0.6109F, 0.0F));

		PartDefinition cube_r7 = tail.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(14, 15).addBox(0.0F, 1.0F, 1.0F, 2.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -6.8154F, 5.5979F, 0.9163F, 0.0F, 0.0F));

		PartDefinition cube_r8 = tail.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(-1, 41).addBox(-8.0F, -4.0F, 5.0F, 16.0F, 5.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.0F, -5.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition cube_r9 = tail.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(47, 46).addBox(-8.0F, -11.0F, 3.0F, 16.0F, 5.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.0F, -5.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition arms = hammerhead_shark.addOrReplaceChild("arms", CubeListBuilder.create(), PartPose.offset(-1.0F, -2.0F, -11.0F));

		PartDefinition left_fin = arms.addOrReplaceChild("left_fin", CubeListBuilder.create(), PartPose.offset(10.0F, 0.0F, 0.0F));

		PartDefinition cube_r10 = left_fin.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(60, 68).addBox(-1.0F, -1.0F, -7.0F, 17.0F, 2.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.1745F));

		PartDefinition right_fin = arms.addOrReplaceChild("right_fin", CubeListBuilder.create(), PartPose.offset(-7.0F, 1.0F, 0.0F));

		PartDefinition cube_r11 = right_fin.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(64, 11).addBox(-34.0F, -3.0F, -7.0F, 17.0F, 2.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(17.0F, -1.0F, 0.0F, 0.0F, 0.0F, -0.1745F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		hammerhead_shark.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return hammerhead_shark;
	}
}