package com.codecool.dungeoncrawl.logic.items;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.actors.Actor;
import com.codecool.dungeoncrawl.logic.actors.Player;

public class HealthPotion extends Item{

    private final int value = 5;

    public HealthPotion(Cell cell) {
        super(cell);
    }


    @Override
    public void interact(Player player) {
        player.setHealth(player.getHealth() + value);
        player.getCell().setItem(null);
    }

    @Override
    public boolean isNeedToActivate() {
        return false;
    }

    @Override
    public String toString() {
        return "health";
    }
}
