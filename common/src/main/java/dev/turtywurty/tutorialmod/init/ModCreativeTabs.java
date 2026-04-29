package dev.turtywurty.tutorialmod.init;

import dev.turtywurty.tutorialmod.Constants;
import dev.turtywurty.tutorialmod.services.Services;
import dev.turtywurty.tutorialmod.services.util.RegistryHandle;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import java.util.Objects;

public final class ModCreativeTabs {
    private ModCreativeTabs() {
    }

    public static final RegistryHandle<CreativeModeTab> EXAMPLE_TAB =
            Services.REGISTRY.registerCreativeTab("example_tab", () -> new ItemStack(ModItems.EXAMPLE_ITEM.get()),
                    output -> BuiltInRegistries.ITEM.stream()
                            .filter(item -> Objects.equals(BuiltInRegistries.ITEM.getKey(item).getNamespace(), Constants.MOD_ID))
                            .forEachOrdered(output::accept));

    public static void load() {
    }
}
