package net.jaydizzle.snailpals.entity.client;

import net.jaydizzle.snailpals.SnailPals;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public class JDModelLayers {
    public static final ModelLayerLocation SNAIL_LAYER = new ModelLayerLocation(
            ResourceLocation.fromNamespaceAndPath(SnailPals.MOD_ID, "snail_layer"), "main");
    public static final ModelLayerLocation GARY_LAYER = new ModelLayerLocation(
            ResourceLocation.fromNamespaceAndPath(SnailPals.MOD_ID, "gary_layer"), "main1");
}
