package dev.turtywurty.tutorialmod.init;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.ToolMaterial;

public final class ModToolMaterials {
    private ModToolMaterials() {
    }

    public static final ToolMaterial EXAMPLE_TOOL_MATERIAL = new ToolMaterial(
            BlockTags.INCORRECT_FOR_IRON_TOOL,
            512,
            7.0F,
            2.5F,
            18,
            ModItemTags.EXAMPLE_TOOL_MATERIALS
    );
}
