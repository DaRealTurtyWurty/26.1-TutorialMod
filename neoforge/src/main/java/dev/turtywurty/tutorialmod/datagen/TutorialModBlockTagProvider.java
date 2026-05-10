package dev.turtywurty.tutorialmod.datagen;

import dev.turtywurty.tutorialmod.Constants;
import dev.turtywurty.tutorialmod.init.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;

import java.util.concurrent.CompletableFuture;

public class TutorialModBlockTagProvider extends BlockTagsProvider {
    public TutorialModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, Constants.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.EXAMPLE_BLOCK.block().get())
                .add(ModBlocks.EXAMPLE_OVERWORLD_ORE.block().get())
                .add(ModBlocks.EXAMPLE_DEEPSLATE_ORE.block().get())
                .add(ModBlocks.EXAMPLE_NETHER_ORE.block().get())
                .add(ModBlocks.EXAMPLE_END_ORE.block().get());
        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.EXAMPLE_BLOCK.block().get())
                .add(ModBlocks.EXAMPLE_OVERWORLD_ORE.block().get())
                .add(ModBlocks.EXAMPLE_DEEPSLATE_ORE.block().get())
                .add(ModBlocks.EXAMPLE_NETHER_ORE.block().get())
                .add(ModBlocks.EXAMPLE_END_ORE.block().get());
    }
}
