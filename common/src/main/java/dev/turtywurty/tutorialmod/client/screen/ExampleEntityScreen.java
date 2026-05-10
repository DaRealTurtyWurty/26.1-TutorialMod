package dev.turtywurty.tutorialmod.client.screen;

import dev.turtywurty.tutorialmod.Constants;
import dev.turtywurty.tutorialmod.menus.ExampleEntityMenu;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.player.Inventory;
import org.jspecify.annotations.NonNull;

public class ExampleEntityScreen extends AbstractContainerScreen<ExampleEntityMenu> {
    private static final Identifier TEXTURE_LOCATION = Constants.id("textures/gui/container/example_entity.png");

    public ExampleEntityScreen(ExampleEntityMenu menu, Inventory inventory, Component title) {
        super(menu, inventory, title);
    }

    @Override
    public void extractBackground(@NonNull GuiGraphicsExtractor graphics, int mouseX, int mouseY, float tickDelta) {
        super.extractBackground(graphics, mouseX, mouseY, tickDelta);
        graphics.blit(RenderPipelines.GUI_TEXTURED, TEXTURE_LOCATION, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, 256, 256);
    }
}
