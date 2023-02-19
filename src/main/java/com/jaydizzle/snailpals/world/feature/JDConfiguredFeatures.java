package com.jaydizzle.snailpals.world.feature;

import com.google.common.base.Suppliers;
import com.jaydizzle.snailpals.SnailPals;
import com.jaydizzle.snailpals.block.JDBlocks;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.function.Supplier;

public class JDConfiguredFeatures {
    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES =
            DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, SnailPals.MOD_ID);

    public static final Supplier<List<OreConfiguration.TargetBlockState>> SNAIL_SHELLS = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(FillerBlockType.GRASS, JDBlocks.SNAIL_SHELL.get().defaultBlockState())));
    public static final RegistryObject<ConfiguredFeature<?, ?>> SNAIL_SHELL = CONFIGURED_FEATURES.register("snail_shell",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(SNAIL_SHELLS.get(), 1))); //vein size

    public static final class FillerBlockType {
        public static final RuleTest GRASS = new BlockMatchTest(Blocks.GRASS);
    }
        public static void register(IEventBus eventBus) {
            CONFIGURED_FEATURES.register(eventBus);
        }
}

