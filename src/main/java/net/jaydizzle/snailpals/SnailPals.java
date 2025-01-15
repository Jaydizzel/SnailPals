package net.jaydizzle.snailpals;

import net.jaydizzle.snailpals.block.JDBlocks;
import net.jaydizzle.snailpals.entity.JDEntities;
import net.jaydizzle.snailpals.entity.client.GaryRenderer;
import net.jaydizzle.snailpals.entity.client.SnailRenderer;
import net.jaydizzle.snailpals.item.JDCreativeModeTab;
import net.jaydizzle.snailpals.item.JDItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(SnailPals.MOD_ID)
public class SnailPals {
    public static final String MOD_ID = "snailpals";

    private static final Logger LOGGER = LogManager.getLogger();


    public SnailPals(IEventBus modEventBus, ModContainer modContainer) {

        modEventBus.addListener(this::commonSetup);

        JDItems.register(modEventBus);
        JDBlocks.register(modEventBus);
        JDEntities.register(modEventBus);
        JDCreativeModeTab.register(modEventBus);

        NeoForge.EVENT_BUS.register(this);

        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

private void commonSetup(final FMLCommonSetupEvent event) {
    event.enqueueWork(() -> {
    });
}

@SubscribeEvent
public void onServerStarting(ServerStartingEvent event) {
    // Do something when the server starts
    LOGGER.info("HELLO from server starting");
}

// You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
@EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public static class ClientModEvents {
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        EntityRenderers.register(JDEntities.SNAIL.get(), SnailRenderer::new);
        EntityRenderers.register(JDEntities.GARY.get(), GaryRenderer::new);

        LOGGER.info("HELLO FROM CLIENT SETUP");
        LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
    }
}
}