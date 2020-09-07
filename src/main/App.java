package main;

import main.games.GameHandler;
import main.games.tictactoe.TicTacToeGameHandler;

public class App {
    public static void main(String[] args) {
        GameHandler handler = new TicTacToeGameHandler();
        handler.start();
    }
}
