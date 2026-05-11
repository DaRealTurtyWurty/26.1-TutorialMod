package dev.turtywurty.tutorialmod.services;

import dev.turtywurty.tutorialmod.services.types.ISpawnPlacementRegistryHelper;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.SpawnPlacementType;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.levelgen.Heightmap;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class NeoForgeSpawnPlacementRegistryHelper implements ISpawnPlacementRegistryHelper {
    private final List<SpawnPlacementEntry<?>> spawnPlacements = new ArrayList<>();

    @Override
    public <T extends Mob> void registerSpawnPlacement(Supplier<EntityType<T>> entityTypeSupplier, SpawnPlacementType spawnPlacementType, Heightmap.Types heightmap, SpawnPlacements.SpawnPredicate<T> predicate) {
        this.spawnPlacements.add(new SpawnPlacementEntry<>(entityTypeSupplier, spawnPlacementType, heightmap, predicate));
    }

    @Override
    public void applySpawnPlacements(SpawnPlacementsRegistrar registrar) {
        for (SpawnPlacementEntry<?> spawnPlacement : this.spawnPlacements) {
            spawnPlacement.register(registrar);
        }
    }

    private record SpawnPlacementEntry<T extends Mob>(Supplier<EntityType<T>> entityTypeSupplier,
                                                      SpawnPlacementType spawnPlacementType,
                                                      Heightmap.Types heightmap,
                                                      SpawnPlacements.SpawnPredicate<T> spawnPredicate) {
        private void register(SpawnPlacementsRegistrar registrar) {
            registrar.register(this.entityTypeSupplier.get(), this.spawnPlacementType, this.heightmap, this.spawnPredicate);
        }
    }
}
