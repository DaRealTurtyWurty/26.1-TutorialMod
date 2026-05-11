package dev.turtywurty.tutorialmod.init;

import dev.turtywurty.tutorialmod.services.Services;
import dev.turtywurty.tutorialmod.services.util.BlockWithItemRegistryHandle;
import dev.turtywurty.tutorialmod.services.util.RegistryHandle;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.PushReaction;

public final class ModBlocks {
    private ModBlocks() {
    }

    public static void load() {
    }

    public static final BlockWithItemRegistryHandle<Block> EXAMPLE_BLOCK = Services.REGISTRY.registerBlockWithItem("example_block",
            properties -> new Block(properties.strength(3.0F, 15.0F).requiresCorrectToolForDrops()));

    public static final BlockWithItemRegistryHandle<Block> EXAMPLE_OVERWORLD_ORE = createOreBlock("example_overworld_ore");
    public static final BlockWithItemRegistryHandle<Block> EXAMPLE_DEEPSLATE_ORE = createOreBlock("example_deepslate_ore");
    public static final BlockWithItemRegistryHandle<Block> EXAMPLE_NETHER_ORE = createOreBlock("example_nether_ore");
    public static final BlockWithItemRegistryHandle<Block> EXAMPLE_END_ORE = createOreBlock("example_end_ore");
    public static final BlockWithItemRegistryHandle<FlowerBlock> EXAMPLE_FLOWER = Services.REGISTRY.registerBlockWithItem("example_flower",
            properties -> new FlowerBlock(MobEffects.DOLPHINS_GRACE, 4.0f, properties.noCollision().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ)));
    public static final RegistryHandle<Block> POTTED_EXAMPLE_FLOWER = Services.REGISTRY.registerBlock("potted_example_flower",
            properties -> new FlowerPotBlock(EXAMPLE_FLOWER.block().get(), properties.instabreak().noOcclusion().pushReaction(PushReaction.DESTROY)));

    private static BlockWithItemRegistryHandle<Block> createOreBlock(String name) {
        return Services.REGISTRY.registerBlockWithItem(name,
                properties -> new Block(properties.strength(3.0F, 3.0F).requiresCorrectToolForDrops()));
    }
}
