package com.codecool.dungeoncrawl.logic.actors;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.Drawable;

public abstract class Actor implements Drawable {
    protected Cell cell;

    public void setHealth(int health) {
        this.health = health;
    }

    private int health = 10;
    private int sword = 0;

    public Actor(Cell cell) {
        this.cell = cell;
        this.cell.setActor(this);
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
