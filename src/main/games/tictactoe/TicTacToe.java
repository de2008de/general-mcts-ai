package main.games.tictactoe;

import main.games.Game;
import main.games.Player;
import main.games.State;
import main.games.Status;
import main.utils.Utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        this(new TicTacToeState(), Player.PLAYER1);
    }

    public TicTacToe(Player lastTurnPlayer) {
        this(new TicTacToeState(), lastTurnPlayer);
    }

    public TicTacToe(State state, Player lastTurnPlayer) {
        this.state = state;
        this.lastTurnPlayer = lastTurnPlayer;
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
    public Set<Integer> availableActions() {
        Set<Integer> actionsSet = new HashSet<>();
        for (int i = 0; i < state.getStateLength(); i++) {
            if (state.getPositionAt(i) == Player.EMPTY) {
                actionsSet.add(i);
            }
        }
        return actionsSet;
    }

    /**
     * Return null if the given action is invalid.
     *
     * @param action
     * @return
     */
    @Override
    public Game applyAction(int action) {
        if (!isActionValid(action)) {
            return null;
        }
        Player[] copyState = state.getStateCopy();
        copyState[action] = getNextTurnPlayer();
        return new TicTacToe(new TicTacToeState(copyState), getNextTurnPlayer());
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
        boolean isWin = true;
        for (int[] positions : winningPositions) {
            Player currentPosition = null;
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
        if (availableActions().isEmpty() && !isWin) {
            status = Status.END_TIE;
        } else {
            status = Status.IN_PROGRESS;
        }
    }

    @Override
    public void printState() {
        System.out.println("Player1: O");
        System.out.println("Player2: X");

        for (int i = 0; i < state.getStateLength(); i++) {
            Player player = state.getPositionAt(i);
            switch (player) {
                case PLAYER1:
                    System.out.print(" O ");
                    break;
                case PLAYER2:
                    System.out.print(" X ");
                    break;
                case EMPTY:
                    System.out.print("   ");
                    break;
            }

            if (i % 3 != 2) {
                System.out.print("|");
            }

            if (i % 3 == 2) {
                System.out.println("");
                if (i != 8) {
                    System.out.println("---+---+---");
                }
            }
        }
    }


    private boolean isActionValid(int action) {
        Set<Integer> availableActions = availableActions();
        return availableActions.contains(action);
    }
}
