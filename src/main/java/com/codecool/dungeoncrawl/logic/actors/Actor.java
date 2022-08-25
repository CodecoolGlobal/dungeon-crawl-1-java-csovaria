package com.codecool.dungeoncrawl.logic.actors;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.Drawable;
import com.codecool.dungeoncrawl.logic.items.Fire;
import com.codecool.dungeoncrawl.logic.items.HealthPotion;
import com.codecool.dungeoncrawl.logic.items.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
        if (actor.health <= 0) {
            return true;
        }
        return false;
    }

    public void kill() {
        this.cell.setActor(null);
        dropLoot(this.cell);
    }

    private void dropLoot(Cell cell) {
        int luckyLoot = new Random().nextInt(3);
        if (luckyLoot == 0) {
            new HealthPotion(cell);
        }
    }
}
