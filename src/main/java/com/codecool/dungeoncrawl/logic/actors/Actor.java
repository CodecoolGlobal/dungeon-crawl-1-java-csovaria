package com.codecool.dungeoncrawl.logic.actors;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.Drawable;
import com.codecool.dungeoncrawl.logic.items.Item;

import java.util.ArrayList;
import java.util.List;

public abstract class Actor implements Drawable {
    private Cell cell;

    public void setHealth(int health) {
        this.health = health;
    }

    private int health = 10;
    private int sword = 0;

    public Actor(Cell cell) {
        this.cell = cell;
        this.cell.setActor(this);
    }

    public void move(int dx, int dy) {
        Cell nextCell = cell.getNeighbor(dx, dy);
        if (nextCell.validatePlayerMove()){
            cell.setActor(null);
            nextCell.setActor(this);
            cell = nextCell;
            if (nextCell.getItem() != null){
                if (!nextCell.getItem().isNeedToActivate() && this instanceof Player) {
                    nextCell.getItem().interact((Player) this);
                }
            }
        }
    }

    public int getHealth() {
        return
                health;
    }

    public Cell getCell() {
        return cell;
    }

    public int getX() {
        return cell.getX();
    }

    public int getY() {
        return cell.getY();
    }

    public void setSword(int sword) {
        this.sword = sword;
    }

    public int getSword() {
        return sword;
    }
}
