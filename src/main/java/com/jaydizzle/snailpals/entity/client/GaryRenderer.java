package com.jaydizzle.snailpals.entity.client;

import com.google.common.collect.Maps;
import com.jaydizzle.snailpals.SnailPals;
import com.jaydizzle.snailpals.entity.custom.GaryEntityClass;
import com.jaydizzle.snailpals.entity.custom.SnailEntityClass;
import com.jaydizzle.snailpals.entity.variant.SnailVariant;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.Util;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import java.util.Map;

public class GaryRenderer extends GeoEntityRenderer<GaryEntityClass> {

    public GaryRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new GaryModel());
        this.shadowRadius = 0.2f;
    }

    @Override
    public ResourceLocation getTextureLocation(GaryEntityClass instance) {
        return new ResourceLocation(SnailPals.MOD_ID, "textures/entity/snail/gary.png");
    }

    @Override
    public RenderType getRenderType(GaryEntityClass animatable, float partialTick, PoseStack stack,
                                    @Nullable MultiBufferSource bufferSource,
                                    @Nullable VertexConsumer buffer, int packedLight,
                                    ResourceLocation texture) {
        if (animatable.isBaby()) {
            stack.scale(0.4f, 0.4f, 0.4f);
        } else {
            stack.scale(0.8f, 0.8f, 0.8f);
        }
            return super.getRenderType(animatable, partialTick, stack, bufferSource, buffer, packedLight, texture);
        }
    }

