package com.jaydizzle.snailpals.entity.client;

import com.google.common.collect.Maps;
import com.jaydizzle.snailpals.SnailPals;
import com.jaydizzle.snailpals.entity.GaryEntity;
import com.jaydizzle.snailpals.entity.SnailEntity;
import com.jaydizzle.snailpals.entity.variant.SnailVariant;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.Util;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import java.util.Map;

public class GaryRenderer extends MobRenderer<GaryEntity, GaryModel<GaryEntity>> {
    public GaryRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new GaryModel<>(pContext.bakeLayer(JDModelLayers.GARY_LAYER)), 0.25f);
    }

    @Override
    public ResourceLocation getTextureLocation(GaryEntity pEntity) {
        return new ResourceLocation(SnailPals.MOD_ID, "textures/entity/snail/gary.png");
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