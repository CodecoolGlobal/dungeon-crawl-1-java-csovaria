package com.codecool.dungeoncrawl.logic.items;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.actors.Player;

public class BlueItem extends Item{
    public BlueItem(Cell cell) {
        super(cell);
    }

    @Override
    public void interact(Player player) {

    }

    @Override
    public boolean isNeedToActivate() {
        return false;
    }

    @Override
    public String toString() {
        return "blue";
    }
}
