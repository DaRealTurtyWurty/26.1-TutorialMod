package dev.turtywurty.tutorialmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.contents.TranslatableContents;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import org.jspecify.annotations.NonNull;

import java.util.concurrent.CompletableFuture;

public class TutorialModFabricLanguageProvider extends FabricLanguageProvider {
    public TutorialModFabricLanguageProvider(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(packOutput, "en_us", registryLookup);
    }

    @Override
    public void generateTranslations(HolderLookup.@NonNull Provider registryLookup, @NonNull TranslationBuilder translationBuilder) {
        TutorialModLanguageProvider.generateTranslations(new FabricTranslationOutput(registryLookup, translationBuilder));
    }

    public record FabricTranslationOutput(HolderLookup.@NonNull Provider registryLookup,
                                          @NonNull TranslationBuilder translationBuilder)
            implements TutorialModLanguageProvider.TranslationOutput {
        @Override
        public void add(Block block, String value) {
            this.translationBuilder.add(block, value);
        }

        @Override
        public void add(Item item, String value) {
            this.translationBuilder.add(item, value);
        }

        @Override
        public void add(Component component, String value) {
            if (component.getContents() instanceof TranslatableContents translatableContents) {
                this.translationBuilder.add(translatableContents.getKey(), value);
            }
        }
    }
}
