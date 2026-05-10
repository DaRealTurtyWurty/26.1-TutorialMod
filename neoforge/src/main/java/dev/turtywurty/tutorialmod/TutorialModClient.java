package dev.turtywurty.tutorialmod;

import dev.turtywurty.tutorialmod.services.ServicesClient;
import dev.turtywurty.tutorialmod.services.types.client.IClientRegistryHelper;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.MenuAccess;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import org.apache.commons.lang3.function.TriFunction;

@EventBusSubscriber(modid = Constants.MOD_ID, value = Dist.CLIENT)
public final class TutorialModClient {
    private TutorialModClient() {
    }

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        TutorialModClientCommon.init();
        ServicesClient.CLIENT_REGISTRY.applyEntityRendererRegistrations(event::registerEntityRenderer);
    }

    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        TutorialModClientCommon.init();
        ServicesClient.CLIENT_REGISTRY.applyModelLayerRegistrations(event::registerLayerDefinition);
    }

    @SubscribeEvent
    public static void registerScreens(RegisterMenuScreensEvent event) {
        TutorialModClientCommon.init();
        ServicesClient.CLIENT_REGISTRY.applyMenuScreenRegistrations(new IClientRegistryHelper.MenuScreenRegistrar() {
            @Override
            public <T extends AbstractContainerMenu, U extends Screen & MenuAccess<T>> void register(MenuType<T> menuType, TriFunction<T, Inventory, Component, U> screenFactory) {
                event.register(menuType, screenFactory::apply);
            }
        });
    }
}
