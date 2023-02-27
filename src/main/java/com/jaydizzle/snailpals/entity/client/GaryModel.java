package com.jaydizzle.snailpals.entity.client;

import com.jaydizzle.snailpals.SnailPals;
import com.jaydizzle.snailpals.entity.custom.GaryEntityClass;
import com.jaydizzle.snailpals.entity.custom.SnailEntityClass;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class GaryModel extends AnimatedGeoModel<GaryEntityClass> {

    @Override
    public ResourceLocation getModelResource(GaryEntityClass object) {
        return new ResourceLocation(SnailPals.MOD_ID, "geo/snail.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GaryEntityClass object) {
        return new ResourceLocation(SnailPals.MOD_ID, "textures/entity/snail/gary.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GaryEntityClass animatable) {
        return new ResourceLocation(SnailPals.MOD_ID, "animations/snail.animation.json");
    }

}
