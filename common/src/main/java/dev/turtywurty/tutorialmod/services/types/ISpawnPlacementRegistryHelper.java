package dev.turtywurty.tutorialmod.services.types;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.SpawnPlacementType;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.levelgen.Heightmap;

import java.util.function.Supplier;

public interface ISpawnPlacementRegistryHelper {
    <T extends Mob> void registerSpawnPlacement(Supplier<EntityType<T>> entityTypeSupplier,
                                                SpawnPlacementType spawnPlacementType,
                                                Heightmap.Types heightmap,
                                                SpawnPlacements.SpawnPredicate<T> predicate);

    void applySpawnPlacements(SpawnPlacementsRegistrar registrar);

    interface SpawnPlacementsRegistrar {
        <T extends Mob> void register(EntityType<T> entityType,
                                      SpawnPlacementType spawnPlacementType,
                                      Heightmap.Types heightmap,
                                      SpawnPlacements.SpawnPredicate<T> predicate);
    }
}
