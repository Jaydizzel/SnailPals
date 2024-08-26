package com.jaydizzle.snailpals;

import com.jaydizzle.snailpals.block.JDBlocks;
import com.jaydizzle.snailpals.entity.GaryEntity;
import com.jaydizzle.snailpals.entity.JDEntities;
import com.jaydizzle.snailpals.entity.SnailEntity;
import com.jaydizzle.snailpals.entity.client.GaryRenderer;
import com.jaydizzle.snailpals.entity.client.SnailRenderer;
import com.jaydizzle.snailpals.item.JDCreativeModeTab;
import com.jaydizzle.snailpals.item.JDItems;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(SnailPals.MOD_ID)
public class SnailPals {
    public static final String MOD_ID = "snailpals";

    private static final Logger LOGGER = LogManager.getLogger();


    public SnailPals() {
    IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        JDItems.register(eventBus);
        JDBlocks.register(eventBus);
        JDEntities.register(eventBus);
        JDCreativeModeTab.register(eventBus);

        eventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);

}

private void commonSetup(final FMLCommonSetupEvent event) {
}

@SubscribeEvent
public void onServerStarting(ServerStartingEvent event) {

}

@Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public static class ClientModEvents {
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        EntityRenderers.register(JDEntities.SNAIL.get(), SnailRenderer::new);
        EntityRenderers.register(JDEntities.GARY.get(), GaryRenderer::new);

    }
    }
}