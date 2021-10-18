/*
 * Copyright (c) 2021. Vicen621
 * All rights reserved
 */

package io.github.vicen621.guiapi;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class InventoryGUI {

    private final Inventory inventory;
    @Getter final String id;
    private final HashMap<Integer, String> btns = new HashMap<>();

    /**
     * Constructs a new InventoryGUI with an ID and a title
     * @param id Inventory ID
     * @param title Title of the inventory
     */
    public InventoryGUI(String id, String title) {
        this(id, title, 6);
    }

    /**
     * Constructs a new InventoryGUI with an ID, title and row amount
     * @param id ID of the inventory
     * @param title Title of the inventory
     * @param rowAmount Rows of the inventory
     */
    public InventoryGUI(String id, String title, int rowAmount) {
        this.id = id;
        this.inventory = Bukkit.createInventory(null, rowAmount * 9, title);
        GUIManager.registerGUI(this);
    }

    /**
     * Opens the inventory to the given player
     * @param p Player to open inventory to
     * @see <a href="https://papermc.io/javadocs/paper/1.17/org/bukkit/Player/package-summary.html">Player</a>
     */
    public void open(OfflinePlayer p) {
        if (p.isOnline()) {
            p.getPlayer().openInventory(this.inventory);
        }
    }

    /**
     * Sets a button into the InventoryGUI
     * @param id ID of the button
     * @param slot Slot in which the button must go
     * @param button ItemStack of the button
     * @see <a href="https://papermc.io/javadocs/paper/1.17/org/bukkit/ItemStack/package-summary.html">ItemStack</a>
     */
    public void setButton(String id, int slot, ItemStack button) {
        this.inventory.setItem(slot, button);
        this.btns.put(slot, id);
    }

    /**
     * Fills the given column with the given ItemStack
     * @param column Number of the column
     * @param item ItemStack with which to be filled
     * @see <a href="https://papermc.io/javadocs/paper/1.17/org/bukkit/ItemStack/package-summary.html">ItemStack</a>
     */
    public void setColumn(int column, ItemStack item) {
        for (int i = (column - 1); i < this.inventory.getSize(); i += 9) {
            if (this.inventory.getItem(i) == null || this.inventory.getItem(i).getType() == Material.AIR)
                this.inventory.setItem(i, item);
        }
    }

    /**
     * Fill the inventory with the given items in an intersected shape
     * @param item1 ItemStack in the first slot
     * @param item2 ItemStack in the second slot
     * @see <a href="https://papermc.io/javadocs/paper/1.17/org/bukkit/ItemStack/package-summary.html">ItemStack</a>
     */
    public void setIntersected(ItemStack item1, ItemStack item2) {
        for (int i = 0; i < this.inventory.getSize(); i += 2) {
            if (this.inventory.getItem(i) == null || this.inventory.getItem(i).getType() == Material.AIR)
                this.inventory.setItem(i, item1);
        }

        for (int i = 1; i < this.inventory.getSize(); i += 2) {
            if (this.inventory.getItem(i) == null || this.inventory.getItem(i).getType() == Material.AIR)
                this.inventory.setItem(i, item2);
        }
    }

    /**
     * Fills the given row with the given ItemStack
     * @param row Number of row
     * @param item ItemStack with which to be filled
     * @see <a href="https://papermc.io/javadocs/paper/1.17/org/bukkit/ItemStack/package-summary.html">ItemStack</a>
     */
    public void setRow(int row, ItemStack item) {

        if (this.inventory.getSize() < ((row - 1) * 9) + 9)
            throw new IllegalArgumentException("This inventory doesn't have " + row + " rows");

        for (int i = (row - 1) * 9; i < ((row - 1) * 9) + 9; i++) {
            if (this.inventory.getItem(i) == null || this.inventory.getItem(i).getType() == Material.AIR)
                this.inventory.setItem(i, item);
        }
    }

    /**
     * Fills the inventory with the given ItemStack
     * @param item ItemStack with which to be filled
     * @see <a href="https://papermc.io/javadocs/paper/1.17/org/bukkit/ItemStack/package-summary.html">ItemStack</a>
     */
    public void fill(ItemStack item) {
        for (int i = 0; i < this.inventory.getSize(); i++) {
            if (this.inventory.getItem(i) == null || this.inventory.getItem(i).getType() == Material.AIR)
                this.inventory.setItem(i, item);
        }
    }

    /**
     * Gets the inventory of the InventoryGUI
     * @return The inventory of the InventoryGUI
     * @see <a href="https://papermc.io/javadocs/paper/1.17/org/bukkit/inventory/package-summary.html">Inventory</a>
     */
    public Inventory getInventory() {
        return this.inventory;
    }

    /**
     * Gets the ID of the button in the given slot
     * @param slot Slot of the button
     * @return The ID of the button
     */
    public String getButtonID(int slot) {
        return btns.get(slot);
    }

    /**
     * Check if the given slot is a button
     * @param slot Slot of the possible button
     * @return True if the slot is a button
     */
    public boolean isButton(int slot) {
        return getButtonID(slot) != null;
    }
}
