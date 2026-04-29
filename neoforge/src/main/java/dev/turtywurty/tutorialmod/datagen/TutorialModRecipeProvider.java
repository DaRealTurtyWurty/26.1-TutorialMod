package dev.turtywurty.tutorialmod.datagen;

import dev.turtywurty.tutorialmod.Constants;
import dev.turtywurty.tutorialmod.init.ModBlocks;
import dev.turtywurty.tutorialmod.init.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.neoforged.neoforge.common.Tags;
import org.jspecify.annotations.NonNull;

import java.util.concurrent.CompletableFuture;

public class TutorialModRecipeProvider extends RecipeProvider {
    public TutorialModRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        super(registries, output);
    }

    @Override
    protected void buildRecipes() {
        shaped(RecipeCategory.COMBAT, ModItems.EXAMPLE_SWORD.get())
                .define('E', ModItems.EXAMPLE_ITEM.get())
                .define('S', Tags.Items.RODS_WOODEN)
                .pattern("E")
                .pattern("E")
                .pattern("S")
                .unlockedBy(getHasName(ModItems.EXAMPLE_ITEM.get()), has(ModItems.EXAMPLE_ITEM.get()))
                .save(output);

        shaped(RecipeCategory.COMBAT, ModItems.EXAMPLE_SPEAR.get())
                .define('E', ModItems.EXAMPLE_ITEM.get())
                .define('S', Tags.Items.RODS_WOODEN)
                .pattern("  E")
                .pattern(" S ")
                .pattern("S  ")
                .unlockedBy(getHasName(ModItems.EXAMPLE_ITEM.get()), has(ModItems.EXAMPLE_ITEM.get()))
                .save(output);

        shaped(RecipeCategory.TOOLS, ModItems.EXAMPLE_PICKAXE.get())
                .define('E', ModItems.EXAMPLE_ITEM.get())
                .define('S', Tags.Items.RODS_WOODEN)
                .pattern("EEE")
                .pattern(" S ")
                .pattern(" S ")
                .unlockedBy(getHasName(ModItems.EXAMPLE_ITEM.get()), has(ModItems.EXAMPLE_ITEM.get()))
                .save(output);

        shaped(RecipeCategory.TOOLS, ModItems.EXAMPLE_SHOVEL.get())
                .define('E', ModItems.EXAMPLE_ITEM.get())
                .define('S', Tags.Items.RODS_WOODEN)
                .pattern("E")
                .pattern("S")
                .pattern("S")
                .unlockedBy(getHasName(ModItems.EXAMPLE_ITEM.get()), has(ModItems.EXAMPLE_ITEM.get()))
                .save(output);

        shaped(RecipeCategory.TOOLS, ModItems.EXAMPLE_AXE.get())
                .define('E', ModItems.EXAMPLE_ITEM.get())
                .define('S', Tags.Items.RODS_WOODEN)
                .pattern("EE")
                .pattern("ES")
                .pattern(" S")
                .unlockedBy(getHasName(ModItems.EXAMPLE_ITEM.get()), has(ModItems.EXAMPLE_ITEM.get()))
                .save(output);

        shaped(RecipeCategory.TOOLS, ModItems.EXAMPLE_HOE.get())
                .define('E', ModItems.EXAMPLE_ITEM.get())
                .define('S', Tags.Items.RODS_WOODEN)
                .pattern("EE")
                .pattern(" S")
                .pattern(" S")
                .unlockedBy(getHasName(ModItems.EXAMPLE_ITEM.get()), has(ModItems.EXAMPLE_ITEM.get()))
                .save(output);

        shaped(RecipeCategory.COMBAT, ModItems.EXAMPLE_HELMET.get())
                .define('E', ModItems.EXAMPLE_ITEM.get())
                .pattern("EEE")
                .pattern("E E")
                .unlockedBy(getHasName(ModItems.EXAMPLE_ITEM.get()), has(ModItems.EXAMPLE_ITEM.get()))
                .save(output);

        shaped(RecipeCategory.COMBAT, ModItems.EXAMPLE_CHESTPLATE.get())
                .define('E', ModItems.EXAMPLE_ITEM.get())
                .pattern("E E")
                .pattern("EEE")
                .pattern("EEE")
                .unlockedBy(getHasName(ModItems.EXAMPLE_ITEM.get()), has(ModItems.EXAMPLE_ITEM.get()))
                .save(output);

        shaped(RecipeCategory.COMBAT, ModItems.EXAMPLE_LEGGINGS.get())
                .define('E', ModItems.EXAMPLE_ITEM.get())
                .pattern("EEE")
                .pattern("E E")
                .pattern("E E")
                .unlockedBy(getHasName(ModItems.EXAMPLE_ITEM.get()), has(ModItems.EXAMPLE_ITEM.get()))
                .save(output);

        shaped(RecipeCategory.COMBAT, ModItems.EXAMPLE_BOOTS.get())
                .define('E', ModItems.EXAMPLE_ITEM.get())
                .pattern("E E")
                .pattern("E E")
                .unlockedBy(getHasName(ModItems.EXAMPLE_ITEM.get()), has(ModItems.EXAMPLE_ITEM.get()))
                .save(output);

        nineBlockStorageRecipes(RecipeCategory.MISC, ModItems.EXAMPLE_ITEM.get(),
                RecipeCategory.BUILDING_BLOCKS, ModBlocks.EXAMPLE_BLOCK.item().get());
        twoByTwoPacker(RecipeCategory.BUILDING_BLOCKS, ModBlocks.EXAMPLE_BLOCK.item().get(), ModItems.EXAMPLE_ITEM2.get());

        shaped(RecipeCategory.FOOD, ModItems.EXAMPLE_FOOD.get())
                .define('E', ModItems.EXAMPLE_ITEM.get())
                .define('2', ModItems.EXAMPLE_ITEM2.get())
                .pattern("E2")
                .unlockedBy(getHasName(ModItems.EXAMPLE_ITEM.get()), has(ModItems.EXAMPLE_ITEM.get()))
                .unlockedBy(getHasName(ModItems.EXAMPLE_ITEM2.get()), has(ModItems.EXAMPLE_ITEM2.get()))
                .save(output);
    }

    public static class Runner extends RecipeProvider.Runner {
        public Runner(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> registries) {
            super(packOutput, registries);
        }

        @Override
        protected @NonNull RecipeProvider createRecipeProvider(HolderLookup.@NonNull Provider provider, @NonNull RecipeOutput recipeOutput) {
            return new TutorialModRecipeProvider(provider, recipeOutput);
        }

        @Override
        public @NonNull String getName() {
            return Constants.MOD_NAME + " Recipes";
        }
    }
}
