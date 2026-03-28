package dev.turtywurty.tutorialmod.datagen;

import dev.turtywurty.tutorialmod.Constants;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagAppender;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import org.jspecify.annotations.NonNull;

import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

public final class TutorialModNeoForgeBlockTagProvider extends BlockTagsProvider {
    public TutorialModNeoForgeBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture, Constants.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.@NonNull Provider registries) {
        TutorialModTagProvider.generateBlockTags(new NeoForgeBlockTagOutput(this::tag, registries));
    }

    public record NeoForgeBlockTagOutput(Function<TagKey<Block>, TagAppender<Block, Block>> provider,
                                         HolderLookup.@NonNull Provider registries)
            implements TutorialModTagProvider.BlockTagOutput {
        @Override
        public void add(TagKey<Block> tag, Block... blocks) {
            this.provider.apply(tag).add(blocks);
        }
    }
}
