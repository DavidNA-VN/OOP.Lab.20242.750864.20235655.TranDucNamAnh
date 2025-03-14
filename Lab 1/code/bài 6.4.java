
import java.util.Scanner;

public class DaysInMonth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year = getValidYear(scanner);
        int month = getValidMonth(scanner);

        int days = getDaysInMonth(month, year);
        System.out.println("The month " + month + " of year " + year + " has " + days + " days.");

        scanner.close();
    }

    private static int getValidYear(Scanner scanner) {
        int year;
        while (true) {
            System.out.print("Please enter a valid year (non-negative, e.g., 1999): ");
            if (scanner.hasNextInt()) {
                year = scanner.nextInt();
                if (year > 0) {
                    return year; 
                } else {
                    System.out.println("Year cannot be negative or 0. Please try again.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid year.");
                scanner.next(); 
            }
        }
    }

    private static int getValidMonth(Scanner scanner) {
        scanner.nextLine(); 
        int month = -1;
        while (month == -1) {
            System.out.print("Please enter a valid month (e.g., 1, Jan, January): ");
            String monthInput = scanner.nextLine().trim();
            month = getMonthNumber(monthInput);
            if (month == -1) {
                System.out.println("Invalid month. Please try again.");
            }
        }
        return month;
    }

    private static int getMonthNumber(String monthInput) {
        monthInput = monthInput.toLowerCase();
        switch (monthInput) {
            case "1": case "january": case "jan.": case "jan": return 1;
            case "2": case "february": case "feb.": case "feb": return 2;
            case "3": case "march": case "mar.": case "mar": return 3;
            case "4": case "april": case "apr.": case "apr": return 4;
            case "5": case "may": return 5;
            case "6": case "june": case "jun.": case "jun": return 6;
            case "7": case "july": case "jul.": case "jul": return 7;
            case "8": case "august": case "aug.": case "aug": return 8;
            case "9": case "september": case "sep.": case "sep": return 9;
            case "10": case "october": case "oct.": case "oct": return 10;
            case "11": case "november": case "nov.": case "nov": return 11;
            case "12": case "december": case "dec.": case "dec": return 12;
            default: return -1; 
        }
    }

    private static int getDaysInMonth(int month, int year) {
        return switch (month) {
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 4, 6, 9, 11 -> 30;
            case 2 -> (isLeapYear(year) ? 29 : 28);
            default -> -1;
        };
    }

    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
