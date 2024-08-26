package com.jaydizzle.snailpals.item;

import com.jaydizzle.snailpals.SnailPals;
import com.jaydizzle.snailpals.block.JDBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class JDCreativeModeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SnailPals.MOD_ID);

    public static final RegistryObject<CreativeModeTab> SNAIL_TAB = CREATIVE_MODE_TABS.register("snail_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(JDBlocks.SNAIL_SHELL.get()))
                    .title(Component.translatable("creativetab.snail_tab"))
                    .displayItems((pParameters, pOutput) -> {

                        pOutput.accept(JDBlocks.SNAIL_SHELL.get());
                        pOutput.accept(JDItems.SNAIL_SPAWN_EGG.get());
                        pOutput.accept(JDBlocks.GARY_SHELL.get());
                        pOutput.accept(JDItems.GARY_SPAWN_EGG.get());

                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}