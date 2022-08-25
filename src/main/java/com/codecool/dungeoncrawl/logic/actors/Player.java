package com.codecool.dungeoncrawl.logic.actors;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.items.Item;
import com.codecool.dungeoncrawl.logic.items.RedGate;
import com.codecool.dungeoncrawl.logic.items.YellowGate;

import java.util.ArrayList;
import java.util.List;

public class Player extends Actor {



    protected int level = 1;

    private final List<Item> inventory = new ArrayList<>();

    public Player(Cell cell) {
        super(cell);
        this.health = 10;
        this.damage = 3;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
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
        // Pick up item if player stands on it
        if (cell.getItem() != null) {
            if (!cell.getItem().isNeedToActivate()) {
                cell.getItem().interact(this);
            }
        }
        // if monster is on next cell then damage it
        Cell nextCell = cell.getNeighbor(dx, dy);
        if(nextCell.getActor() != null){
            int enemyHealth = nextCell.getActor().getHealth();
            nextCell.getActor().setHealth(enemyHealth - this.damage);
        }


        // if gate is on next cell then call its interact
        if (nextCell.getItem() instanceof RedGate || nextCell.getItem() instanceof YellowGate) {
            nextCell.getItem().interact(this);
        }
        // simple move
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
