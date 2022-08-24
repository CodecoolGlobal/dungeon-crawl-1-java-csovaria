package com.codecool.dungeoncrawl.logic.items;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.CellType;
import com.codecool.dungeoncrawl.logic.actors.Player;

public class RedGate extends Item{
    public RedGate(Cell cell) {
        super(cell);
    }



    @Override
    public void interact(Player player) {
        for (Item playersItem : player.getInventory()) {
            if (playersItem instanceof RedKey) {
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
        return "red_gate";
    }
}
