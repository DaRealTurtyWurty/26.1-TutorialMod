package dev.turtywurty.tutorialmod.services.types;

import dev.turtywurty.tutorialmod.entities.ExampleEntity;
import net.minecraft.world.entity.player.Player;

import java.util.OptionalInt;

public interface IMenuOpener {
    OptionalInt createMenuProviderForExampleEntity(Player player, ExampleEntity entity, int entityId);
}
