package com.codecool.dungeoncrawl.logic.items;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.actors.Player;

public class YellowKey extends Item {


    public YellowKey(Cell cell) {
        super(cell);
    }

    @Override
    public void interact(Player player) {
        player.getCell().setItem(null);
        player.setInventory(this);
    }

    @Override
    public boolean isNeedToActivate() {
        return true;
    }

    @Override
    public String toString() {
        return "yellow_key";
    }
}