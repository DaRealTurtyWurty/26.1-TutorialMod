package dev.turtywurty.tutorialmod.init;

import dev.turtywurty.tutorialmod.entities.ExampleEntity;
import dev.turtywurty.tutorialmod.services.Services;
import dev.turtywurty.tutorialmod.services.util.RegistryHandle;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

public class ModEntityTypes {
    public static void load() {
    }

    public static final RegistryHandle<EntityType<ExampleEntity>> EXAMPLE_ENTITY =
            Services.REGISTRY.registerEntityType("example_entity",
                    EntityType.Builder.of(ExampleEntity::new, MobCategory.CREATURE)
                            .sized(1f, 1.5f)
                            .eyeHeight(1.0625f));
}
