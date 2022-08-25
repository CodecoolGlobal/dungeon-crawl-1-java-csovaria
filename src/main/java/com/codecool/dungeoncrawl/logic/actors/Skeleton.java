package com.codecool.dungeoncrawl.logic.actors;

import com.codecool.dungeoncrawl.logic.Cell;

import java.util.List;
import java.util.Random;

public class Skeleton extends Actor {


    public Skeleton(Cell cell) {
        super(cell);
        this.health = 10;
        this.damage = 3;
    }

    @Override
    public void monsterMove() {
        List<Cell> myNearbyCells = getNearbyCells(cell);
        boolean didAttack = false;
        for(Cell nearbyCell: myNearbyCells){
            if(nearbyCell.getActor() instanceof Player){
                int playersHealth = nearbyCell.getActor().getHealth();
                nearbyCell.getActor().setHealth(playersHealth - damage);
                didAttack = true;
            }
        }
        if(!didAttack){
            int randomDirection = new Random().nextInt(4);
            Cell nextCell= cell.getNeighbor(0, 1);
            switch (randomDirection) {
                case 0:
                    nextCell = cell.getNeighbor(0, 1);
                    break;
                case 1:
                    nextCell = cell.getNeighbor(0, -1);
                    break;
                case 2:
                    nextCell = cell.getNeighbor(1, 0);
                    break;
                case 3:
                    nextCell = cell.getNeighbor(-1, 0);
                    break;
            }
            if (nextCell.validatePlayerMove()) {
                cell.setActor(null);
                nextCell.setActor(this);
                cell = nextCell;
            }
        }

    }



    public String toString() {
        return "skeleton";
    }
}
