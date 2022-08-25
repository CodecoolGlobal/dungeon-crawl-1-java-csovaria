package com.codecool.dungeoncrawl.logic.items;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.CellType;
import com.codecool.dungeoncrawl.logic.actors.Player;

public class YellowGate extends Item{
    public YellowGate(Cell cell) {
        super(cell);
    }

    @Override
    public void interact(Player player) {
        for (Item playersItem : player.getInventory()) {
            if (playersItem instanceof YellowKey) {
                this.getCell().setType(CellType.FLOOR);
            }
        }
    }

    @Override
    public boolean isNeedToActivate() {
        return false;
    }

    @Override
    public String toString() {
        return "yellow_gate";
    }
}
