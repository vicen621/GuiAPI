package io.github.vicen621.guiapi;

import io.github.vicen621.guiapi.Listeners.ButtonListener;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public class GUIManager {

    private static final HashMap<String, InventoryGUI> guis = new HashMap<>();

    private GUIManager(JavaPlugin plugin) {
        Bukkit.getPluginManager().registerEvents(new ButtonListener(), plugin);
    }

    protected static void registerGUI(InventoryGUI gui) {
        guis.put(gui.getId(), gui);
    }

    public static InventoryGUI getGUI(String id) {
        return guis.get(id);
    }

    public static InventoryGUI getGUI(Inventory inv) {
        for (String guiID : guis.keySet()) {
            InventoryGUI gui = guis.get(guiID);
            if (gui.getInventory().equals(inv)) {
                return gui;
            }
        }
        return null;
    }

    public static boolean isGUI(Inventory inv) {
        return getGUI(inv) != null;
    }
}