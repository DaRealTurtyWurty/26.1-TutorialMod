package dev.turtywurty.tutorialmod.init;

import dev.turtywurty.tutorialmod.Constants;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public final class ModItemTags {
    private ModItemTags() {
    }

    public static final TagKey<Item> EXAMPLE_TOOL_MATERIALS = create("example_tool_materials");

    public static TagKey<Item> create(String name) {
        return TagKey.create(Registries.ITEM, Constants.id(name));
    }
}
