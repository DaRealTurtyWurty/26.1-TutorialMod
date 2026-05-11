package dev.turtywurty.tutorialmod;

import dev.turtywurty.tutorialmod.services.Services;
import dev.turtywurty.tutorialmod.worldgen.TutorialModFabricWorldgen;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.world.entity.SpawnPlacements;

public class TutorialMod implements ModInitializer {
    @Override
    public void onInitialize() {
        // This method is invoked by the Fabric mod loader when it is ready
        // to load your mod. You can access Fabric and Common code in this
        // project.

        // Use Fabric to bootstrap the Common mod.
        Constants.LOG.info("Hello Fabric world!");
        CommonClass.init();
        Services.SPAWN_PLACEMENTS.applySpawnPlacements(SpawnPlacements::register);
        TutorialModFabricWorldgen.load();
        Services.ATTRIBUTES.applyEntityAttributeRegistrations(FabricDefaultAttributeRegistry::register);
    }
}
