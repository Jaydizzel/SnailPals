package com.jaydizzle.snailpals.event;

import com.jaydizzle.snailpals.SnailPals;
import com.jaydizzle.snailpals.entity.JDEntityTypes;
import com.jaydizzle.snailpals.entity.client.GaryRenderer;
import com.jaydizzle.snailpals.entity.client.SnailRenderer;
import com.jaydizzle.snailpals.entity.custom.GaryEntityClass;
import com.jaydizzle.snailpals.entity.custom.SnailEntityClass;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import java.util.List;

public class JDEvents {

    @Mod.EventBusSubscriber(modid = SnailPals.MOD_ID)
    public static class ForgeEvents {

    }

    @Mod.EventBusSubscriber(modid = SnailPals.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ModEventBusEvents {

        @SubscribeEvent
        public static void entityAttributes(EntityAttributeCreationEvent event) {
            event.put(JDEntityTypes.SNAIL.get(), SnailEntityClass.setAttributes());
            event.put(JDEntityTypes.GARY.get(), GaryEntityClass.setAttributes());

        }
    }
}