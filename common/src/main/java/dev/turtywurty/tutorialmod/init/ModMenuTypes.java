package dev.turtywurty.tutorialmod.init;

import dev.turtywurty.tutorialmod.menus.ExampleEntityMenu;
import dev.turtywurty.tutorialmod.services.Services;
import dev.turtywurty.tutorialmod.services.util.RegistryHandle;
import net.minecraft.world.inventory.MenuType;

public final class ModMenuTypes {
    private ModMenuTypes() {
    }

    public static final RegistryHandle<MenuType<ExampleEntityMenu>> EXAMPLE_MENU_TYPE =
            Services.REGISTRY.registerMenuType("example", ExampleEntityMenu.class);

    public static void load() {
    }
}
