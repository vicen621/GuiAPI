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

    public InventoryGUI(String name, String title) {
        this(name, title, 6);
    }

    public InventoryGUI(String id, String title, int rowAmount) {
        this.id = id;
        this.inventory = Bukkit.createInventory(null, rowAmount * 9, title);
        GUIManager.registerGUI(this);
    }

    public void open(OfflinePlayer p) {
        if (p.isOnline()) {
            p.getPlayer().openInventory(this.inventory);
        }
    }

    public void setButton(String id, int slot, ItemStack button) {
        this.inventory.setItem(slot, button);
        this.btns.put(slot, id);
    }

    public void setColumn(int column, ItemStack item) {
        for (int i = (column - 1); i < this.inventory.getSize(); i += 9) {
            if (this.inventory.getItem(i) == null || this.inventory.getItem(i).getType() == Material.AIR)
                this.inventory.setItem(i, item);
        }
    }

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

    public void setRow(int row, ItemStack item) {

        if (this.inventory.getSize() < ((row - 1) * 9) + 9)
            throw new IllegalArgumentException("This inventory doesn't have " + row + " rows");

        for (int i = (row - 1) * 9; i < ((row - 1) * 9) + 9; i++) {
            if (this.inventory.getItem(i) == null || this.inventory.getItem(i).getType() == Material.AIR)
                this.inventory.setItem(i, item);
        }
    }

    public void fill(ItemStack item) {
        for (int i = 0; i < this.inventory.getSize(); i++) {
            if (this.inventory.getItem(i) == null || this.inventory.getItem(i).getType() == Material.AIR)
                this.inventory.setItem(i, item);
        }
    }

    public Inventory getInventory() {
        return this.inventory;
    }

    public String getButtonID(int slot) {
        return btns.get(slot);
    }

    public boolean isButton(int slot) {
        return getButtonID(slot) != null;
    }
}
