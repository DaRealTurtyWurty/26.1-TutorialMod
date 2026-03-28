package dev.turtywurty.tutorialmod.datagen;

import dev.turtywurty.tutorialmod.Constants;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import org.jspecify.annotations.NonNull;

public final class TutorialModNeoForgeModelProvider extends ModelProvider {
    public TutorialModNeoForgeModelProvider(PackOutput output) {
        super(output, Constants.MOD_ID);
    }

    @Override
    protected void registerModels(@NonNull BlockModelGenerators blockModels, @NonNull ItemModelGenerators itemModels) {
        TutorialModModelProvider.generateBlockStateModels(new NeoForgeBlockStateModelOutput(blockModels));
        TutorialModModelProvider.generateItemModels(new NeoForgeItemModelOutput(itemModels));
    }

    public record NeoForgeItemModelOutput(ItemModelGenerators itemModelGenerators)
            implements TutorialModModelProvider.ItemModelOutput {
        @Override
        public void generateFlatItem(Item item) {
            this.itemModelGenerators.generateFlatItem(item, ModelTemplates.FLAT_ITEM);
        }
    }

    private record NeoForgeBlockStateModelOutput(BlockModelGenerators blockModelGenerators)
            implements TutorialModModelProvider.BlockStateModelOutput {
        @Override
        public void registerSimpleCubeAll(Block block) {
            this.blockModelGenerators.createTrivialCube(block);
        }
    }
}
