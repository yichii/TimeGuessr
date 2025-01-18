import java.time.*;
import java.util.Scanner;

public class GuessTheYear {
    public static void main(String[] args) {
        LocalDate guess = LocalDate.of(2001, 1, 9);
        Scanner scanner = new Scanner(System.in);
        int year;
        System.out.print("Guess the date! Enter a year: ");
        do {
            year = scanner.nextInt();
            if (year < guess.getYear()) {
                System.out.print("Try a higher number! Guess again: ");
            } else if (year > guess.getYear()){
                System.out.print("Try a lower number! Guess again: ");
            } else {
                System.out.print("You got it right! The answer was: " + guess.getYear());
            }
        } while (year != guess.getYear());
        scanner.close();
    }

}