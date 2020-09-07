package main.games.gomoku;

import main.games.Player;
import main.games.State;

public class GomokuState implements State {
    @Override
    public Player getPositionAt(int index) {
        return null;
    }

    @Override
    public Player[] getStateCopy() {
        return new Player[0];
    }

    @Override
    public int getStateLength() {
        return 0;
    }
}
