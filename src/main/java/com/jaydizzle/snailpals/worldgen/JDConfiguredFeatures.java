package com.jaydizzle.snailpals.worldgen;

import com.jaydizzle.snailpals.SnailPals;
import com.jaydizzle.snailpals.block.JDBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;

import java.util.List;

public class JDConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> SNAIL_SHELL_KEY = registerKey("snail_shell");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest grassReplaceables = new BlockMatchTest(Blocks.PUMPKIN);

        List<OreConfiguration.TargetBlockState> snailShell = List.of(
                OreConfiguration.target(grassReplaceables, JDBlocks.SNAIL_SHELL.get().defaultBlockState()));

        register(context, SNAIL_SHELL_KEY, Feature.ORE, new OreConfiguration(snailShell, 2));  //vein size

    }


    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(SnailPals.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}


