package dev.turtywurty.tutorialmod.datagen;

import dev.turtywurty.tutorialmod.Constants;
import dev.turtywurty.tutorialmod.init.ModBlocks;
import dev.turtywurty.tutorialmod.init.ModEntityTypes;
import dev.turtywurty.tutorialmod.init.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.contents.TranslatableContents;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class TutorialModEnglishLanguageProvider extends LanguageProvider {
    public TutorialModEnglishLanguageProvider(PackOutput output) {
        super(output, Constants.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        add(ModItems.EXAMPLE_ITEM.get(), "Example Item");
        add(ModItems.EXAMPLE_ITEM2.get(), "Example Item 2");
        add(ModBlocks.EXAMPLE_BLOCK.block().get(), "Example Block");
        add(ModBlocks.EXAMPLE_BLOCK.item().get(), "Example Block");
        add(ModEntityTypes.EXAMPLE_ENTITY.get(), "Example Entity");
        add(ModItems.EXAMPLE_SWORD.get(), "Example Sword");
        add(ModItems.EXAMPLE_SPEAR.get(), "Example Spear");
        add(ModItems.EXAMPLE_PICKAXE.get(), "Example Pickaxe");
        add(ModItems.EXAMPLE_SHOVEL.get(), "Example Shovel");
        add(ModItems.EXAMPLE_AXE.get(), "Example Axe");
        add(ModItems.EXAMPLE_HOE.get(), "Example Hoe");
    }

    private void add(Component component, String value) {
        if (component.getContents() instanceof TranslatableContents translatableContents) {
            add(translatableContents.getKey(), value);
        }
    }
}
