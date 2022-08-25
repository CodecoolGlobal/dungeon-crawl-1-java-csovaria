package com.codecool.dungeoncrawl.logic.items;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.actors.Player;

public class LevelGate extends Item{

    public LevelGate(Cell cell) {
        super(cell);
    }

    @Override
    public void interact(Player player) {
        player.setLevel(2);
    }

    @Override
    public boolean isNeedToActivate() {
        return false;
    }

    @Override
    public String toString() {
        return "level_gate";
    }
}
