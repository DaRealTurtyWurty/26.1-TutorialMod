package dev.turtywurty.tutorialmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.level.block.Block;

import java.util.concurrent.CompletableFuture;

public final class TutorialModFabricBlockLootTableProvider extends FabricBlockLootSubProvider {
    public TutorialModFabricBlockLootTableProvider(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(packOutput, registriesFuture);
    }

    @Override
    public void generate() {
        TutorialModLootTableProvider.generateBlockLoot(new FabricBlockLootOutput(this));
    }

    public record FabricBlockLootOutput(FabricBlockLootSubProvider provider)
            implements TutorialModLootTableProvider.BlockLootOutput {
        @Override
        public void dropSelf(Block block) {
            provider.dropSelf(block);
        }
    }
}
