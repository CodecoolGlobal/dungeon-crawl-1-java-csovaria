package com.codecool.dungeoncrawl.logic.items;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.actors.Actor;
import com.codecool.dungeoncrawl.logic.actors.Player;

public class Sword extends Item {


    public Sword(Cell cell) {
        super(cell);
    }


    @Override
    public void interact(Player player) {
        player.setSword(1);
        player.getCell().setItem(null);
        player.setInventory(this);
    }

    @Override
    public boolean isNeedToActivate() {
        return true;
    }

    @Override
    public String toString() {
        return "sword";
    }
}