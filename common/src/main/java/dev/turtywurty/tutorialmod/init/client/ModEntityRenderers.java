package dev.turtywurty.tutorialmod.init.client;

import dev.turtywurty.tutorialmod.client.renderer.ExampleEntityRenderer;
import dev.turtywurty.tutorialmod.init.ModEntityTypes;
import dev.turtywurty.tutorialmod.services.ServicesClient;

public final class ModEntityRenderers {
    private ModEntityRenderers() {
    }

    public static void load() {
        ServicesClient.CLIENT_REGISTRY.registerEntityRenderer(ModEntityTypes.EXAMPLE_ENTITY.get(), ExampleEntityRenderer::new);
    }
}
