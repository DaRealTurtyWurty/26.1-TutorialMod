package dev.turtywurty.tutorialmod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public final class TutorialModNeoForgeLootTableProvider extends LootTableProvider {
    public TutorialModNeoForgeLootTableProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(
                packOutput,
                Set.of(),
                List.of(new SubProviderEntry(TutorialModNeoForgeBlockLootTableProvider::new, LootContextParamSets.BLOCK)),
                lookupProvider
        );
    }

    private static final class TutorialModNeoForgeBlockLootTableProvider extends BlockLootSubProvider {
        private TutorialModNeoForgeBlockLootTableProvider(HolderLookup.Provider registries) {
            super(Set.of(), FeatureFlags.DEFAULT_FLAGS, registries);
        }

        @Override
        public void generate() {
            TutorialModLootTableProvider.generateBlockLoot(new TutorialModLootTableProvider.BlockLootOutput() {
                @Override
                public void dropSelf(Block block) {
                    TutorialModNeoForgeBlockLootTableProvider.this.dropSelf(block);
                }
            });
        }
    }
}
