package com.codecool.dungeoncrawl.logic.actors;

import com.codecool.dungeoncrawl.logic.Cell;

public class Skeleton extends Actor {
    public Skeleton(Cell cell) {
        super(cell);
        move();
    }

    public void move() {
            Cell nextCell = cell.getNeighbor(0, 3);
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
