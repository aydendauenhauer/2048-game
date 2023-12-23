import java.util.Scanner;

public class TwentyFortyEight {
    public final int ROWS = 4; // fixed # of rows
    public final int COLS = 4; // fixed # of cols

    // declaring variables
    private int[][] board;
    private Scanner scan;
    private int randRow;
    private int randCol;
    private int randNum;
    private int number = 1;
    private int num = 0;
    private int loc = 0;
    private boolean isTwo = false;
    private int add = 0;

    // creates a board (array) that is empty
    public TwentyFortyEight() {
        scan = new Scanner(System.in);
        board = new int[ROWS][COLS];
        for (int i = 0; i < ROWS; i++)
            for (int j = 0; j < COLS; j++)
                board[i][j] = 0;

    }

    // prints the board
    public void printBoard() {
        System.out.println("---------------2048 GAME---------------");
        System.out.println(board[0][0] + "|" + board[0][1] + "|" + board[0][2] + "|" + board[0][3]);
        System.out.println("------------");
        System.out.println(board[1][0] + "|" + board[1][1] + "|" + board[1][2] + "|" + board[1][3]);
        System.out.println("------------");
        System.out.println(board[2][0] + "|" + board[2][1] + "|" + board[2][2] + "|" + board[2][3]);
        System.out.println("------------");
        System.out.println(board[3][0] + "|" + board[3][1] + "|" + board[3][2] + "|" + board[3][3]);
        System.out.println("---------------------------------------");
    }

    // gets a random number (2 or 4) to add to a random spot on the board that is 0
    public void getRandNum() {
        boolean isValid = false;
        while (!isValid) {
            randRow = (int) (Math.random() * 4);
            randCol = (int) (Math.random() * 4);
            if (board[randRow][randCol] != 0)
                isValid = false;
            else
                isValid = true;
        }

        // generates random number to determine whether to add 2 or 4
        randNum = (int) (Math.random() * 4);
        if ((randNum == 0) || (randNum == 1))
            board[randRow][randCol] = 2;
        else
            board[randRow][randCol] = 4;
    }

    // determines if you won the game only if 2048 is on the board
    public boolean gameWin() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                if (board[row][col] == 2048) {
                    return true;
                }
            }
        }
        return false;
    }

    // determines if game is over by checking if board is full
    public boolean gameOver() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                if (board[row][col] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    // Method to move UP
    public void moveW() {
        // nested for loop to go through entire 2D array
        for (int col = 0; col < COLS; col++) {
            for (int row = 1; row < ROWS; row++) {
                loc = 0;
                number = 1;
                isTwo = false;

                // sets num equal to elements that are occupied
                if (board[row][col] != 0) {
                    num = board[row][col];

                    for (int i = 1; i < row; i++) {
                        if (board[row - i][col] == 0)
                            number++;
                    }
                    add = (row + 1) - number;

                    // checks if the values are the same, multiplies them by 2
                    if (board[row - number][col] == num) {
                        num = num * 2;
                        board[row - number][col] = num;
                        isTwo = true;
                    }

                    else if (board[row - number][col] != 0)
                        loc += add;

                    // uses boolean to change the element location, sets old location to 0
                    if (!isTwo)
                        board[loc][col] = num;
                    if (loc != row)
                        board[row][col] = 0;

                }
            }
        }
    }

    // Method to move LEFT
    public void moveA() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 1; col < COLS; col++) {
                loc = 0;
                number = 1;
                isTwo = false;

                if (board[row][col] != 0) {
                    num = board[row][col];

                    for (int i = 1; i < col; i++) {
                        if (board[row][col - i] == 0)
                            number++;
                    }
                    add = (col + 1) - number;

                    if (board[row][col - number] == num) {
                        num = num * 2;
                        board[row][col - number] = num;
                        isTwo = true;
                    } else if (board[row][col - number] != 0)
                        loc += add;

                    if (!isTwo)
                        board[row][loc] = num;
                    if (loc != col)
                        board[row][col] = 0;
                }
            }
        }
    }

    // Method to move DOWN
    public void moveS() {
        for (int col = 0; col < COLS; col++) {
            for (int row = 2; row >= 0; row--) {
                loc = 3;
                number = 3;
                isTwo = false;

                if (board[row][col] != 0) {
                    num = board[row][col];

                    for (int i = row + 1; i <= 3; i++) {
                        if (board[i][col] != 0) {
                            number = i;
                            i = 4;
                        }
                    }

                    if (board[number][col] == num) {
                        num = num * 2;
                        board[number][col] = num;
                        isTwo = true;
                    }
                    else if (board[number][col] != 0)
                        loc = (number - 1);

                    if (!isTwo)
                        board[loc][col] = num;
                    if (loc != row)
                        board[row][col] = 0;
                }
            }
        }
    }

    // Method to move RIGHT
    public void moveD() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 2; col >= 0; col--) {
                loc = 3;
                number = 3;
                isTwo = false;

                if (board[row][col] != 0) {
                    num = board[row][col];

                    for (int i = col + 1; i <= 3; i++) {
                        if (board[row][i] != 0) {
                            number = i;
                            i = 4;
                        }
                    }

                    if (board[row][number] == num) {
                        num = num * 2;
                        board[row][number] = num;
                        isTwo = true;
                    }
                    else if (board[row][number] != 0)
                        loc = (number - 1);

                    if (!isTwo)
                        board[row][loc] = num;
                    if (loc != col)
                        board[row][col] = 0;
                }
            }
        }
    }
}