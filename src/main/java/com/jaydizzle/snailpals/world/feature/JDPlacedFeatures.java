package com.jaydizzle.snailpals.world.feature;

import com.jaydizzle.snailpals.SnailPals;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class JDPlacedFeatures {
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES =
            DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, SnailPals.MOD_ID);

    public static final RegistryObject<PlacedFeature> SNAIL_SHELL_PLACED = PLACED_FEATURES.register("snail_shell_placed",
            () -> new PlacedFeature(JDConfiguredFeatures.SNAIL_SHELL.getHolder().get(),
                    commonOrePlacement(48, //veins per chunk
                            HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(30), VerticalAnchor.aboveBottom(150))))); //spawn range

    public static final RegistryObject<PlacedFeature> GARY_SHELL_PLACED = PLACED_FEATURES.register("gary_shell_placed",
            () -> new PlacedFeature(JDConfiguredFeatures.GARY_SHELL.getHolder().get(),
                    commonOrePlacement(10, //veins per chunk
                            HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(30), VerticalAnchor.aboveBottom(150))))); //spawn range

    public static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier p_195348_) {
        return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome()); }
    public static List<PlacementModifier> commonOrePlacement(int p_195344_, PlacementModifier p_195345_) {
        return orePlacement(CountPlacement.of(p_195344_), p_195345_); }
    public static List<PlacementModifier> rareOrePlacement(int p_195350_, PlacementModifier p_195351_) {
        return orePlacement(RarityFilter.onAverageOnceEvery(p_195350_), p_195351_); }
    public static void register(IEventBus eventBus) {
        PLACED_FEATURES.register(eventBus);
    }
}

