package dev.turtywurty.tutorialmod.init.client;

import dev.turtywurty.tutorialmod.client.screen.ExampleEntityScreen;
import dev.turtywurty.tutorialmod.init.ModMenuTypes;
import dev.turtywurty.tutorialmod.services.ServicesClient;

public final class ModMenuScreens {
    private ModMenuScreens() {
    }

    public static void load() {
        ServicesClient.CLIENT_REGISTRY.registerMenuScreen(ModMenuTypes.EXAMPLE_MENU_TYPE.get(), ExampleEntityScreen::new);
    }
}
