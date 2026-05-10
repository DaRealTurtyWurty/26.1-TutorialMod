package dev.turtywurty.tutorialmod.services;

import dev.turtywurty.tutorialmod.entities.ExampleEntity;
import dev.turtywurty.tutorialmod.menus.ExampleEntityMenu;
import dev.turtywurty.tutorialmod.network.IntegerPayload;
import dev.turtywurty.tutorialmod.services.types.IMenuOpener;
import net.fabricmc.fabric.api.menu.v1.ExtendedMenuProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import org.jspecify.annotations.NonNull;

import java.util.OptionalInt;

public class FabricMenuOpener implements IMenuOpener {
    @Override
    public OptionalInt createMenuProviderForExampleEntity(Player player, ExampleEntity entity, int entityId) {
        return player.openMenu(new ExtendedMenuProvider<>() {
            @Override
            public @NonNull AbstractContainerMenu createMenu(int containerId, @NonNull Inventory inventory, @NonNull Player player) {
                return new ExampleEntityMenu(containerId, inventory, entity);
            }

            @Override
            public @NonNull Component getDisplayName() {
                return entity.getDisplayName();
            }

            @Override
            public @NonNull Object getScreenOpeningData(@NonNull ServerPlayer player) {
                return new IntegerPayload(entityId);
            }
        });
    }
}
