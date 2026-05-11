package dev.turtywurty.tutorialmod.datagen;

import dev.turtywurty.tutorialmod.Constants;
import dev.turtywurty.tutorialmod.init.ModBlocks;
import dev.turtywurty.tutorialmod.init.ModItems;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.data.PackOutput;

public class TutorialModModelProvider extends ModelProvider {
    public TutorialModModelProvider(PackOutput output) {
        super(output, Constants.MOD_ID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        itemModels.generateFlatItem(ModItems.EXAMPLE_ITEM.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.EXAMPLE_ITEM2.get(), ModelTemplates.FLAT_ITEM);

        blockModels.createTrivialCube(ModBlocks.EXAMPLE_BLOCK.block().get());
        blockModels.createTrivialCube(ModBlocks.EXAMPLE_OVERWORLD_ORE.block().get());
        blockModels.createTrivialCube(ModBlocks.EXAMPLE_DEEPSLATE_ORE.block().get());
        blockModels.createTrivialCube(ModBlocks.EXAMPLE_NETHER_ORE.block().get());
        blockModels.createTrivialCube(ModBlocks.EXAMPLE_END_ORE.block().get());

        itemModels.generateFlatItem(ModItems.EXAMPLE_SWORD.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateSpear(ModItems.EXAMPLE_SPEAR.get());
        itemModels.generateFlatItem(ModItems.EXAMPLE_PICKAXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(ModItems.EXAMPLE_AXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(ModItems.EXAMPLE_SHOVEL.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(ModItems.EXAMPLE_HOE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(ModItems.EXAMPLE_HELMET.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.EXAMPLE_CHESTPLATE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.EXAMPLE_LEGGINGS.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.EXAMPLE_BOOTS.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.EXAMPLE_FOOD.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.EXAMPLE_ENTITY_SPAWN_EGG.get(), ModelTemplates.FLAT_ITEM);
    }
}
