package main.games.gomoku;

import main.games.Player;
import main.games.State;

public class GomokuState implements State {
    private static int boardSize = 15 * 15;
    private static Player[] defaultState;
    private final Player[] state;
    
    static {
        Player[] state = new Player[boardSize];
        for (int i = 0; i < state.length; i++) {
            state[i] = Player.EMPTY;
        }
        defaultState = state;
    }

    public GomokuState() {
        this(defaultState);
    }

    public GomokuState(Player[] state) {
        this.state = state;
    }

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
