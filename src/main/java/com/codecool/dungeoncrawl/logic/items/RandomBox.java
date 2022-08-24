package com.codecool.dungeoncrawl.logic.items;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.actors.Actor;
import com.codecool.dungeoncrawl.logic.actors.Player;

import java.util.Random;

public class RandomBox extends Item{

    private final int value = 5;

    public RandomBox(Cell cell) {
        super(cell);
    }


    @Override
    public void interact(Player player) {
        int randomEffect = new Random().nextInt(2);
        if(randomEffect == 0){
            player.setHealth(player.getHealth() + value);
        } else {
            player.setHealth(player.getHealth() - value);
        }
        player.getCell().setItem(null);
    }

    @Override
    public boolean isNeedToActivate() {
        return true;
    }

    @Override
    public String toString() {
        return "random";
    }
}
