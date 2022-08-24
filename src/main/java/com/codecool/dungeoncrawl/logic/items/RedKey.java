package com.codecool.dungeoncrawl.logic.items;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.actors.Player;

public class RedKey extends Item {

    private final int code = 666;

    public int getCode() {
        return code;
    }

    public RedKey(Cell cell) {
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
        return "red_key";
    }
}
