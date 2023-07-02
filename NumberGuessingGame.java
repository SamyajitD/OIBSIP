//Task 2-Number Guessing Game
//package NumberGuesingGame

import java.util.*;

public class NumberGuessingGame {

    static Scanner sc = new Scanner(System.in);
    int randomNumber;
    int scoreAllotted;
    int round;
    Map<Integer, Integer> scoreBoard;

    public NumberGuessingGame() {
        randomNumber = 0;
        scoreAllotted = 0;
        round = 1;
        scoreBoard = new HashMap<>();
    }

    public static void main(String[] args) {
        System.out.println("Hey There!!\nWanna Play a Game with Me!!\n");
        while (true) {
            try {
                // For First Time Play
                System.out.println("Press\n\n1 . Sure Lets Plays!\t2 . Not Right Now\n");
                NumberGuessingGame guessGame = new NumberGuessingGame();
                int play = sc.nextInt();
                switch (play) {
                    case 1:
                        System.out.println("Great\n");
                        // Explanation of the Game
                        System.out.println("____________________________________________________");
                        System.out.println(
                                "I Will Choose A Number You Will Have To Guess It!!\n");
                        System.out.println(
                                "You will have a total of & attempts.\n\nDon't Worry I will help you along the way haha.\n");
                        System.out.println("____________________________________________________\n");
                        System.out.println("Now lets Begin.\n");
                        guessGame.getRandomNumber();
                        guessGame.game();
                        break;
                    case 2:
                        System.out.println("Oh Thats Too Bad. See You Later Then !!\n");
                        guessGame.exit();
                        break;
                    default:
                        throw new InputMismatchException("Invalid Choice!! Please Try Again");
                }
            } catch (InputMismatchException e) {
                System.err.println("\n" + e.getMessage() + "\n\n");

            }
        }

    }

    // Main Game
    public void game() {
        scoreAllotted = 10;
        while (scoreAllotted > 3) {
            System.out.println("Enter The Number You Have Guessed");
            int num = sc.nextInt();
            if (num == randomNumber) {
                System.out.println("CONGRATS!! You Guessed Right");
                scoreBoard.put(round, scoreAllotted);
                break;
            }
            if (num > randomNumber) {
                System.out.println("Guess Lower");
            } else {
                System.out.println("Guess Higher");
            }

            scoreAllotted--; // score is deduced for every wrong attempt
        }
        if (scoreAllotted == 3) {
            System.out.println("\nSeems Like I Win This Roung Haha.\n");
            scoreBoard.put(round, 0);
        }
        round++;
        menu();
    }

    // Menu for what to do next
    public void menu() {

        try {
            System.out.println("What Would you like to do!!");
            System.out.println("1 . Play Again!");
            System.out.println("2 . View ScoreBoard");
            System.out.println("3 . Exit");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    getRandomNumber();
                    game();
                    break;
                case 2:
                    getScoreBoard();
                    menu();
                    break;
                case 3:
                    System.out.println("Thank You For Playing");
                    exit();
                default:
                    throw new InputMismatchException("Invalid Choice!\n");
            }
        } catch (InputMismatchException e) {
            System.err.println("\n" + e.getMessage() + "\n");
            menu();
        }

    }

    // to generate the random number in user input bounds
    public void getRandomNumber() {
        System.out.println("Enter The Upper Limit For The Mysterious Number (i.e. form 1-X )");
        int range = sc.nextInt();
        Random generator = new Random();
        randomNumber = generator.nextInt(range) + 1;
    }

    // to view ScoreBoard
    public void getScoreBoard() {
        System.out.println("\tScoreBoard!!\n");
        System.out.println("\tRound\tScore");
        scoreBoard.forEach((k, v) -> System.out.println("\t  " + k + "\t  " + v));
        System.out.println();
    }

    // exits the program
    public void exit() {
        sc.close();
        System.exit(0);
    }

}
