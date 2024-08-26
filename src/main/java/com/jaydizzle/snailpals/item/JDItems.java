package com.jaydizzle.snailpals.item;

import com.jaydizzle.snailpals.SnailPals;
import com.jaydizzle.snailpals.entity.JDEntities;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class JDItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SnailPals.MOD_ID);
    public static final RegistryObject<Item> SNAIL_SPAWN_EGG = ITEMS.register("snail_spawn_egg",
            () -> new ForgeSpawnEggItem(JDEntities.SNAIL, 0xBC8238, 0x40AB20,
                    new Item.Properties()));

    public static final RegistryObject<Item> GARY_SPAWN_EGG = ITEMS.register("gary_spawn_egg",
            () -> new ForgeSpawnEggItem(JDEntities.GARY, 0x1ecbe1, 0xfd79be,
                    new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);

    }

}
