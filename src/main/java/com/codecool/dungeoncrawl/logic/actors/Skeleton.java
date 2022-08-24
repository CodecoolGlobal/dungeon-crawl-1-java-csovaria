package com.codecool.dungeoncrawl.logic.actors;

import com.codecool.dungeoncrawl.logic.Cell;

public class Skeleton extends Actor {
    public Skeleton(Cell cell) {
        super(cell);
    }

    @Override
    public void monsterMove() {
        Cell nextCell = cell.getNeighbor(0, 1);
        if (nextCell.validatePlayerMove()) {
            cell.setActor(null);
            nextCell.setActor(this);
            cell = nextCell;
        }
    }


    public String toString() {
        return "skeleton";
    }
}
