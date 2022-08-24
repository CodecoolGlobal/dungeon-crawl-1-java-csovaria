package com.codecool.dungeoncrawl.logic.items;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.actors.Player;

public class Fire extends Item {


    private final int damage = 2;

    public Fire(Cell cell) {
        super(cell);
    }


    @Override
    public void interact(Player player) {
        player.setHealth(player.getHealth() - damage);
    }

    @Override
    public boolean isNeedToActivate() {
        return false;
    }

    @Override
    public String toString() {
        return "fire";
    }
}
