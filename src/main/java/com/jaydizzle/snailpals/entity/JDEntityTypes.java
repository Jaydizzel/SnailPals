package com.jaydizzle.snailpals.entity;

import com.jaydizzle.snailpals.SnailPals;
import com.jaydizzle.snailpals.entity.custom.SnailEntityClass;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class JDEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, SnailPals.MOD_ID);

    public static final RegistryObject<EntityType<SnailEntityClass>> SNAIL =
            ENTITY_TYPES.register("snail",
                    () -> EntityType.Builder.of(SnailEntityClass::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f)
                            .build(new ResourceLocation(SnailPals.MOD_ID, "snail").toString()));


    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}