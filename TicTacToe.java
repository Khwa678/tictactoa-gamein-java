import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {
        char[][] board = new char[3][3];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = ' ';
            }
        }

        char player = 'X';
        boolean gameOver = false;
        Scanner scanner = new Scanner(System.in);

        while (!gameOver) {
            printBoard(board);
            System.out.println("Player " + player + " enter row and column (0-2):");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            // Check if the input is valid
            if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ') {
                // Place the element
                board[row][col] = player;
                gameOver = haveWon(board, player);

                if (gameOver) {
                    printBoard(board);
                    System.out.println("Player " + player + " has won!");
                } else {
                    // Switch player
                    player = (player == 'X') ? 'O' : 'X';
                }
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }
    }

    public static boolean haveWon(char[][] board, char player) {
        // Check rows, columns, and diagonals
        for (int row = 0; row < 3; row++) {
            if (board[row][0] == player && board[row][1] == player && board[row][2] == player) {
                return true;
            }
        }

        for (int col = 0; col < 3; col++) {
            if (board[0][col] == player && board[1][col] == player && board[2][col] == player) {
                return true;
            }
        }

        // Check diagonals
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }

        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }

        return false;
    }

    public static void printBoard(char[][] board) {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                System.out.print(board[row][col] + " | ");
            }
            System.out.println();
        }
    }
}
