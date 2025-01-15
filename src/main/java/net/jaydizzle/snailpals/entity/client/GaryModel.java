package net.jaydizzle.snailpals.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.Entity;

public class GaryModel<T extends Entity> extends HierarchicalModel<T> {

	private final ModelPart snail;
	private final ModelPart body;
	private final ModelPart shell;
	private final ModelPart eyes;
	private final ModelPart face;
	private final ModelPart torso;

	public GaryModel(ModelPart root) {
		this.snail = root.getChild("snail");
		this.body = snail.getChild("body");
		this.shell = snail.getChild("body").getChild("shell");
		this.eyes = snail.getChild("body").getChild("eyes");
		this.face = snail.getChild("body").getChild("face");
		this.torso = snail.getChild("body").getChild("torso");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition snail = partdefinition.addOrReplaceChild("snail", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition body = snail.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition shell = body.addOrReplaceChild("shell", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition shellbase_r1 = shell.addOrReplaceChild("shellbase_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -12.0F, -3.25F, 6.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition eyes = body.addOrReplaceChild("eyes", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition righteyepole_r1 = eyes.addOrReplaceChild("righteyepole_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-0.75F, -10.25F, -6.25F, 0.5F, 6.0F, 0.5F, new CubeDeformation(0.0F))
				.texOffs(0, 7).addBox(-1.0F, -11.25F, -6.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2182F, 0.0873F, 0.0F));

		PartDefinition lefteyepole_r1 = eyes.addOrReplaceChild("lefteyepole_r1", CubeListBuilder.create().texOffs(4, 0).addBox(0.25F, -10.25F, -6.25F, 0.5F, 6.0F, 0.5F, new CubeDeformation(0.0F))
				.texOffs(4, 7).addBox(0.0F, -11.25F, -6.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2182F, -0.0873F, 0.0F));

		PartDefinition face = body.addOrReplaceChild("face", CubeListBuilder.create().texOffs(4, 20).addBox(-2.0F, -2.0F, -8.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 20).addBox(1.0F, -2.0F, -8.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition torso = body.addOrReplaceChild("torso", CubeListBuilder.create().texOffs(0, 36).addBox(-2.0F, -1.0F, -7.0F, 4.0F, 1.0F, 14.0F, new CubeDeformation(0.0F))
				.texOffs(22, 22).addBox(-2.0F, -2.0F, -7.0F, 4.0F, 1.0F, 14.0F, new CubeDeformation(0.0F))
				.texOffs(0, 21).addBox(-2.0F, -4.0F, -7.0F, 4.0F, 1.0F, 14.0F, new CubeDeformation(0.0F))
				.texOffs(18, 6).addBox(-2.0F, -3.0F, -7.0F, 4.0F, 1.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
		snail.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
	}

	@Override
	public ModelPart root() {
		return snail;
	}
}