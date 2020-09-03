package main.games.tictactoe;

import main.games.Game;
import main.games.Player;
import main.games.State;
import main.games.Status;
import main.utils.Utils;

import java.util.ArrayList;
import java.util.List;

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

    private final State state;
    private Status status;
    private Player winner;
    private Player lastTurnPlayer;

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
    public Player getLastTurnPlayer() {
        return lastTurnPlayer;
    }

    @Override
    public Player getNextTurnPlayer() {
        if (getLastTurnPlayer() == Player.PLAYER1) {
            return Player.PLAYER2;
        } else {
            return Player.PLAYER1;
        }
    }

    @Override
    public int[] availableActions() {
        List<Integer> actionsList = new ArrayList<>();
        for (int i = 0; i < state.getStateLength(); i++) {
            if (state.getPositionAt(i) == Player.EMPTY) {
                actionsList.add(i);
            }
        }
        return Utils.listToArray(actionsList);
    }

    @Override
    public Game applyAction(int action) {
        Player[] copyState = state.getStateCopy();
        // Todo: validate the action

        copyState[action] = getNextTurnPlayer();
        return new TicTacToe(new TicTacToeState(copyState));
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
                if (currentPosition == Player.EMPTY || (currentPosition != null && currentPosition != nextPosition)) {
                    isWin = false;
                    break;
                }
                currentPosition = nextPosition;
            }
            if (isWin) {
                winner = currentPosition;
                status = Status.END;
                return;
            }
        }
        status = Status.IN_PROGRESS;
    }

    @Override
    public void printState() {

    }
}
