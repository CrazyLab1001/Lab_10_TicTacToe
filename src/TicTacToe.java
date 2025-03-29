import java.util.Scanner;

public class TicTacToe {
    private static final int ROW = 3;

    private static final int COL = 3;

    private static String board[][] = new String[ROW][COL];

    public static void main(String[] args) {
        int row = 0;
        int col = 0;
        int moveCount = 0;
        boolean done = false;
        boolean gameOver = false;
        String player = "";
        Scanner in = new Scanner(System.in);
        do { // program loop
            clearBoard();
            player = "X";
            do { // game loop
                do {
                    display();
                    System.out.println("What's your move, " + player + "?");
                    row = SafeInput.getRangedInt(in, "Enter row", 1, 3) - 1;
                    col = SafeInput.getRangedInt(in, "Enter col", 1, 3) - 1;
                } while (!isValidMove(row, col)); // keeps loop if invalid move
                board[row][col] = player;
                moveCount++;

                if (moveCount > 4) {
                    gameOver = isWin(player);
                    if (gameOver == true) {
                        display();
                        System.out.println("Congrats, " + player + ", You win!"); }
                }
                if (moveCount > 6) {
                    gameOver = isTie();
                    if (gameOver == true) {
                        display();
                        System.out.println("Aw! It's a tie!"); }
                }
                if (player == "X") {
                    player = "O";
                } else {
                    player = "X";
                }

            } while (!gameOver);

                done = SafeInput.getYNConfirm(in, "Play again? [Y/N]");
        } while (!done);

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
        boolean isValidMove = true;
            if (board[row][col] == "X" || board[row][col] == "O") {
                isValidMove = false;
            }
        return isValidMove;
    }

    private static boolean isWin(String player) { // goes through all win classes to make sure all are false (or if one is true!)
        if (isColWin(player) || isDiagonalWin(player) || isRowWin(player)) {
            return true;
        }
        return false;
    }

    private static boolean isColWin(String player) { // checks columns for win
        for (int col = 0; col < COL; col++){
            if (board[col][0].equals(player) && board[col][1].equals(player) && board[col][2].equals(player)) {
                return true;
            }
        }
return false; }


    private static boolean isRowWin(String player) { // checks rows for win
        for (int row = 0; row < ROW; row++){
            if (board[row][0].equals(player) && board[row][1].equals(player) && board[row][2].equals(player)) {
                return true;
            }}
return false;
    }

    private static boolean isDiagonalWin(String player) { // checks for diagnal win (hard coded)
        if (board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player)) {
            return true;
            }
        if (board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player)) {
            return true;
        }
        return false;}


    private static boolean isTie() {// checks for ties!
        for (int row = 0; row < ROW; row++) {
            for (int col = 0; col < COL; col++) {
                if (board[row][col] == "X" || board[row][col] == "O")
                return false;
            }
        }
    return true;}



}