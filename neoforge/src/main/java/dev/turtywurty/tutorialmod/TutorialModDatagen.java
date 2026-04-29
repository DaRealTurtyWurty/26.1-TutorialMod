package dev.turtywurty.tutorialmod;

import dev.turtywurty.tutorialmod.datagen.*;
import net.neoforged.neoforge.data.event.GatherDataEvent;

public final class TutorialModDatagen {
    private TutorialModDatagen() {
    }

    public static void onGatherClientData(GatherDataEvent.Client event) {
        event.createProvider(TutorialModModelProvider::new);
        event.createProvider(TutorialModEnglishLanguageProvider::new);
        event.createProvider(TutorialModBlockTagProvider::new);
        event.createProvider(TutorialModItemTagProvider::new);
        event.createProvider(TutorialModLootTableProvider::new);
        event.createProvider(TutorialModEquipmentAssetProvider::new);
        event.createProvider(TutorialModRecipeProvider.Runner::new);
    }
}
