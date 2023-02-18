package com.jaydizzle.snailpals.item;

import com.jaydizzle.snailpals.SnailPals;
import com.jaydizzle.snailpals.entity.JDEntityTypes;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class JDItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, SnailPals.MOD_ID);

    public static final RegistryObject<Item> SNAIL_SPAWN_EGG = ITEMS.register("snail_spawn_egg",
            () -> new ForgeSpawnEggItem(JDEntityTypes.SNAIL, 0xBC8238, 0x40AB20,
                    new Item.Properties().tab(JDCreativeModeTab.SNAIL_TAB)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
