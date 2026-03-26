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
}
