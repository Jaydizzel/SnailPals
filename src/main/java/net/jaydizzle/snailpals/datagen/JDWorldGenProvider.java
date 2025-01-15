package net.jaydizzle.snailpals.datagen;

import net.jaydizzle.snailpals.SnailPals;
import net.jaydizzle.snailpals.worldgen.JDBiomeModifiers;
import net.jaydizzle.snailpals.worldgen.JDConfiguredFeatures;
import net.jaydizzle.snailpals.worldgen.JDPlacedFeatures;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class JDWorldGenProvider extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, JDConfiguredFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, JDPlacedFeatures::bootstrap)
            .add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, JDBiomeModifiers::bootstrap);
    public JDWorldGenProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(SnailPals.MOD_ID));
    }
}

