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

public class HippoModel<T extends Entity> extends HierarchicalModel<T> {

    private static final Vector3f ANIMATION_VECTOR_CACHE = new Vector3f();
	private final ModelPart hippo;
	private final ModelPart legs;
	private final ModelPart body;
	private final ModelPart head;
	private final ModelPart ears;
	private final ModelPart jaw;
	private final ModelPart tail;
	private final ModelPart hind_legs;
	private final ModelPart front_legs;

	public HippoModel(ModelPart root) {
		this.hippo = root.getChild("hippo");
		this.body = hippo.getChild("body");
		this.head = hippo.getChild("head");
		this.legs = hippo.getChild("legs");
		this.ears = hippo.getChild("head").getChild("ears");
		this.jaw = hippo.getChild("head").getChild("jaw");
		this.tail = hippo.getChild("body").getChild("tail");
		this.hind_legs = hippo.getChild("legs").getChild("hind_legs");
		this.front_legs = hippo.getChild("legs").getChild("front_legs");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition hippo = partdefinition.addOrReplaceChild("hippo", CubeListBuilder.create(), PartPose.offset(-5.0F, 24.0F, -5.0F));

		PartDefinition body = hippo.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -36.0F, -12.0F, 20.0F, 25.0F, 33.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition tail = body.addOrReplaceChild("tail", CubeListBuilder.create(), PartPose.offset(5.0F, -31.0F, 21.0F));

		PartDefinition cube_r1 = tail.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(20, 17).addBox(4.0F, -27.0F, 27.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 31.0F, -21.0F, 0.2182F, 0.0F, 0.0F));

		PartDefinition head = hippo.addOrReplaceChild("head", CubeListBuilder.create().texOffs(61, 57).addBox(-2.0F, -31.0F, -44.0F, 14.0F, 8.0F, 19.0F, new CubeDeformation(0.0F))
		.texOffs(0, 58).addBox(-2.0F, -30.0F, -30.0F, 14.0F, 14.0F, 18.0F, new CubeDeformation(0.0F))
		.texOffs(49, 84).addBox(-2.0F, -37.0F, -25.0F, 14.0F, 7.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition ears = head.addOrReplaceChild("ears", CubeListBuilder.create().texOffs(10, 17).addBox(7.0F, -4.0F, -2.0F, 2.0F, 5.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 17).addBox(-9.0F, -4.0F, -2.0F, 2.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, -36.0F, -16.0F));

		PartDefinition jaw = head.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(74, 1).addBox(-7.0F, -0.281F, -16.2588F, 14.0F, 6.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, -23.0F, -27.0F));

		PartDefinition legs = hippo.addOrReplaceChild("legs", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition hind_legs = legs.addOrReplaceChild("hind_legs", CubeListBuilder.create().texOffs(44, 58).addBox(3.0F, 0.0F, -6.0F, 6.0F, 11.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(24, 90).addBox(-9.0F, 0.0F, -6.0F, 6.0F, 11.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, -11.0F, 19.0F));

		PartDefinition front_legs = legs.addOrReplaceChild("front_legs", CubeListBuilder.create().texOffs(0, 90).addBox(3.0F, 0.0F, -3.0F, 6.0F, 11.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-9.0F, 0.0F, -3.0F, 6.0F, 11.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, -11.0F, -6.0F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.applyHeadRotation((HippoEntity) entity, netHeadYaw, headPitch, ageInTicks);

        this.animateWalk(ModAnimationDefinitions.RUNNING, limbSwing, limbSwingAmount, 2f, 2.5f);
        this.animate(((HippoEntity) entity).idle, ModAnimationDefinitions.IDLE, ageInTicks, 1f  );
	}

    private void applyHeadRotation(HippoEntity entity, float headYaw, float headPitch, float ageInTicks){
        headYaw = Mth.clamp(headYaw, -10.0f, 30.0f);
        headPitch = Mth.clamp(headPitch, -25.0f, 45.0f);

        this.head.yRot = headYaw * ((float)Math.PI / 180F);
        this.head.xRot = headPitch * ((float)Math.PI / 180F);
    }

    protected void animateRun(AnimationDefinition pAnimationDefinition, float pLimbSwing, float pLimbSwingAmount, float pMaxAnimationSpeed, float pAnimationScaleFactor) {
        long $$5 = (long)(pLimbSwing * 100.0f * pMaxAnimationSpeed);
        float $$6 = Math.min(pLimbSwingAmount * pAnimationScaleFactor, 2.0F);
        KeyframeAnimations.animate(this, pAnimationDefinition, $$5, $$6, ANIMATION_VECTOR_CACHE);
    }

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		hippo.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return hippo;
	}

}