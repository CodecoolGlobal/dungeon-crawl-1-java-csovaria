package com.codecool.dungeoncrawl.logic.items;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.CellType;
import com.codecool.dungeoncrawl.logic.actors.Player;

public class WinGate extends Item{

    public WinGate(Cell cell) {
        super(cell);
    }

    @Override
    public void interact(Player player) {
        player.setLevel(3);
    }

    @Override
    public boolean isNeedToActivate() {
        return false;
    }

    @Override
    public String toString() {
        return "win_gate";
    }
}
