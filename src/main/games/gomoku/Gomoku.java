package main.games.gomoku;

import main.games.Game;
import main.games.Player;
import main.games.State;
import main.games.Status;

import java.util.Set;

public class Gomoku implements Game {
    private State state;
    private Player lastTurnPlayer;

    public Gomoku() {
        this(new GomokuState());
    }

    public Gomoku(State state) {
        this(state, Player.PLAYER1);
    }

    public Gomoku(State state, Player lastTurnPlayer) {
        this.state = state;
        this.lastTurnPlayer = lastTurnPlayer;
    }

    @Override
    public Player getWinner() {
        return null;
    }

    @Override
    public Player getLastTurnPlayer() {
        return null;
    }

    @Override
    public Player getNextTurnPlayer() {
        return null;
    }

    @Override
    public State getState() {
        return null;
    }

    @Override
    public Status getStatus() {
        return null;
    }

    @Override
    public Set<Integer> availableActions() {
        return null;
    }

    @Override
    public Game applyAction(int action) {
        return null;
    }

    @Override
    public void printState() {

    }
}
