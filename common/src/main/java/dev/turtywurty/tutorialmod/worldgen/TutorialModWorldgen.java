package dev.turtywurty.tutorialmod.worldgen;

import dev.turtywurty.tutorialmod.Constants;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public final class TutorialModWorldgen {
    public static final ResourceKey<ConfiguredFeature<?, ?>> EXAMPLE_OVERWORLD_ORE = configuredFeatureKey("example_overworld_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> EXAMPLE_NETHER_ORE = configuredFeatureKey("example_nether_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> EXAMPLE_END_ORE = configuredFeatureKey("example_end_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> EXAMPLE_FLOWER = configuredFeatureKey("example_flower");

    public static final ResourceKey<PlacedFeature> EXAMPLE_OVERWORLD_ORE_PLACED = placedFeatureKey("example_overworld_ore");
    public static final ResourceKey<PlacedFeature> EXAMPLE_NETHER_ORE_PLACED = placedFeatureKey("example_nether_ore");
    public static final ResourceKey<PlacedFeature> EXAMPLE_END_ORE_PLACED = placedFeatureKey("example_end_ore");
    public static final ResourceKey<PlacedFeature> EXAMPLE_FLOWER_PLACED = placedFeatureKey("example_flower");

    private TutorialModWorldgen() {
    }

    public static void load() {
    }

    private static ResourceKey<ConfiguredFeature<?, ?>> configuredFeatureKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, Constants.id(name));
    }

    private static ResourceKey<PlacedFeature> placedFeatureKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, Constants.id(name));
    }
}
