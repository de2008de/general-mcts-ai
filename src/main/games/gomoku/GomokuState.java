package main.games.gomoku;

import main.games.Player;
import main.games.State;

public class GomokuState implements State {
    private static int boardHeight = 15;
    private static int boardWidth = 15;
    private static int boardSize = boardHeight * boardWidth;
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
        return state[index];
    }

    @Override
    public Player[] getStateCopy() {
        return state.clone();
    }

    @Override
    public int getStateLength() {
        return state.length;
    }

    public static int getBoardWidth() {
        return boardWidth;
    }
}
