package net.jaydizzle.snailpals.entity.client;

import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import net.jaydizzle.snailpals.SnailPals;
import net.jaydizzle.snailpals.entity.SnailEntity;
import net.jaydizzle.snailpals.entity.variant.SnailVariant;
import net.minecraft.Util;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import java.util.Map;

public class SnailRenderer extends MobRenderer<SnailEntity, SnailModel<SnailEntity>> {
    public SnailRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new SnailModel<>(pContext.bakeLayer(JDModelLayers.SNAIL_LAYER)), 0.25f);
    }
    public static final Map<SnailVariant, ResourceLocation> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(SnailVariant.class), (resourceLocation) -> {
                resourceLocation.put(SnailVariant.DEFAULT,
                        ResourceLocation.fromNamespaceAndPath(SnailPals.MOD_ID, "textures/entity/snail/snail.png"));
                resourceLocation.put(SnailVariant.PINK,
                        ResourceLocation.fromNamespaceAndPath(SnailPals.MOD_ID, "textures/entity/snail/pink_snail.png"));
                resourceLocation.put(SnailVariant.GREEN,
                        ResourceLocation.fromNamespaceAndPath(SnailPals.MOD_ID, "textures/entity/snail/green_snail.png"));
                resourceLocation.put(SnailVariant.YELLOW,
                        ResourceLocation.fromNamespaceAndPath(SnailPals.MOD_ID, "textures/entity/snail/yellow_snail.png"));
            });
    @Override
    public ResourceLocation getTextureLocation(SnailEntity pEntity) {
        return LOCATION_BY_VARIANT.get(pEntity.getVariant());
    }

    @Override
    public void render(SnailEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {
        if(pEntity.isBaby()) {
            pMatrixStack.scale(0.3f, 0.3f, 0.3f);
        } else {
            pMatrixStack.scale(0.5f, 0.5f, 0.5f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}