package com.codecool.dungeoncrawl.logic.items;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.actors.Actor;

public class Sword extends Item {


    public Sword(Cell cell) {
        super(cell);
    }


    @Override
    public void interact(Actor actor) {
        actor.setSword(1);
        actor.getCell().setItem(null);
    }

    @Override
    public boolean isNeedToActivate() {
        return true;
    }

    @Override
    public String getTileName() {
        return "sword";
    }
}