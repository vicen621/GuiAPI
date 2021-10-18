package io.github.vicen621.guiapi.Listeners;

import io.github.vicen621.guiapi.Events.InventoryButtonClickEvent;
import io.github.vicen621.guiapi.GUIManager;
import io.github.vicen621.guiapi.InventoryGUI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class ButtonListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        if (GUIManager.isGUI(e.getClickedInventory())) {
            InventoryGUI gui = GUIManager.getGUI(e.getClickedInventory());
            e.setCancelled(true);
            assert gui != null;
            if (gui.isButton(e.getSlot())) {
                Player p = (Player) e.getWhoClicked();
                InventoryButtonClickEvent ev = new InventoryButtonClickEvent(gui, p, gui.getButtonID(e.getSlot()), e.getCurrentItem(), e.getView());
                Bukkit.getPluginManager().callEvent(ev);
            }
        }
    }
}
