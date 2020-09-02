package main.games;

public interface Game {
    /**
     * Return the winner if game ends.
     * @return the winner
     */
    Player getWinner();

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
}
