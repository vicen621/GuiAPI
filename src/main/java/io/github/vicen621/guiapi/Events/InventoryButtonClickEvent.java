/*
 * Copyright (c) 2021. Vicen621
 * All rights reserved
 */

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

    /**
     * Returns the itemstack of the button involved in this event
     * @return ItemStack of the button that is involved in this event
     * @see <a href="https://papermc.io/javadocs/paper/1.17/org/bukkit/ItemStack/package-summary.html">ItemStack</a>
     */
    public ItemStack getItemStack() {
        return this.stack;
    }

    /**
     * Returns the ID of the button involved in this event
     * @return ID of the button involved in this event
     */
    public String getButtonID() {
        return this.buttonID;
    }
}
