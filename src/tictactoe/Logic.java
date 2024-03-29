package tictactoe;

import java.util.HashMap;

import static java.lang.System.out;

public class Logic {
    public Logic() {
        // Empty constructor
    }

    public char checkWinCondition(char[] board) {
        /*
        We have win conditions on
        - rows
        - columns
        - diagonals

        Array is 1 dimensional where
        0,1,2 is first row,
        3,4,5 is next,
        6,7,8 is last row.

        0,3,6 is first column,
        1,4,7 is next,
        2,5,8 is last column.

        0,4,8 is first diagonal,
        6,4,2 is second diagonal.
         */

        for (int i = 0; i < board.length; i += 3) {
            if (board[i] == '-') {
                // Do nothing.
            } else if (board[i] == board[i + 1] && board[i + 1] == board[i + 2]) {
                return board[i];
            }
        }

        for (int i = 0; i < 3; i++) {
            if (board[i] == '-') {
                // Do nothing.
            } else if (board[i] == board[i + 3] && board[i + 3] == board[i + 6]) {
                return board[i];
            }
        }

        if (board[0] == '-') {
            // Do nothing.
        } else if (board[0] == board[4] && board[4] == board[8]) {
            return board[0];
        } else if (board[6] == board[4] && board[4] == board[2]) {
            return board[2];
        }

        return '-';
    }
    public HashMap<String, Integer> createBoardMap() {
        HashMap<String, Integer> boardMapping = new HashMap<String, Integer>();

        boardMapping.put("0:0", 0);
        boardMapping.put("0:1", 1);
        boardMapping.put("0:2", 2);
        boardMapping.put("1:0", 3);
        boardMapping.put("1:1", 4);
        boardMapping.put("1:2", 5);
        boardMapping.put("2:0", 6);
        boardMapping.put("2:1", 7);
        boardMapping.put("2:2", 8);
        return boardMapping;
    }
    public void printBoard(char[] board) {
        for (int i = 0; i < board.length; i++) {
            if (i % 3 == 0 && i != 0) {
                out.println("|");
            }
            out.print("| " + board[i] + " ");
        }
        out.println("|");
    }
    public int handleInput(String input, HashMap<String, Integer> boardMapping) {
        int pos = -1;
        if (boardMapping.containsKey(input)) {
            pos = boardMapping.get(input);
        }
        return pos;
    }
}
