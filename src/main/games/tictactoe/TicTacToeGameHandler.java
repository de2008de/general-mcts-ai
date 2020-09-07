package main.games.tictactoe;

import main.games.Game;
import main.games.GameHandler;
import main.games.Player;
import main.games.Status;
import main.mcts.MCTS;
import main.mcts.PureMCTS;
import main.utils.Utils;

import java.util.Scanner;

public class TicTacToeGameHandler implements GameHandler {
    private static Scanner scanner = new Scanner(System.in);

    // Let human player be Player1
    private Player human = Player.PLAYER1;
    private Player ai = Player.PLAYER2;
    private Player currentPlayer;
    private Game game;
    private MCTS<Integer> mcts;

    @Override
    public void start() {
        String goFirst = null;
        while (true) {
            System.out.println("Do you want to go first? y/n");
            goFirst = scanner.nextLine().toLowerCase();

            if (goFirst.equals("y") || goFirst.equals("n")) {
                break;
            }
        }
        // Initialize a game
        Player previousPlayer = null;
        if (goFirst.equals("y")) {
            currentPlayer = human;
            previousPlayer = ai;
        } else {
            currentPlayer = ai;
            previousPlayer = human;
        }
        game = new TicTacToe(previousPlayer);
        mcts = new PureMCTS(game);

        // Game starts from here
        while (game.getStatus() == Status.IN_PROGRESS) {
            game.printState();
            currentPlayer = game.getNextTurnPlayer();
            if (currentPlayer == human) {
                while (true) {
                    System.out.println("Please choose an action.");
                    Utils.printSet(game.availableActions());
                    String userInput = scanner.nextLine();

                    try {
                        int action = Integer.valueOf(userInput);
                        Game newGame = game.applyAction(action);
                        if (newGame == null) {
                            System.out.println("Please enter a valid action number.");
                            continue;
                        }
                        game = newGame;
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter a valid action number.");
                    }
                }
            } else if (currentPlayer == ai) {
                System.out.println("AI is thinking...");
                mcts.updateGame(game);
                int action = mcts.start();
                game = game.applyAction(action);
            }
        }

        if (game.getStatus() == Status.END) {
            System.out.println("Game finishes.");
            Player winner = game.getWinner();
            System.out.println("The winner is " + winner + ".");
        }
    }
}
