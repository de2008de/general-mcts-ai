package main.games;

public interface Game {
    /**
     * Return the winner if game ends.
     * @return the winner
     */
    Player getWinner();

    Player getLastTurnPlayer();

    Player getNextTurnPlayer();

    /**
     * Return current game state.
     * @return the game state
     */
    State getState();

    /**
     * Return current game status.
     * E.g. IN_PROGRESS, END
     * @return
     */
    Status getStatus();

    int[] availableActions();

    Game applyAction(int action);

    void printState();
}
