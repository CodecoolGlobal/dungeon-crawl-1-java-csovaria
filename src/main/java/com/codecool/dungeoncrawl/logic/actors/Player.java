package com.codecool.dungeoncrawl.logic.actors;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.items.Item;
import com.codecool.dungeoncrawl.logic.items.RedGate;

import java.util.ArrayList;
import java.util.List;

public class Player extends Actor {

    private final List<Item> inventory = new ArrayList<>();

    public Player(Cell cell) {
        super(cell);
    }

    @Override
    public void monsterMove() {

    }

    public String toString() {
        if (getSword() == 1) {
            return "playerWithSword";
        }
        return "player";
    }

    public void move(int dx, int dy) {

        if (cell.getItem() != null) {
            if (!cell.getItem().isNeedToActivate()) {
                cell.getItem().interact(this);
            }
        }


        Cell nextCell = cell.getNeighbor(dx, dy);
        if (nextCell.getItem() instanceof RedGate) {
            nextCell.getItem().interact(this);
        }
        if (nextCell.validatePlayerMove()) {
            cell.setActor(null);
            nextCell.setActor(this);
            cell = nextCell;
        }
    }



    public void setInventory(Item item) {
        this.inventory.add(item);
    }

    public List<Item> getInventory() {
        return inventory;
    }
}
