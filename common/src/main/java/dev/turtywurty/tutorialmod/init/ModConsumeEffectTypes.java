package dev.turtywurty.tutorialmod.init;

import dev.turtywurty.tutorialmod.consume_effects.SpawnEntityConsumeEffect;
import dev.turtywurty.tutorialmod.services.Services;
import dev.turtywurty.tutorialmod.services.util.RegistryHandle;
import net.minecraft.world.item.consume_effects.ConsumeEffect;

public final class ModConsumeEffectTypes {
    private ModConsumeEffectTypes() {
    }

    public static final RegistryHandle<ConsumeEffect.Type<SpawnEntityConsumeEffect<?>>> SPAWN_ENTITY =
            Services.REGISTRY.registerConsumeEffectType(
                    "spawn_entity",
                    SpawnEntityConsumeEffect.MAP_CODEC,
                    SpawnEntityConsumeEffect.STREAM_CODEC
            );

    public static void load() {
    }
}
