package main.games.tictactoe;

import main.games.Player;
import main.games.State;

public class TicTacToeState extends State {
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

    private Player[] state;

    public TicTacToeState() {
        this(defaultState);
    }

    public TicTacToeState(Player[] state) {
        this.state = state;
    }

    public Player getPositionAt(int index) {
        return state[index];
    }
}
