package com.jaydizzle.snailpals.event;

import com.jaydizzle.snailpals.SnailPals;
import com.jaydizzle.snailpals.entity.JDEntityTypes;
import com.jaydizzle.snailpals.entity.custom.SnailEntityClass;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

public class JDEvents {

    @Mod.EventBusSubscriber(modid = SnailPals.MOD_ID)
    public static class ForgeEvents {

    }

    @Mod.EventBusSubscriber(modid = SnailPals.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ModEventBusEvents {

        @SubscribeEvent
        public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
            event.put(JDEntityTypes.SNAIL.get(), SnailEntityClass.setAttributes());
        }
    }
}