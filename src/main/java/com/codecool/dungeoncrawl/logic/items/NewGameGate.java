package com.codecool.dungeoncrawl.logic.items;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.actors.Player;

public class NewGameGate extends Item{

    public NewGameGate(Cell cell) {
        super(cell);
    }

    @Override
    public void interact(Player player) {
        player.setLevel(9);
    }

    @Override
    public boolean isNeedToActivate() {
        return true;
    }

    @Override
    public String toString() {
        return "new_game_gate";
    }
}
