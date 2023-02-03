package company;
import java.util.Scanner;
import java.util.Random;

class Game 
{
    int s_input;
    int u_input;
    int numberOfGuess = 0;

    Game() 
    {
        Random random = new Random();
        this.s_input = random.nextInt(100) + 1;
    }

    public boolean takeUserInput()
    {
        if (numberOfGuess < 10)
        {
            System.out.print("Guess The Number: ");
            this.u_input = GuessTheNumber.takeIntegerInput(100);
            numberOfGuess++;
            return false;
        } else {
            System.out.println("Number of Attempts Are finished...\n");
            return true;
        }
    }

    public boolean isCorrectGuess()
    {
        if (s_input == u_input) {
            System.out.println("Congratulation,You guess The Right Number " + s_input + " in " + numberOfGuess + " guesses");
            switch (numberOfGuess) {
                case 1 -> System.out.println("Your Score is 100");
                case 2 -> System.out.println("Your Score is 90");
                case 3 -> System.out.println("Your Score is 80");
                case 4 -> System.out.println("Your Score is 70");
                case 5 -> System.out.println("Your Score is 60");
                case 6 -> System.out.println("Your Score is 50");
                case 7 -> System.out.println("Your Score is 40");
                case 8 -> System.out.println("Your Score is 30");
                case 9 -> System.out.println("Your Score is 20");
                case 10 -> System.out.println("Your Score is 10");
            }
            System.out.println();
            return true;
        } 
        else if (numberOfGuess < 10 && u_input > s_input)
        {
            if (u_input - s_input > 10) {
                System.out.println("Very High");
            } else {
                System.out.println("Tiny High");
            }
        } 
        else if ((numberOfGuess < 10) && (u_input < s_input))
        {
            if (s_input - u_input > 10) {
                System.out.println("Very low");
            } else {
                System.out.println("Tiny low");
            }
        }
        return false;
    }
}
public class GuessTheNumber
{
    public static int takeIntegerInput(int limit) {
        int input = 0;
        boolean flag = false;

        while (!flag)
        {
            try {
                Scanner S = new Scanner(System.in);
                input = S.nextInt();
                flag = true;

                if (flag && input > limit || input < 1) {
                    System.out.println("Choose the Number Between 1 To " + limit);
                    flag = false;
                }
            } catch (Exception e) {
                System.out.println("Enter an Interger Value");
                flag = false;
            }
        };
        return input;
    }

    public static void main(String[] args)
    {
        System.out.println("1. Start The Game \n2. Exit");
        System.out.println("Enter Your Choice: ");
        int Choise = takeIntegerInput(2);
        int nextRound = 1;
        int noOfRound = 0;
        
        if (Choise == 1)
        {
            while (nextRound == 1)
            {
                Game game = new Game();
                boolean isMatched = false;
                boolean isLimitCross = false;
                System.out.println("\nRound "+ ++noOfRound + " Starts....");
                
                while (!isMatched && !isLimitCross)
                {
                     isLimitCross = game.takeUserInput();
                     isMatched = game.isCorrectGuess();
                }
                
                System.out.println("1.Next Round1" +
                        "\n2.Exit");
                System.out.println("Enter Your Choice: ");
                nextRound = takeIntegerInput(2);
                if (nextRound != 1)
                {
                    System.exit(0);
                }
            }
        }
        else
        {
            System.exit(0);
        }
    }
}
