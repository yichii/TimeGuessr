import java.time.*;
import java.util.Scanner;
import java.util.Random;

public class Game {
    public void menu() {
        do {
            Scanner menuScanner = new Scanner(System.in);
            int selection;
            System.out.println("1. Start Game");
            System.out.println("2. Change Difficulty");
            System.out.println("3. Show Highscore");
            System.out.println("4. Reset Highscore");
            System.out.println("5. Exit");
            selection = menuScanner.nextInt();

            switch (selection) {
                case 1:
                    this.start();
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    System.out.println("Thanks for playing!");
                    break;
                default:
                    break;
            }
        } while (true);
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        LocalDate answer = LocalDate.of(random.nextInt(2025), random.nextInt(12) + 1, random.nextInt(30) + 1);
        LocalDate guess;
        int year, month, day, guessCount = 1;
        System.out.print("Guess the date! Enter a year: ");
        do {
            while (true) { // user input validation for year
                if (scanner.hasNextInt()) { // checks for whether user input is int
                    year = scanner.nextInt();
                    break;
                } else { // prompts user to enter input again if not
                    System.out.print("Please enter a valid year: ");
                    scanner.next(); // consumes input with incorrect type and goes next
                }
            }
            System.out.print("Enter a month: ");
            while (true) { // user input validation for month
                if (scanner.hasNextInt()) { // checks for whether user input is int
                    month = scanner.nextInt();
                    if (month >= 1 && month <= 12) {
                        break;
                    } else {
                        System.out.print("Please enter a valid month(1-12): ");
                    }
                } else { // prompts user to enter input again if not
                    System.out.print("Please enter a valid month: ");
                    scanner.next(); // consumes input with incorrect type and goes next
                }
            }
            System.out.print("Enter a day: ");
            while (true) { // user input validation for day
                if (scanner.hasNextInt()) { // checks for whether user input is int
                    day = scanner.nextInt();
                    if (day >= 1 && day <= 31) {
                        break;
                    } else {
                        System.out.print("Please enter a valid day(1-31): ");
                    }
                } else { // prompts user to enter input again if not
                    System.out.print("Please enter a valid day: ");
                    scanner.next(); // consumes input with incorrect type and goes next
                }
            }
            guess = LocalDate.of(year, month, day);

            if (guess.isBefore(answer)) {
                System.out.println("\nYou guessed: " + guess);
                System.out.print("It's in the future! Enter another year: ");
            } else if (guess.isAfter(answer)) {
                System.out.println("\nYou guessed: " + guess);
                System.out.print("It's in the past! Enter another year: ");
            } else {
                System.out.println("\nYou got it right! The answer was: " + answer);
                System.out.println("You guessed " + guessCount + " times!");
            }
            guessCount++;
        } while (guess != answer);
        scanner.close();
    }
}
