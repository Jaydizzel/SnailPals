package net.jaydizzle.snailpals.events;

import net.jaydizzle.snailpals.SnailPals;
import net.jaydizzle.snailpals.entity.GaryEntity;
import net.jaydizzle.snailpals.entity.JDEntities;
import net.jaydizzle.snailpals.entity.SnailEntity;
import net.jaydizzle.snailpals.entity.client.GaryModel;
import net.jaydizzle.snailpals.entity.client.JDModelLayers;
import net.jaydizzle.snailpals.entity.client.SnailModel;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.level.levelgen.Heightmap;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;

@EventBusSubscriber(modid = SnailPals.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class JDEventBusEvents {
    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(JDModelLayers.SNAIL_LAYER, SnailModel::createBodyLayer);
        event.registerLayerDefinition(JDModelLayers.GARY_LAYER, GaryModel::createBodyLayer);

    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(JDEntities.SNAIL.get(), SnailEntity.createAttributes().build());
        event.put(JDEntities.GARY.get(), GaryEntity.createAttributes().build());

    }

    @SubscribeEvent
    public static void registerSpawnPlacements(RegisterSpawnPlacementsEvent event) {
        event.register(JDEntities.SNAIL.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.WORLD_SURFACE, SnailEntity::canSpawn, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        event.register(JDEntities.GARY.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.WORLD_SURFACE, GaryEntity::canSpawn, RegisterSpawnPlacementsEvent.Operation.OR);
    }
}
