package tictactoe;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

import static java.lang.System.out;

public class Main {
    public static void main(String[] args) {
        String welcome = """
                *************************
                Welcome to this round of TicTacToe.
                *************************
                Player 1 starts and is 'X'.
                Select a square by entering 'x:y' coordinates.""";
        boolean gameInProgress = true;
        boolean inputControl = true;
        Scanner scanner = new Scanner(System.in);
        String input;
        char currentPlayer;
        int counter = 0;
        Logic logic = new Logic();
        HashMap<String, Integer> boardMap = logic.createBoardMap();


        char[] board = {'-', '-', '-', '-', '-', '-', '-', '-', '-'};

        out.println(welcome);

        while (gameInProgress) {
            if (counter % 2 == 0) {
                out.print("Player 1: ");
                currentPlayer = 'X';
            } else {
                out.print("Player 2: ");
                currentPlayer = 'O';
            }

            while (inputControl) {
                input = scanner.next();
                // Input should be x:y

                int choice = logic.handleInput(input, boardMap);

                if (choice < 0 || choice > 9) {
                    out.println("Error: Wrong input - Try again with x:y between 0 and 2");
                } else if (board[choice] != '-') {
                    out.println("Error: Square already marked by " + board[choice] + " - Try another square");
                } else {
                    board[choice] = currentPlayer;
                    inputControl = false;
                }
            }
            inputControl = true;

            out.println("-------------------");

            logic.printBoard(board);
            out.println("-------------------");

            // Check Win Condition
            char result = logic.checkWinCondition(board);
            if (result == 'X') {
                out.println("Player 1 as 'X' is the winner of the game!");
                gameInProgress = false;
            } else if (result == 'O') {
                out.println("Player 2 as 'O' is the winner of the game!");
                gameInProgress = false;
            }

            counter++;

            // End of game if no one wins
            if (counter > 8) {
                out.println("Game finished without a winner.. ");
                gameInProgress = false;
            }

            if (!gameInProgress) {
                out.println("Play again? Yes/No");
                String playAgain = scanner.next();
                if (playAgain.equalsIgnoreCase("yes")) {
                    gameInProgress = true;
                    // Clear the board
                    Arrays.fill(board, '-');
                    counter = 0;
                } else if (playAgain.equalsIgnoreCase("no")) {
                    out.println("Thank you for playing this simple TicTacToe - Have a nice day!");
                }
            }
        }
    }


}
