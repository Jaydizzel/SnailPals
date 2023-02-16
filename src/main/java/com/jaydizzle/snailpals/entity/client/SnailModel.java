package com.jaydizzle.snailpals.entity.client;

import com.jaydizzle.snailpals.SnailPals;
import com.jaydizzle.snailpals.entity.custom.SnailEntityClass;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

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

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public void setLivingAnimations(SnailEntityClass entity, Integer uniqueID, AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        IBone head = this.getAnimationProcessor().getBone("eyes");

        EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
        if (head != null) {
            head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
            head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
        }
    }

}
