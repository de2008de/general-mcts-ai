package main.mcts;

import main.games.Game;

/**
 *
 * @param <T> Type of action
 */
public interface MCTS<T> {
    T start();
    void updateGame(Game game);
}
