/*
 * Copyright (c) 2021. Vicen621
 * All rights reserved
 */

package io.github.vicen621.guiapi.Events;

import io.github.vicen621.guiapi.InventoryGUI;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.inventory.InventoryEvent;
import org.bukkit.inventory.InventoryView;
import org.jetbrains.annotations.NotNull;

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

    /**
     * @return InventoryGUI involved in this event
     */
    public InventoryGUI getInventoryGUI() {
        return this.gui;
    }

    /**
     * @return Player who clicked the button
     * @see <a href="https://papermc.io/javadocs/paper/1.17/org/bukkit/Player/package-summary.html">Player</a>
     */
    public Player getPlayer() {
        return this.player;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return handlers;
    }
}
