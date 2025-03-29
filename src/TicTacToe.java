import java.util.Scanner;

public class TicTacToe {
    private static final int ROW = 3;

    private static final int COL = 3;

    private static String board[][] = new String[ROW][COL];

    public static void main(String[] args) {
        int row = 0;
        int col = 0;
        int moveCount = 0;
        boolean stillPlaying = true;
        String player = "";
        Scanner in = new Scanner(System.in);
        clearBoard();
        player = "X";
        do {
            do {
                display();
                System.out.println("What's your move, " + player + "?");
                row = SafeInput.getRangedInt(in, "Enter row", 1, 3) - 1;
                col = SafeInput.getRangedInt(in, "Enter col", 1, 3) - 1;
            } while (!isValidMove(row, col));
            board[row][col] = player;
            moveCount++;

            switch (player) { // toggle player
                case "O":
                    player = "X";
                    break;
                default:
                    player = "O";
                    break;
            }
        } while (!stillPlaying);

    }



    private static void clearBoard() { // all board spaces are empty!
        { for (int row = 0; row < ROW; row++) {
            for (int col = 0; col < COL; col++){
                board[row][col] = " "; // clears space
            }
            System.out.println();
        }
    } }

    private static void display() { // shows game as it's played. :)
             for (int row = 0; row < ROW; row++) {
                System.out.print("| ");
                for (int col = 0; col < COL; col++){
                    System.out.print(board[row][col] + " | "); }

                System.out.println("");}
        }



        private static boolean isValidMove(int row, int col) { // this checks if a player is in the same spot as requested move
        boolean areYouThere = false; // just a funny variable name to check if a player has already claimed that move
            if (board[row][col] == "X" || board[row][col] == "O") {
                areYouThere = true;
            }
        return areYouThere;
    }

    private static boolean isWin(String player) { // goes through all win classes to make sure all are false (or if one is true!)
return false;
    }

    private static boolean isColWin(String player) { // checks columns for win
return false;
    }

    private static boolean isRowWin(String player) { // checks rows for win
return false;
    }

    private static boolean isDiagnalWin (String player) { // checks for diagnal win (hard coded)
return false;
    }

    private static boolean isTie() { // checks for ties!
return false;
    }
}