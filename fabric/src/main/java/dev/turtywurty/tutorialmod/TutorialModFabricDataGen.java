package dev.turtywurty.tutorialmod;

import dev.turtywurty.tutorialmod.datagen.TutorialModFabricBlockLootTableProvider;
import dev.turtywurty.tutorialmod.datagen.TutorialModFabricBlockTagProvider;
import dev.turtywurty.tutorialmod.datagen.TutorialModFabricLanguageProvider;
import dev.turtywurty.tutorialmod.datagen.TutorialModFabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public final class TutorialModFabricDataGen implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider(TutorialModFabricModelProvider::new);
        pack.addProvider(TutorialModFabricLanguageProvider::new);
        pack.addProvider(TutorialModFabricBlockLootTableProvider::new);
        pack.addProvider(TutorialModFabricBlockTagProvider::new);
    }
}
