package dev.turtywurty.tutorialmod.datagen;

import dev.turtywurty.tutorialmod.init.ModBlocks;
import dev.turtywurty.tutorialmod.init.ModItems;
import dev.turtywurty.tutorialmod.services.NeoForgeRegistryHelper;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import org.jspecify.annotations.NonNull;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class TutorialModLootTableProvider extends LootTableProvider {
    public TutorialModLootTableProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(
                output,
                Set.of(),
                List.of(
                        new SubProviderEntry(TutorialModBlockLootSubProvider::new, LootContextParamSets.BLOCK)
                ),
                registries
        );
    }

    private static final class TutorialModBlockLootSubProvider extends BlockLootSubProvider {
        TutorialModBlockLootSubProvider(HolderLookup.Provider registries) {
            super(Set.of(), FeatureFlags.DEFAULT_FLAGS, registries);
        }

        @Override
        protected void generate() {
            dropSelf(ModBlocks.EXAMPLE_BLOCK.block().get());
            add(ModBlocks.EXAMPLE_OVERWORLD_ORE.block().get(), block -> createOreDrop(block, ModItems.EXAMPLE_ITEM.get()));
            dropSelf(ModBlocks.EXAMPLE_DEEPSLATE_ORE.block().get());
            add(ModBlocks.EXAMPLE_NETHER_ORE.block().get(), block -> createOreDrop(block, ModItems.EXAMPLE_ITEM.get()));
            dropSelf(ModBlocks.EXAMPLE_END_ORE.block().get());
        }

        @Override
        protected @NonNull Iterable<Block> getKnownBlocks() {
            return NeoForgeRegistryHelper.BLOCKS.getEntries()
                    .stream()
                    .map(entry -> (Block) entry.value())
                    .toList();
        }
    }
}
