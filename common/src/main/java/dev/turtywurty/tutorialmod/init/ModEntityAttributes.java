package dev.turtywurty.tutorialmod.init;

import dev.turtywurty.tutorialmod.entities.ExampleEntity;
import dev.turtywurty.tutorialmod.services.Services;

public final class ModEntityAttributes {
    private ModEntityAttributes() {
    }

    public static void load() {
        Services.ATTRIBUTES.registerEntityAttributes(ModEntityTypes.EXAMPLE_ENTITY, ExampleEntity::createAttributes);
    }
}
