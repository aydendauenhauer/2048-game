import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        boolean gameOver = false;
        boolean gameWin = false;
        boolean valid = true;
        String input = "";
        String in = "";

        // description of the game
        System.out.println("This game is called 2048. Your goal is to combine the same numbers until you get 2048. You have a 4x4 board to create this number. Use 'W' 'A' 'S' 'D' to move your numbers around.");
        System.out.println("If the board fills up, you lose. If you make 2048 before the board fills up, you win.");
        System.out.println("Do you want to play? (Y/N)");
        in = scan.nextLine();

        // checks if player wants to play
        if (in.equals("Y") || in.equals("y")) {
            TwentyFortyEight game = new TwentyFortyEight();
            game.getRandNum();
            game.getRandNum();
            game.printBoard();

            // uses for loop until game is won or lost
            for (int i = 0; i <= 1; i++) {
                while (valid) {
                    input = scan.nextLine();
                    //checks to make sure there is a valid input
                    if (!(input.equals("w") || input.equals("s") || input.equals("a") || input.equals("d") || (input.equals("W") || input.equals("S") || input.equals("A") || input.equals("D")))) {
                        System.out.println("Please enter a valid input.");
                        valid = true;
                    } else
                        valid = false;
                }

                // checks input of player and calls the correct method
                if (input.equals("w") || input.equals("W"))
                    game.moveW();
                else if (input.equals("s") || input.equals("S"))
                    game.moveS();
                else if (input.equals("a") || input.equals("A"))
                    game.moveA();
                else if (input.equals("d") || input.equals("D"))
                    game.moveD();

                // Updates the board and adds random number to the board
                game.getRandNum();
                System.out.println(); // extra space
                game.printBoard();
                valid = true;
                gameOver = game.gameOver();
                gameWin = game.gameWin();

                //keeps running till you lose or you win
                if ((gameOver) || (gameWin))
                    i++;
                else
                    i--;
            }
            // checks if player won or lost
            if (gameWin)
                System.out.println("You win!");
            else if (gameOver)
                System.out.println("You lost!");
        }
    }
}



