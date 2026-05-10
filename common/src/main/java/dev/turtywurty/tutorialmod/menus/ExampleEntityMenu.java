package dev.turtywurty.tutorialmod.menus;

import dev.turtywurty.tutorialmod.entities.ExampleEntity;
import dev.turtywurty.tutorialmod.init.ModMenuTypes;
import dev.turtywurty.tutorialmod.network.IntegerPayload;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import org.jspecify.annotations.NonNull;

public class ExampleEntityMenu extends AbstractContainerMenu {
    private final SimpleContainer inventory;
    private final ExampleEntity entity;

    public ExampleEntityMenu(int containerId, Inventory playerInv, ExampleEntity entity) {
        super(ModMenuTypes.EXAMPLE_MENU_TYPE.get(), containerId);
        this.inventory = entity.getInventory();
        this.entity = entity;

        checkContainerSize(this.inventory, 18);
        this.inventory.startOpen(playerInv.player);

        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 6; column++) {
                addSlot(new Slot(this.inventory, column + row * 6, 62 + column * 18, 18 + row * 18));
            }
        }

        addStandardInventorySlots(playerInv, 8, 84);
    }

    public ExampleEntityMenu(int containerId, Inventory playerInv, IntegerPayload entityIdPayload) {
        this(containerId, playerInv, (ExampleEntity) playerInv.player.level().getEntity(entityIdPayload.integer()));
    }

    public ExampleEntityMenu(int containerId, Inventory playerInv, RegistryFriendlyByteBuf byteBuf) {
        this(containerId, playerInv, (ExampleEntity) playerInv.player.level().getEntity(byteBuf.readInt()));
    }

    @Override
    public @NonNull ItemStack quickMoveStack(@NonNull Player player, int slotIndex) {
        ItemStack quickMoveStack = ItemStack.EMPTY;
        Slot quickMovedSlot = this.slots.get(slotIndex);
        if (quickMovedSlot != null && quickMovedSlot.hasItem()) {
            ItemStack rawStack = quickMovedSlot.getItem();
            quickMoveStack = rawStack.copy();

            if (slotIndex < this.inventory.getContainerSize()) {
                if (!moveItemStackTo(rawStack, this.inventory.getContainerSize(), this.slots.size(), true))
                    return ItemStack.EMPTY;
            } else if (!moveItemStackTo(rawStack, 0, this.inventory.getContainerSize(), false))
                return ItemStack.EMPTY;

            if (rawStack.isEmpty()) {
                quickMovedSlot.set(ItemStack.EMPTY);
            } else {
                quickMovedSlot.setChanged();
            }
        }

        return quickMoveStack;
    }

    @Override
    public boolean stillValid(@NonNull Player player) {
        return this.inventory.stillValid(player)
                && this.entity.isAlive()
                && player.isWithinEntityInteractionRange(this.entity, 4.0D);
    }

    @Override
    public void removed(@NonNull Player player) {
        super.removed(player);
        this.inventory.stopOpen(player);
    }
}
