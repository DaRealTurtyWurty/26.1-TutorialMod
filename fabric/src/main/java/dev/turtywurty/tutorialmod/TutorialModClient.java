package dev.turtywurty.tutorialmod;

import dev.turtywurty.tutorialmod.services.ServicesClient;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.ModelLayerRegistry;
import net.minecraft.client.renderer.entity.EntityRenderers;

public class TutorialModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        TutorialModClientCommon.init();
        ServicesClient.CLIENT_REGISTRY.applyModelLayerRegistrations((location, supplier) -> ModelLayerRegistry.registerModelLayer(location, supplier::get));
        ServicesClient.CLIENT_REGISTRY.applyEntityRendererRegistrations(EntityRenderers::register);
    }
}
