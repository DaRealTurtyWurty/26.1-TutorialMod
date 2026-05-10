package dev.turtywurty.tutorialmod;

import dev.turtywurty.tutorialmod.init.client.ModEntityRenderers;
import dev.turtywurty.tutorialmod.init.client.ModMenuScreens;
import dev.turtywurty.tutorialmod.init.client.ModModelLayers;

public final class TutorialModClientCommon {
    private static boolean initialized;

    private TutorialModClientCommon() {
    }

    public static void init() {
        if (initialized)
            return;

        initialized = true;

        ModModelLayers.load();
        ModEntityRenderers.load();
        ModMenuScreens.load();
    }
}
