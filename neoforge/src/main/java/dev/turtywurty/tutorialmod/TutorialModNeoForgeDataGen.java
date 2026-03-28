package dev.turtywurty.tutorialmod;

import dev.turtywurty.tutorialmod.datagen.TutorialModNeoForgeBlockTagProvider;
import dev.turtywurty.tutorialmod.datagen.TutorialModNeoForgeLanguageProvider;
import dev.turtywurty.tutorialmod.datagen.TutorialModNeoForgeLootTableProvider;
import dev.turtywurty.tutorialmod.datagen.TutorialModNeoForgeModelProvider;
import net.neoforged.neoforge.data.event.GatherDataEvent;

public final class TutorialModNeoForgeDataGen {
    private TutorialModNeoForgeDataGen() {
    }

    public static void onGatherClientData(GatherDataEvent.Client event) {
        event.createProvider(TutorialModNeoForgeModelProvider::new);
        event.createProvider(TutorialModNeoForgeLanguageProvider::new);
    }

    public static void onGatherServerData(GatherDataEvent.Server event) {
        event.createProvider(TutorialModNeoForgeLootTableProvider::new);
        event.createProvider(TutorialModNeoForgeBlockTagProvider::new);
    }
}
