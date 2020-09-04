package main.games;

import main.games.tictactoe.TicTacToe;
import main.utils.Utils;

import java.util.Scanner;

public class TicTacToeGameHandler implements GameHandler {
    private static Scanner scanner = new Scanner(System.in);

    // Let human player be Player1
    private Player human = Player.PLAYER1;
    private Player ai = Player.PLAYER2;
    private Player currentPlayer;
    private Game game;


    public static void main(String[] args) {
        GameHandler gameHandler = new TicTacToeGameHandler();
        gameHandler.start();
    }

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

        // Game starts from here
        while (game.getStatus() == Status.IN_PROGRESS) {
            game.printState();
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
            }
        }

        if (game.getStatus() == Status.END) {
            System.out.println("Game finishes.");
            Player winner = game.getWinner();
            System.out.println("The winner is " + winner + ".");
        }
    }
}
