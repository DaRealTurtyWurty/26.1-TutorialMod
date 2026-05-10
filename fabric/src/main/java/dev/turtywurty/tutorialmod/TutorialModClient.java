package dev.turtywurty.tutorialmod;

import dev.turtywurty.tutorialmod.services.ServicesClient;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.ModelLayerRegistry;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

public class TutorialModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        TutorialModClientCommon.init();
        ServicesClient.CLIENT_REGISTRY.applyModelLayerRegistrations((location, supplier) -> ModelLayerRegistry.registerModelLayer(location, supplier::get));
        ServicesClient.CLIENT_REGISTRY.applyEntityRendererRegistrations(EntityRenderers::register);
    }
}
