package dev.turtywurty.tutorialmod.worldgen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.level.levelgen.GenerationStep;

public final class TutorialModFabricWorldgen {
    private TutorialModFabricWorldgen() {
    }

    public static void load() {
        BiomeModifications.addFeature(
                BiomeSelectors.foundInOverworld(),
                GenerationStep.Decoration.UNDERGROUND_ORES,
                TutorialModWorldgen.EXAMPLE_OVERWORLD_ORE_PLACED
        );
        BiomeModifications.addFeature(
                BiomeSelectors.foundInTheNether(),
                GenerationStep.Decoration.UNDERGROUND_ORES,
                TutorialModWorldgen.EXAMPLE_NETHER_ORE_PLACED
        );
        BiomeModifications.addFeature(
                BiomeSelectors.foundInTheEnd(),
                GenerationStep.Decoration.UNDERGROUND_ORES,
                TutorialModWorldgen.EXAMPLE_END_ORE_PLACED
        );
    }
}
