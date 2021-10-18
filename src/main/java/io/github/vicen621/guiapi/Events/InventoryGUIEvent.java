package io.github.vicen621.guiapi.Events;

import io.github.vicen621.guiapi.InventoryGUI;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.inventory.InventoryEvent;
import org.bukkit.inventory.InventoryView;

public class InventoryGUIEvent extends InventoryEvent {

    private static final HandlerList handlers = new HandlerList();
    private final InventoryGUI gui;
    private final Player player;

    public InventoryGUIEvent(InventoryGUI gui, Player player, InventoryView view) {
        super(view);
        this.gui = gui;
        this.player = player;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    public InventoryGUI getInventoryGUI() {
        return this.gui;
    }

    public Player getPlayer() {
        return this.player;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
}
