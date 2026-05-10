package dev.turtywurty.tutorialmod.datagen.bootstrap;

import dev.turtywurty.tutorialmod.init.ModBlocks;
import dev.turtywurty.tutorialmod.worldgen.TutorialModWorldgen;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public final class TutorialModWorldgenBootstrapper {
    private TutorialModWorldgenBootstrapper() {
    }

    public static void bootstrapConfiguredFeatures(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        context.register(TutorialModWorldgen.EXAMPLE_OVERWORLD_ORE, new ConfiguredFeature<>(Feature.SCATTERED_ORE,
                new OreConfiguration(List.of(
                        OreConfiguration.target(new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), ModBlocks.EXAMPLE_OVERWORLD_ORE.block().get().defaultBlockState()),
                        OreConfiguration.target(new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), ModBlocks.EXAMPLE_DEEPSLATE_ORE.block().get().defaultBlockState())
                ),
                        9,
                        0.0F)
        ));
        context.register(TutorialModWorldgen.EXAMPLE_NETHER_ORE, new ConfiguredFeature<>(Feature.ORE,
                new OreConfiguration(List.of(
                        OreConfiguration.target(new BlockMatchTest(Blocks.NETHERRACK), ModBlocks.EXAMPLE_NETHER_ORE.block().get().defaultBlockState())),
                        10,
                        0.0F)));
        context.register(TutorialModWorldgen.EXAMPLE_END_ORE, new ConfiguredFeature<>(Feature.ORE,
                new OreConfiguration(List.of(
                        OreConfiguration.target(new BlockMatchTest(Blocks.END_STONE), ModBlocks.EXAMPLE_END_ORE.block().get().defaultBlockState())),
                        7,
                        0.0F)));
    }

    public static void bootstrapPlacedFeatures(BootstrapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        context.register(TutorialModWorldgen.EXAMPLE_OVERWORLD_ORE_PLACED, new PlacedFeature(
                configuredFeatures.getOrThrow(TutorialModWorldgen.EXAMPLE_OVERWORLD_ORE),
                List.of(
                        CountPlacement.of(ConstantInt.of(18)),
                        InSquarePlacement.spread(),
                        HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(10), VerticalAnchor.belowTop(100)),
                        BiomeFilter.biome()
                )
        ));
        context.register(TutorialModWorldgen.EXAMPLE_NETHER_ORE_PLACED, new PlacedFeature(
                configuredFeatures.getOrThrow(TutorialModWorldgen.EXAMPLE_NETHER_ORE),
                List.of(
                        CountPlacement.of(ConstantInt.of(14)),
                        InSquarePlacement.spread(),
                        HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.top()),
                        BiomeFilter.biome())));
        context.register(TutorialModWorldgen.EXAMPLE_END_ORE_PLACED, new PlacedFeature(
                configuredFeatures.getOrThrow(TutorialModWorldgen.EXAMPLE_END_ORE),
                List.of(
                        CountPlacement.of(ConstantInt.of(9)),
                        InSquarePlacement.spread(),
                        HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(20), VerticalAnchor.absolute(80)),
                        BiomeFilter.biome())));
    }
}
