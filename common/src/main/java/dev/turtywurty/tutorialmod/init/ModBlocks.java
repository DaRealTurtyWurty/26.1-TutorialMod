package dev.turtywurty.tutorialmod.init;

import dev.turtywurty.tutorialmod.services.Services;
import dev.turtywurty.tutorialmod.services.util.BlockWithItemRegistryHandle;
import net.minecraft.world.level.block.Block;

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

    private static BlockWithItemRegistryHandle<Block> createOreBlock(String name) {
        return Services.REGISTRY.registerBlockWithItem(name,
                properties -> new Block(properties.strength(3.0F, 3.0F).requiresCorrectToolForDrops()));
    }
}
