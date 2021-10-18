package io.github.vicen621.guiapi.Events;

import io.github.vicen621.guiapi.InventoryGUI;
import org.bukkit.entity.Player;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;

public class InventoryButtonClickEvent extends InventoryGUIEvent {

    private final String buttonID;
    private final ItemStack stack;

    public InventoryButtonClickEvent(InventoryGUI gui, Player player, String buttonID, ItemStack stack, InventoryView view) {
        super(gui, player, view);
        this.buttonID = buttonID;
        this.stack = stack;
    }

    public ItemStack getItemStack() {
        return this.stack;
    }

    public String getButtonID() {
        return this.buttonID;
    }
}
