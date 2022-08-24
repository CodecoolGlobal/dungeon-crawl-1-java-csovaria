package com.codecool.dungeoncrawl.logic.items;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.actors.Actor;

import java.util.Random;

public class RandomBox extends Item{

    private final int value = 5;

    public RandomBox(Cell cell) {
        super(cell);
    }


    @Override
    public void interact(Actor actor) {
        int randomEffect = new Random().nextInt(2);
        if(randomEffect == 0){
            actor.setHealth(actor.getHealth() + value);
        } else {
            actor.setHealth(actor.getHealth() - value);
        }
        actor.getCell().setItem(null);
    }

    @Override
    public boolean isNeedToActivate() {
        return true;
    }

    @Override
    public String getTileName() {
        return "random";
    }
}
