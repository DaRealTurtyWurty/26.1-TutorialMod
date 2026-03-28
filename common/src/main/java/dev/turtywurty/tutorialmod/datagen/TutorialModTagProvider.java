package dev.turtywurty.tutorialmod.datagen;

import dev.turtywurty.tutorialmod.init.ModBlocks;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public final class TutorialModTagProvider {
    private TutorialModTagProvider() {
    }

    public static void generateBlockTags(BlockTagOutput output) {
        output.add(BlockTags.MINEABLE_WITH_PICKAXE, ModBlocks.EXAMPLE_BLOCK.block().get());
        output.add(BlockTags.NEEDS_IRON_TOOL, ModBlocks.EXAMPLE_BLOCK.block().get());
    }

    public interface BlockTagOutput {
        void add(TagKey<Block> tag, Block... blocks);
    }
}
