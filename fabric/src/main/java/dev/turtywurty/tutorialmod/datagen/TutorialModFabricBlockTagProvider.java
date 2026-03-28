package dev.turtywurty.tutorialmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.tags.TagAppender;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import org.jspecify.annotations.NonNull;

import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

public final class TutorialModFabricBlockTagProvider extends FabricTagsProvider.BlockTagsProvider {
    public TutorialModFabricBlockTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.@NonNull Provider registries) {
        TutorialModTagProvider.generateBlockTags(new FabricBlockTagOutput(this::valueLookupBuilder, registries));
    }

    public record FabricBlockTagOutput(Function<TagKey<Block>, TagAppender<Block, Block>> provider,
                                       HolderLookup.@NonNull Provider registries)
            implements TutorialModTagProvider.BlockTagOutput {
        @Override
        public void add(TagKey<Block> tag, Block... blocks) {
            this.provider.apply(tag).add(blocks);
        }
    }
}
