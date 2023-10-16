
// Util package consists of Scanner and Random classes
import java.util.*;

class RandomCheck {
    void check(Scanner s) {

        // Generating a random number
        Random r = new Random();
        int randomNum = r.nextInt(100) + 1;

        // To keep track of number of attempts
        int attempts = 0;
        boolean flag = false;

        System.out.println("A random number has been generated between 1 to 100");

        while (flag != true && attempts < 10) {

            System.out.println("Guess the number : ");
            int num = s.nextInt();
            attempts++;

            if (randomNum == num) {
                System.out.println("Correct guess!!");
                System.out.println("Number of attempts taken : " + attempts);
                System.out.println("Score : " + ((10 - attempts) * 100) / 10);
                flag = true;
            } else if (randomNum < num) {
                System.out.println("Too high");
            } else if (randomNum > num) {
                System.out.println("Too low");
            } else {
                System.out.println("Enter a valid number");
            }
        }

        if (attempts >= 10) {
            System.out.println("Maximum chances reached");
            System.out.println("The number is " + randomNum);
        }

    }
}

public class RandomNumber {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        RandomCheck rc = new RandomCheck();
        int choice = 1;

        while (choice == 1) {
            rc.check(s);

            System.out.println("Do you want to play again?(Select 1 if yes)");
            choice = s.nextInt();
        }
        s.close();
    }
}
