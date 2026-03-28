package dev.turtywurty.tutorialmod.datagen;

import dev.turtywurty.tutorialmod.init.ModBlocks;
import net.minecraft.world.level.block.Block;

public final class TutorialModLootTableProvider {
    private TutorialModLootTableProvider() {
    }

    public static void generateBlockLoot(BlockLootOutput output) {
        output.dropSelf(ModBlocks.EXAMPLE_BLOCK.block().get());
    }

    public interface BlockLootOutput {
        void dropSelf(Block block);
    }
}
