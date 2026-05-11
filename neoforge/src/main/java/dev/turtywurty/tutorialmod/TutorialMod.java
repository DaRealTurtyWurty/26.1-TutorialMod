package dev.turtywurty.tutorialmod;

import dev.turtywurty.tutorialmod.services.NeoForgeRegistryHelper;
import dev.turtywurty.tutorialmod.services.Services;
import dev.turtywurty.tutorialmod.services.types.IAttributeRegistryHelper;
import dev.turtywurty.tutorialmod.services.types.ISpawnPlacementRegistryHelper;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.level.levelgen.Heightmap;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;

@Mod(Constants.MOD_ID)
public class TutorialMod {
    public TutorialMod(IEventBus eventBus) {
        // This method is invoked by the NeoForge mod loader when it is ready
        // to load your mod. You can access NeoForge and Common code in this
        // project.

        // Use NeoForge to bootstrap the Common mod.
        Constants.LOG.info("Hello NeoForge world!");
        CommonClass.init();
        eventBus.addListener(TutorialMod::onEntityAttributeCreation);
        eventBus.addListener(TutorialMod::onRegisterSpawnPlacements);
        eventBus.addListener(TutorialModDatagen::onGatherClientData);
        NeoForgeRegistryHelper.register(eventBus);
    }

    private static void onEntityAttributeCreation(EntityAttributeCreationEvent event) {
        Services.ATTRIBUTES.applyEntityAttributeRegistrations(new IAttributeRegistryHelper.EntityAttributeRegistrar() {
            @Override
            public <T extends LivingEntity> void register(EntityType<T> entityType, AttributeSupplier.Builder builder) {
                event.put(entityType, builder.build());
            }
        });
    }

    private static void onRegisterSpawnPlacements(RegisterSpawnPlacementsEvent event) {
        Services.SPAWN_PLACEMENTS.applySpawnPlacements(new ISpawnPlacementRegistryHelper.SpawnPlacementsRegistrar() {
            @Override
            public <T extends Mob> void register(EntityType<T> entityType, SpawnPlacementType spawnPlacementType, Heightmap.Types heightmap, SpawnPlacements.SpawnPredicate<T> predicate) {
                event.register(entityType, spawnPlacementType, heightmap, predicate, RegisterSpawnPlacementsEvent.Operation.REPLACE);
            }
        });
    }
}