package dev.turtywurty.tutorialmod.init;

import dev.turtywurty.tutorialmod.entities.ExampleEntity;
import dev.turtywurty.tutorialmod.services.Services;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.level.levelgen.Heightmap;

public final class ModEntitySpawns {
    public static final SpawnSettings EXAMPLE_ENTITY = new SpawnSettings(12, 1, 3);

    private ModEntitySpawns() {
    }

    public static void load() {
        Services.SPAWN_PLACEMENTS.registerSpawnPlacement(ModEntityTypes.EXAMPLE_ENTITY, SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, ExampleEntity::canSpawn);
    }

    public record SpawnSettings(int weight, int minGroupSize, int maxGroupSize) {
    }
}
