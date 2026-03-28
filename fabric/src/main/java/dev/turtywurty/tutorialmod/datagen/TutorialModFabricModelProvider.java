package dev.turtywurty.tutorialmod.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import org.jspecify.annotations.NonNull;

public final class TutorialModFabricModelProvider extends FabricModelProvider {
    public TutorialModFabricModelProvider(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(@NonNull BlockModelGenerators blockModelGenerators) {
        TutorialModModelProvider.generateBlockStateModels(new FabricBlockStateModelOutput(blockModelGenerators));
    }

    @Override
    public void generateItemModels(@NonNull ItemModelGenerators itemModelGenerators) {
        TutorialModModelProvider.generateItemModels(new FabricItemModelOutput(itemModelGenerators));
    }

    public record FabricItemModelOutput(ItemModelGenerators itemModelGenerators)
            implements TutorialModModelProvider.ItemModelOutput {
        @Override
        public void generateFlatItem(Item item) {
            this.itemModelGenerators.generateFlatItem(item, ModelTemplates.FLAT_ITEM);
        }
    }

    private record FabricBlockStateModelOutput(BlockModelGenerators blockModelGenerators)
            implements TutorialModModelProvider.BlockStateModelOutput {
        @Override
        public void registerSimpleCubeAll(Block block) {
            this.blockModelGenerators.createTrivialCube(block);
        }
    }
}
