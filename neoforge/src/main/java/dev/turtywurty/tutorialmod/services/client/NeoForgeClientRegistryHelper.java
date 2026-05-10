package dev.turtywurty.tutorialmod.services.client;

import dev.turtywurty.tutorialmod.services.types.client.IClientRegistryHelper;
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

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public final class NeoForgeClientRegistryHelper implements IClientRegistryHelper {
    private final List<EntityRendererEntry<?>> entityRenderers = new ArrayList<>();
    private final List<ModelLayerEntry> modelLayers = new ArrayList<>();
    private final List<MenuScreenEntry<?, ?>> menuScreens = new ArrayList<>();

    @Override
    public <T extends Entity> void registerEntityRenderer(EntityType<T> entityType, EntityRendererProvider<T> provider) {
        this.entityRenderers.add(new EntityRendererEntry<>(entityType, provider));
    }

    @Override
    public void registerModelLayer(ModelLayerLocation location, Supplier<LayerDefinition> supplier) {
        this.modelLayers.add(new ModelLayerEntry(location, supplier));
    }

    @Override
    public void applyEntityRendererRegistrations(EntityRendererRegistrar registrar) {
        for (EntityRendererEntry<?> entry : this.entityRenderers) {
            entry.register(registrar);
        }
    }

    @Override
    public void applyModelLayerRegistrations(ModelLayerRegistrar registrar) {
        for (ModelLayerEntry entry : this.modelLayers) {
            entry.register(registrar);
        }
    }

    @Override
    public <T extends AbstractContainerMenu, U extends Screen & MenuAccess<T>> void registerMenuScreen(MenuType<T> menuType, TriFunction<T, Inventory, Component, U> screenFactory) {
        this.menuScreens.add(new MenuScreenEntry<>(menuType, screenFactory));
    }

    @Override
    public void applyMenuScreenRegistrations(MenuScreenRegistrar registrar) {
        for (MenuScreenEntry<?, ?> entry : this.menuScreens) {
            entry.register(registrar);
        }
    }

    private record EntityRendererEntry<T extends Entity>(EntityType<T> entityType, EntityRendererProvider<T> provider) {
        private void register(EntityRendererRegistrar registrar) {
            registrar.register(this.entityType, this.provider);
        }
    }

    private record ModelLayerEntry(ModelLayerLocation location, Supplier<LayerDefinition> supplier) {
        private void register(ModelLayerRegistrar registrar) {
            registrar.register(this.location, this.supplier);
        }
    }

    private record MenuScreenEntry<T extends AbstractContainerMenu, U extends Screen & MenuAccess<T>>(
            MenuType<T> menuType, TriFunction<T, Inventory, Component, U> screenFactory) {
        private void register(MenuScreenRegistrar registrar) {
            registrar.register(this.menuType, this.screenFactory);
        }
    }
}
