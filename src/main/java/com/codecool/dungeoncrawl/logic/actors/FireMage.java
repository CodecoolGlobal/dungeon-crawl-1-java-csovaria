package com.codecool.dungeoncrawl.logic.actors;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.items.Fire;

public class FireMage extends Actor{

    private final int damage = 2;
    public FireMage(Cell cell) {
        super(cell);
    }

    @Override
    public void monsterMove() {
        castFire(cell.getNeighbor(0,1));
        castFire(cell.getNeighbor(0,-1));
        castFire(cell.getNeighbor(-1,0));
        castFire(cell.getNeighbor(-1,1));
        castFire(cell.getNeighbor(-1,-1));
        castFire(cell.getNeighbor(1,1));
        castFire(cell.getNeighbor(1,0));
        castFire(cell.getNeighbor(1,-1));
    }


    public String toString() {
        return "fire_mage";
    }

    private void castFire(Cell cell){
        if(cell.getItem() instanceof Fire){
            if(cell.getActor() instanceof Player){
                cell.getActor().setHealth(cell.getActor().getHealth() - damage);
            }
            cell.setItem(null);
        }else{
            new Fire(cell);
        }
    }
}
