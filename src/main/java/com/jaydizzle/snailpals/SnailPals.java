package com.jaydizzle.snailpals;

import com.jaydizzle.snailpals.entity.JDEntityTypes;
import com.jaydizzle.snailpals.entity.client.SnailRenderer;
import com.jaydizzle.snailpals.item.JDItems;
import net.minecraft.client.renderer.entity.EntityRenderers;
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

        eventBus.addListener(this::commonSetup);

        JDEntityTypes.register(eventBus);
        JDItems.register(eventBus);

        MinecraftForge.EVENT_BUS.register(this);

    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {

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