package com.codecool.dungeoncrawl.logic.items;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.actors.Actor;

public class HealthPotion extends Item{

    private final int value = 5;

    public HealthPotion(Cell cell) {
        super(cell);
    }


    @Override
    public void interact(Actor actor) {
        actor.setHealth(actor.getHealth() + value);
        actor.getCell().setItem(null);
    }

    @Override
    public String getTileName() {
        return "health";
    }
}
