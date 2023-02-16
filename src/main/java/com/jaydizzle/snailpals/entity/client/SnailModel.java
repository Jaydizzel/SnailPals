package com.jaydizzle.snailpals.entity.client;

import com.jaydizzle.snailpals.SnailPals;
import com.jaydizzle.snailpals.entity.custom.SnailEntityClass;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class SnailModel extends AnimatedGeoModel<SnailEntityClass> {
    @Override
    public ResourceLocation getModelResource(SnailEntityClass object) {
        return new ResourceLocation(SnailPals.MOD_ID, "geo/snail.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SnailEntityClass object) {
        return SnailRenderer.LOCATION_BY_VARIANT.get(object.getVariant());
    }

    @Override
    public ResourceLocation getAnimationResource(SnailEntityClass animatable) {
        return new ResourceLocation(SnailPals.MOD_ID, "animations/snail.animation.json");
    }

}
