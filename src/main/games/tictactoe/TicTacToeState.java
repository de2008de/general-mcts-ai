package main.games.tictactoe;

import main.games.Player;
import main.games.State;

public class TicTacToeState implements State {
    // Todo: We can use generics for state array


    private static int boardSize = 9;

    // Initialize default state
    static {
        Player[] state = new Player[boardSize];
        for (int i = 0; i < state.length; i++) {
            state[i] = Player.EMPTY;
        }
        defaultState = state;
    }
    private static Player[] defaultState;

    private final Player[] state;

    public TicTacToeState() {
        this(defaultState);
    }

    public TicTacToeState(Player[] state) {
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
}
