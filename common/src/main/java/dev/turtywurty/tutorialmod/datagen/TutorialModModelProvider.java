package dev.turtywurty.tutorialmod.datagen;

import dev.turtywurty.tutorialmod.init.ModBlocks;
import dev.turtywurty.tutorialmod.init.ModItems;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public final class TutorialModModelProvider {
    private TutorialModModelProvider() {
    }

    public static void generateBlockStateModels(BlockStateModelOutput output) {
        output.registerSimpleCubeAll(ModBlocks.EXAMPLE_BLOCK.block().get());
    }

    public static void generateItemModels(ItemModelOutput output) {
        output.generateFlatItem(ModItems.EXAMPLE_ITEM.get());
        output.generateFlatItem(ModItems.EXAMPLE_ITEM2.get());
    }

    public interface BlockStateModelOutput {
        void registerSimpleCubeAll(Block block);
    }

    public interface ItemModelOutput {
        void generateFlatItem(Item item);
    }
}
