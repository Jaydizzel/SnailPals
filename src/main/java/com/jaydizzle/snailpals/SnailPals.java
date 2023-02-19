package com.jaydizzle.snailpals;

import com.jaydizzle.snailpals.block.JDBlocks;
import com.jaydizzle.snailpals.entity.JDEntityTypes;
import com.jaydizzle.snailpals.entity.client.SnailRenderer;
import com.jaydizzle.snailpals.entity.custom.SnailEntityClass;
import com.jaydizzle.snailpals.item.JDItems;
import com.jaydizzle.snailpals.world.feature.JDConfiguredFeatures;
import com.jaydizzle.snailpals.world.feature.JDPlacedFeatures;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import software.bernie.geckolib3.GeckoLib;

@Mod(SnailPals.MOD_ID)

public class SnailPals {

    public static final String MOD_ID = "snailpals";

    private static final Logger LOGGER = LogManager.getLogger();

    public SnailPals() {

        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        GeckoLib.initialize();

        JDConfiguredFeatures.register(eventBus);
        JDPlacedFeatures.register(eventBus);
        JDEntityTypes.register(eventBus);
        JDItems.register(eventBus);
        JDBlocks.register(eventBus);
        eventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);

    }
    public void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
                    SpawnPlacements.register(JDEntityTypes.SNAIL.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE,
                            SnailEntityClass::canSpawn);
                });
            }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents {

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            EntityRenderers.register(JDEntityTypes.SNAIL.get(), SnailRenderer::new);
        }
    }
}