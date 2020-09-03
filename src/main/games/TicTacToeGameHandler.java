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


    public static void main(String[] args) {
        GameHandler gameHandler = new TicTacToeGameHandler();
        gameHandler.start();
    }

    @Override
    public void start() {
        // Initialize a game
        Game game = new TicTacToe();
        String goFirst = null;
        while (true) {
            System.out.println("Do you want to go first? y/n");
            goFirst = scanner.nextLine().toLowerCase();

            if (goFirst.equals("y") || goFirst.equals("n")) {
                break;
            }
        }

        if (goFirst.equals("y")) {
            currentPlayer = human;
        } else {
            currentPlayer = ai;
        }

        // Game starts from here
        while (game.getStatus() == Status.IN_PROGRESS) {
            if (currentPlayer == human) {
                while (true) {
                    System.out.println("Please choose an action.");
                    Utils.printArray(game.availableActions());
                    String userInput = scanner.nextLine();

                    try {
                        int action = Integer.valueOf(userInput);
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter a valid action number.");
                    }
                }
            } else if (currentPlayer == ai) {
                while (true) {
                    System.out.println("Please choose an action.");
                    Utils.printArray(game.availableActions());
                    String userInput = scanner.nextLine();

                    try {
                        int action = Integer.valueOf(userInput);
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter a valid action number.");
                    }
                }
            }
        }
    }
}
