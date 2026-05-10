package dev.turtywurty.tutorialmod.services.types.client;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.MenuAccess;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import org.apache.commons.lang3.function.TriFunction;

import java.util.function.Supplier;

public interface IClientRegistryHelper {
    <T extends Entity> void registerEntityRenderer(EntityType<T> entityType, EntityRendererProvider<T> provider);

    void registerModelLayer(ModelLayerLocation location, Supplier<LayerDefinition> supplier);

    void applyEntityRendererRegistrations(EntityRendererRegistrar registrar);

    void applyModelLayerRegistrations(ModelLayerRegistrar registrar);

    <T extends AbstractContainerMenu, U extends Screen & MenuAccess<T>> void registerMenuScreen(MenuType<T> menuType, TriFunction<T, Inventory, Component, U> screenFactory);

    default void applyMenuScreenRegistrations(MenuScreenRegistrar registrar) {
    }

    interface EntityRendererRegistrar {
        <T extends Entity> void register(EntityType<T> entityType, EntityRendererProvider<T> provider);
    }

    interface ModelLayerRegistrar {
        void register(ModelLayerLocation location, Supplier<LayerDefinition> supplier);
    }

    interface MenuScreenRegistrar {
        <T extends AbstractContainerMenu, U extends Screen & MenuAccess<T>> void register(MenuType<T> menuType, TriFunction<T, Inventory, Component, U> screenFactory);
    }
}
