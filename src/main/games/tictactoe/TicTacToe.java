package main.games.tictactoe;

import main.games.Game;
import main.games.Player;
import main.games.State;
import main.games.Status;

public class TicTacToe implements Game {

    private static int[][] winningPositions = {
            {0, 1, 2},
            {3, 4, 5},
            {6, 7, 8},
            {0, 3, 6},
            {1, 4, 7},
            {2, 5, 8},
            {0, 4, 8},
            {2, 4, 6}
    };

    private State state;
    private Status status;
    private Player winner;

    public TicTacToe() {
        this(new TicTacToeState());
    }

    public TicTacToe(State state) {
        this.state = state;
        updateStatus();
    }

    @Override
    public Player getWinner() {
        return winner;
    }

    @Override
    public State getState() {
        return state;
    }

    @Override
    public Status getStatus() {
        return status;
    }

    private void updateStatus() {
        // Check whether we have a winner
        for (int[] positions : winningPositions) {
            Player currentPosition = null;
            boolean isWin = true;
            for (int position : positions) {
                isWin = true;
                Player nextPosition = state.getPositionAt(position);
                if (currentPosition != null && currentPosition != nextPosition) {
                    isWin = false;
                    break;
                }
                currentPosition = nextPosition;
            }
            if (isWin) {
                winner = currentPosition;
            }
        }
    }
}
