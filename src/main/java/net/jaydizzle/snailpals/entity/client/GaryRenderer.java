package net.jaydizzle.snailpals.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.jaydizzle.snailpals.SnailPals;
import net.jaydizzle.snailpals.entity.GaryEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class GaryRenderer extends MobRenderer<GaryEntity, GaryModel<GaryEntity>> {
    public GaryRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new GaryModel<>(pContext.bakeLayer(JDModelLayers.GARY_LAYER)), 0.25f);
    }

    @Override
    public ResourceLocation getTextureLocation(GaryEntity pEntity) {
        return ResourceLocation.fromNamespaceAndPath(SnailPals.MOD_ID, "textures/entity/snail/gary.png");
    }
    @Override
    public void render(GaryEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {
        if(pEntity.isBaby()) {
            pMatrixStack.scale(0.3f, 0.3f, 0.3f);
        } else {
            pMatrixStack.scale(0.5f, 0.5f, 0.5f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}