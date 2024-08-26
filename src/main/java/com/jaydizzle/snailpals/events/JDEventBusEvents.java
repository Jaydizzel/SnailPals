package com.jaydizzle.snailpals.events;

import com.jaydizzle.snailpals.SnailPals;
import com.jaydizzle.snailpals.entity.GaryEntity;
import com.jaydizzle.snailpals.entity.JDEntities;
import com.jaydizzle.snailpals.entity.SnailEntity;
import com.jaydizzle.snailpals.entity.client.JDModelLayers;
import com.jaydizzle.snailpals.entity.client.SnailModel;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SnailPals.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class JDEventBusEvents {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(JDEntities.SNAIL.get(), SnailEntity.createAttributes().build());
        event.put(JDEntities.GARY.get(), GaryEntity.createAttributes().build());

    }

    @SubscribeEvent
    public static void registerSpawnPlacements(SpawnPlacementRegisterEvent event) {
        event.register(JDEntities.SNAIL.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, SnailEntity::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);
        event.register(JDEntities.GARY.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, GaryEntity::canSpawn, SpawnPlacementRegisterEvent.Operation.OR);

    }
}
