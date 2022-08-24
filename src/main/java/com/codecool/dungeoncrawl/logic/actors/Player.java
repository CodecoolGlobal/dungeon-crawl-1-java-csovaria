package com.codecool.dungeoncrawl.logic.actors;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.items.Item;

import java.util.ArrayList;
import java.util.List;

public class Player extends Actor {

    private final List<Item> inventory = new ArrayList<>();

    public Player(Cell cell) {
        super(cell);
    }

    @Override
    public void move() {

    }

    public String toString() {
        if (getSword() == 1) {
            return "playerWithSword";
        }
        return "player";
    }

    public void move(int dx, int dy) {
        Cell nextCell = cell.getNeighbor(dx, dy);
        if (nextCell.validatePlayerMove()){
            cell.setActor(null);
            nextCell.setActor(this);
            cell = nextCell;
            if (nextCell.getItem() != null){
                if (!nextCell.getItem().isNeedToActivate()) {
                    nextCell.getItem().interact(this);
                }
            }
        }
    }

    public void setInventory(Item item) {
        this.inventory.add(item);
    }

    public List<Item> getInventory() {
        return inventory;
    }
}
