import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;

public class GuessTheYear {
    public void start() {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        LocalDate answer = LocalDate.of(random.nextInt(2025), 1, 9);
        int year, guessCount = 1;
        System.out.print("Guess the date! Enter a year: ");
        do {
            year = scanner.nextInt();
            if (year < answer.getYear()) {
                System.out.print("Try a higher number! Guess again: ");
            } else if (year > answer.getYear()){
                System.out.print("Try a lower number! Guess again: ");
            } else {
                System.out.println("You got it right! The answer was: " + answer.getYear());
                System.out.println("You guessed " + guessCount + " time(s)!");
            }
            guessCount++;
        } while (year != answer.getYear());
        scanner.close();
    }
}