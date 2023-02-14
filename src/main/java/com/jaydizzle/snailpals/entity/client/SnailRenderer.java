package com.jaydizzle.snailpals.entity.client;

import com.jaydizzle.snailpals.SnailPals;
import com.jaydizzle.snailpals.entity.custom.SnailEntityClass;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class SnailRenderer extends GeoEntityRenderer<SnailEntityClass> {
    public SnailRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager,  new SnailModel());
        this.shadowRadius = 0.3f;
    }
    @Override
    public ResourceLocation getTextureLocation(SnailEntityClass instance) {
        return new ResourceLocation(SnailPals.MOD_ID, "textures/entity/snail.png");
    }

    @Override
    public RenderType getRenderType(SnailEntityClass animatable, float partialTick, PoseStack stack,
                                    @Nullable MultiBufferSource bufferSource,
                                    @Nullable VertexConsumer buffer, int packedLight,
                                    ResourceLocation texture) {
        stack.scale(0.8f, 0.8f, 0.8f);
        return super.getRenderType(animatable, partialTick, stack, bufferSource, buffer, packedLight, texture);
    }
}
