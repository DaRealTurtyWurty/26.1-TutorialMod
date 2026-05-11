package dev.turtywurty.tutorialmod.datagen;

import dev.turtywurty.tutorialmod.Constants;
import dev.turtywurty.tutorialmod.init.ModBlocks;
import dev.turtywurty.tutorialmod.init.ModItemTags;
import dev.turtywurty.tutorialmod.init.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.ItemTags;
import net.neoforged.neoforge.common.data.ItemTagsProvider;
import org.jspecify.annotations.NonNull;

import java.util.concurrent.CompletableFuture;

public class TutorialModItemTagProvider extends ItemTagsProvider {
    public TutorialModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, Constants.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.@NonNull Provider provider) {
        tag(ModItemTags.EXAMPLE_TOOL_MATERIALS)
                .add(ModItems.EXAMPLE_ITEM.get());

        tag(ItemTags.SMALL_FLOWERS)
                .add(ModBlocks.EXAMPLE_FLOWER.item().get());
        tag(ItemTags.BEE_FOOD)
                .add(ModBlocks.EXAMPLE_FLOWER.item().get());
    }
}
