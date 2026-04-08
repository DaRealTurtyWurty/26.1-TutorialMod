package dev.turtywurty.tutorialmod;

import dev.turtywurty.tutorialmod.datagen.TutorialModBlockTagProvider;
import dev.turtywurty.tutorialmod.datagen.TutorialModEnglishLanguageProvider;
import dev.turtywurty.tutorialmod.datagen.TutorialModLootTableProvider;
import dev.turtywurty.tutorialmod.datagen.TutorialModModelProvider;
import net.neoforged.neoforge.data.event.GatherDataEvent;

public final class TutorialModDatagen {
    private TutorialModDatagen() {
    }

    public static void onGatherClientData(GatherDataEvent.Client event) {
        event.createProvider(TutorialModModelProvider::new);
        event.createProvider(TutorialModEnglishLanguageProvider::new);
        event.createProvider(TutorialModBlockTagProvider::new);
        event.createProvider(TutorialModLootTableProvider::new);
    }
}
