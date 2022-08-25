package com.codecool.dungeoncrawl.logic.items;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.actors.Player;

public class GreenItem extends Item{
    public GreenItem(Cell cell) {
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
        return "green";
    }
}
