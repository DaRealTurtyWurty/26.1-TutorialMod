package dev.turtywurty.tutorialmod.datagen;

import dev.turtywurty.tutorialmod.init.ModBlocks;
import dev.turtywurty.tutorialmod.init.ModItems;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public final class TutorialModLanguageProvider {
    private TutorialModLanguageProvider() {
    }

    public static void generateTranslations(TranslationOutput output) {
        output.add(ModItems.EXAMPLE_ITEM.get(), "Example Item");
        output.add(ModItems.EXAMPLE_ITEM2.get(), "Example Item 2");
        output.add(ModBlocks.EXAMPLE_BLOCK.block().get(), "Example Block");
        output.add(ModBlocks.EXAMPLE_BLOCK.item().get(), "Example Block");
    }

    public interface TranslationOutput {
        void add(Block block, String value);

        void add(Item item, String value);

        void add(Component component, String value);
    }
}
