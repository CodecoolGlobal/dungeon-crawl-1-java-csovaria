package com.codecool.dungeoncrawl.logic.actors;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.Drawable;
import com.codecool.dungeoncrawl.logic.items.Item;

import java.util.ArrayList;
import java.util.List;

public abstract class Actor implements Drawable {
    protected Cell cell;

    public void setHealth(int health) {
        this.health = health;
    }

    protected int health;
    private int sword = 0;
    protected int damage;

    public Actor(Cell cell) {
        this.cell = cell;
        this.cell.setActor(this);
    }

    public abstract void monsterMove();

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public List<Cell> getNearbyCells(Cell myCell){
        List<Cell> nearbyCells = new ArrayList<>();
        nearbyCells.add(myCell.getNeighbor(0,0));
        nearbyCells.add(myCell.getNeighbor(0,-1));
        nearbyCells.add(myCell.getNeighbor(-1,0));
        nearbyCells.add(myCell.getNeighbor(-1,1));
        nearbyCells.add(myCell.getNeighbor(-1,-1));
        nearbyCells.add(myCell.getNeighbor(1,1));
        nearbyCells.add(myCell.getNeighbor(1,0));
        nearbyCells.add(myCell.getNeighbor(1,-1));
        return nearbyCells;
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

    public boolean isDead(Actor actor) {
        if(actor.health <= 0){
             return true;
        }
        return false;
    }

    public void kill() {
        this.cell.setActor( null);
    }
}
