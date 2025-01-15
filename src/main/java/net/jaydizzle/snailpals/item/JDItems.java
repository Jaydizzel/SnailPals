package net.jaydizzle.snailpals.item;

import net.jaydizzle.snailpals.SnailPals;
import net.jaydizzle.snailpals.entity.JDEntities;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class JDItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(SnailPals.MOD_ID);
    public static final DeferredItem<Item> SNAIL_SPAWN_EGG = ITEMS.register("snail_spawn_egg",
            () -> new DeferredSpawnEggItem(JDEntities.SNAIL, 0xBC8238, 0x40AB20,
                    new Item.Properties()));

    public static final DeferredItem<Item> GARY_SPAWN_EGG = ITEMS.register("gary_spawn_egg",
            () -> new DeferredSpawnEggItem(JDEntities.GARY, 0x1ecbe1, 0xfd79be,
                    new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
