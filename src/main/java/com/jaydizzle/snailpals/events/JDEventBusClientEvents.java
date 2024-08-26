package com.jaydizzle.snailpals.events;

import com.jaydizzle.snailpals.SnailPals;
import com.jaydizzle.snailpals.entity.client.GaryModel;
import com.jaydizzle.snailpals.entity.client.JDModelLayers;
import com.jaydizzle.snailpals.entity.client.SnailModel;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SnailPals.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class JDEventBusClientEvents {
    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(JDModelLayers.SNAIL_LAYER, SnailModel::createBodyLayer);
        event.registerLayerDefinition(JDModelLayers.GARY_LAYER, GaryModel::createBodyLayer);

    }

}
