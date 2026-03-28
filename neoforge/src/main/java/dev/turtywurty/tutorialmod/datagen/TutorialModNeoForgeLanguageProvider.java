package dev.turtywurty.tutorialmod.datagen;

import dev.turtywurty.tutorialmod.Constants;
import net.minecraft.data.PackOutput;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.contents.TranslatableContents;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class TutorialModNeoForgeLanguageProvider extends LanguageProvider {
    public TutorialModNeoForgeLanguageProvider(PackOutput packOutput) {
        super(packOutput, Constants.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        TutorialModLanguageProvider.generateTranslations(new NeoForgeTranslationOutput(this));
    }

    public record NeoForgeTranslationOutput(LanguageProvider provider)
            implements TutorialModLanguageProvider.TranslationOutput {
        @Override
        public void add(Block block, String value) {
            this.provider.add(block, value);
        }

        @Override
        public void add(Item item, String value) {
            this.provider.add(item, value);
        }

        @Override
        public void add(Component component, String value) {
            if (component.getContents() instanceof TranslatableContents translatableContents) {
                this.provider.add(translatableContents.getKey(), value);
            }
        }
    }
}
