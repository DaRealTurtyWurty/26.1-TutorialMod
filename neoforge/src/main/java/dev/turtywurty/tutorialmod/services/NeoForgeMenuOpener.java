package dev.turtywurty.tutorialmod.services;

import dev.turtywurty.tutorialmod.entities.ExampleEntity;
import dev.turtywurty.tutorialmod.menus.ExampleEntityMenu;
import dev.turtywurty.tutorialmod.services.types.IMenuOpener;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;

import java.util.OptionalInt;

public class NeoForgeMenuOpener implements IMenuOpener {
    @Override
    public OptionalInt createMenuProviderForExampleEntity(Player player, ExampleEntity entity, int entityId) {
        return player.openMenu(new SimpleMenuProvider(
                (containerId, inventory, _) -> new ExampleEntityMenu(containerId, inventory, entity),
                entity.getDisplayName()
        ), registryFriendlyByteBuf -> registryFriendlyByteBuf.writeInt(entityId));
    }
}
