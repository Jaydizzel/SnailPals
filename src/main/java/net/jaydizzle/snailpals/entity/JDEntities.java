package net.jaydizzle.snailpals.entity;

import net.jaydizzle.snailpals.SnailPals;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class JDEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, SnailPals.MOD_ID);

    public static final Supplier<EntityType<SnailEntity>> SNAIL = ENTITY_TYPES.register("snail",
            () -> EntityType.Builder.of(SnailEntity::new, MobCategory.CREATURE)
                    .sized(0.5f, 0.5f)
                    .build("snail"));

    public static final Supplier<EntityType<GaryEntity>> GARY = ENTITY_TYPES.register("gary",
            () -> EntityType.Builder.of(GaryEntity::new, MobCategory.CREATURE)
                    .sized(0.5f, 0.5f)
                    .build("gary"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}