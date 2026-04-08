package dev.turtywurty.tutorialmod.init.client;

import dev.turtywurty.tutorialmod.client.model.ExampleEntityModel;
import dev.turtywurty.tutorialmod.entities.ExampleEntity;
import dev.turtywurty.tutorialmod.init.ModEntityTypes;
import dev.turtywurty.tutorialmod.services.Services;
import dev.turtywurty.tutorialmod.services.ServicesClient;

public final class ModModelLayers {
    private ModModelLayers() {
    }

    public static void load() {
        ServicesClient.CLIENT_REGISTRY.registerModelLayer(ExampleEntityModel.LAYER_LOCATION, ExampleEntityModel::createBodyLayer);
    }
}
