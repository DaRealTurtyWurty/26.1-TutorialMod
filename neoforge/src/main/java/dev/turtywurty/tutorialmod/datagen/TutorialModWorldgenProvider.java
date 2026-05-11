package dev.turtywurty.tutorialmod.datagen;

import dev.turtywurty.tutorialmod.Constants;
import dev.turtywurty.tutorialmod.datagen.bootstrap.TutorialModWorldgenBootstrapper;
import dev.turtywurty.tutorialmod.init.ModEntitySpawns;
import dev.turtywurty.tutorialmod.init.ModEntityTypes;
import dev.turtywurty.tutorialmod.worldgen.TutorialModWorldgen;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderSet;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BiomeTags;
import net.minecraft.util.random.Weighted;
import net.minecraft.util.random.WeightedList;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public final class TutorialModWorldgenProvider extends DatapackBuiltinEntriesProvider {
    private static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, TutorialModWorldgenBootstrapper::bootstrapConfiguredFeatures)
            .add(Registries.PLACED_FEATURE, TutorialModWorldgenBootstrapper::bootstrapPlacedFeatures)
            .add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, TutorialModWorldgenProvider::bootstrapBiomeModifiers);

    private static final ResourceKey<BiomeModifier> EXAMPLE_OVERWORLD_ORE_MODIFIER = biomeModifierKey("example_overworld_ore");
    private static final ResourceKey<BiomeModifier> EXAMPLE_NETHER_ORE_MODIFIER = biomeModifierKey("example_nether_ore");
    private static final ResourceKey<BiomeModifier> EXAMPLE_END_ORE_MODIFIER = biomeModifierKey("example_end_ore");
    private static final ResourceKey<BiomeModifier> EXAMPLE_ENTITY_SPAWNS = biomeModifierKey("example_entity_spawns");

    public TutorialModWorldgenProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(Constants.MOD_ID));
    }

    private static void bootstrapBiomeModifiers(BootstrapContext<BiomeModifier> context) {
        HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);
        HolderGetter<PlacedFeature> placedFeatures = context.lookup(Registries.PLACED_FEATURE);

        context.register(EXAMPLE_OVERWORLD_ORE_MODIFIER, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(TutorialModWorldgen.EXAMPLE_OVERWORLD_ORE_PLACED)),
                GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(EXAMPLE_NETHER_ORE_MODIFIER, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_NETHER),
                HolderSet.direct(placedFeatures.getOrThrow(TutorialModWorldgen.EXAMPLE_NETHER_ORE_PLACED)),
                GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(EXAMPLE_END_ORE_MODIFIER, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_END),
                HolderSet.direct(placedFeatures.getOrThrow(TutorialModWorldgen.EXAMPLE_END_ORE_PLACED)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(EXAMPLE_ENTITY_SPAWNS, new BiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(BiomeTags.HAS_VILLAGE_PLAINS),
                WeightedList.of(List.of(
                        new Weighted<>(
                                new MobSpawnSettings.SpawnerData(
                                        ModEntityTypes.EXAMPLE_ENTITY.get(),
                                        ModEntitySpawns.EXAMPLE_ENTITY.minGroupSize(),
                                        ModEntitySpawns.EXAMPLE_ENTITY.maxGroupSize()
                                ),
                                ModEntitySpawns.EXAMPLE_ENTITY.weight()
                        )
                ))
        ));
    }

    private static ResourceKey<BiomeModifier> biomeModifierKey(String name) {
        return ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, Constants.id(name));
    }
}
