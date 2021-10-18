/*
 * Copyright (c) 2021. Vicen621
 * All rights reserved
 */

package io.github.vicen621.guiapi;

import io.github.vicen621.guiapi.Listeners.ButtonListener;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public class GUIManager {

    private static final HashMap<String, InventoryGUI> guis = new HashMap<>();

    /**
     * Constructs a new GUIManager and pass the plugin to register the events
     * @param plugin Class that extends JavaPlugin
     */
    public GUIManager(JavaPlugin plugin) {
        Bukkit.getPluginManager().registerEvents(new ButtonListener(), plugin);
    }

    /**
     * Registers a new gui into the GUIManager
     * @param gui InventoryGUI that has to be registered
     */
    protected static void registerGUI(InventoryGUI gui) {
        guis.put(gui.getId(), gui);
    }

    /**
     * Gets an InventoryGUI with his ID
     * @param id ID of the InventoryGUI
     * @return The InventoryGUI
     */
    public static InventoryGUI getGUI(String id) {
        return guis.get(id);
    }

    /**
     * Gets an InventoryGUI with his Inventory
     * @param inv Inventory of the InventoryGUI
     * @return The InventoryGUI
     * @see <a href="https://papermc.io/javadocs/paper/1.17/org/bukkit/Inventory/package-summary.html">Inventory</a>
     */
    public static InventoryGUI getGUI(Inventory inv) {
        for (String guiID : guis.keySet()) {
            InventoryGUI gui = guis.get(guiID);
            if (gui.getInventory().equals(inv)) {
                return gui;
            }
        }
        return null;
    }

    /**
     * Check if the inventory is an InventoryGUI
     * @param inv Inventory of the possible InventoryGUI
     * @return True if the inventory is an InventoryGUI
     * @see <a href="https://papermc.io/javadocs/paper/1.17/org/bukkit/Inventory/package-summary.html">Inventory</a>
     */
    public static boolean isGUI(Inventory inv) {
        return getGUI(inv) != null;
    }
}