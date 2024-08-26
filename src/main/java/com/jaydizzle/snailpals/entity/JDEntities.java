package com.jaydizzle.snailpals.entity;

import com.jaydizzle.snailpals.SnailPals;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class JDEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, SnailPals.MOD_ID);

    public static final RegistryObject<EntityType<SnailEntity>> SNAIL = ENTITY_TYPES.register("snail",
            () -> EntityType.Builder.of(SnailEntity::new, MobCategory.CREATURE)
                    .sized(0.5f, 0.5f)
                    .build(new ResourceLocation(SnailPals.MOD_ID, "snail").toString()));

    public static final RegistryObject<EntityType<GaryEntity>> GARY = ENTITY_TYPES.register("gary",
            () -> EntityType.Builder.of(GaryEntity::new, MobCategory.CREATURE)
                    .sized(0.5f, 0.5f)
                    .build(new ResourceLocation(SnailPals.MOD_ID, "gary").toString()));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}