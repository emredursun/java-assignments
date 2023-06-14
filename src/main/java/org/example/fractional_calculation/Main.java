package org.example.fractional_calculation;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean repeat;
        do {
            runCalculator();
            System.out.print("Do you want to try again? (y/n) ");
            repeat = scanner.next().equalsIgnoreCase("y");
        } while (repeat);
    }

    private static void runCalculator() {
        System.out.println("Choose your desired calculation:");
        System.out.println("1. Operation => Fraction & Fraction");
        System.out.println("2. Operation => Fraction & Integer");
        System.out.print("Enter your choice: ");
        int choice1 = scanner.nextInt();

        switch (choice1) {
            case 1:
                performFractionFractionOperation();
                break;
            case 2:
                performFractionIntegerOperation();
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }
    }

    private static void performFractionFractionOperation() {
        Fraction fraction1 = getFraction("Enter the first fraction (e.g. 1/3): ");
        Fraction fraction2 = getFraction("Enter the second fraction (e.g. 1/4): ");

        int choice2;
        do {
            System.out.println("Choose an operation:");
            System.out.println("1. Add");
            System.out.println("2. Subtract");
            System.out.println("3. Multiply");
            System.out.println("4. Divide");
            System.out.println("5. Convert to decimal notation");
            System.out.println("6. Convert to string");
            System.out.print("Enter your choice: ");
            choice2 = scanner.nextInt();

            switch (choice2) {
                case 1:
                    Fraction sum = fraction1.add(fraction2);
                    System.out.println(fraction1 + " + " + fraction2 + " = " + sum);
                    break;
                case 2:
                    Fraction difference = fraction1.subtract(fraction2);
                    System.out.println(fraction1 + " - " + fraction2 + " = " + difference);
                    break;
                case 3:
                    Fraction product = fraction1.multiply(fraction2);
                    System.out.println(fraction1 + " * " + fraction2 + " = " + product);
                    break;
                case 4:
                    Fraction quotient = fraction1.divide(fraction2);
                    System.out.println(fraction1 + " / " + fraction2 + " = " + quotient);
                    break;
                case 5:
                    System.out.println(fraction1 + " in decimal notation is " + fraction1.toDecimalNotation());
                    System.out.println(fraction2 + " in decimal notation is " + fraction2.toDecimalNotation());
                    break;
                case 6:
                    System.out.println(fraction1 + " as a string is \"" + fraction1.toString() + "\"");
                    System.out.println(fraction2 + " as a string is \"" + fraction2.toString() + "\"");
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        } while (repeatOperation());
    }

    private static void performFractionIntegerOperation() {
        Fraction fraction1 = getFraction("Enter the fraction (e.g. 1/3): ");
        System.out.print("Enter an integer (e.g. 1, 2, 3, etc.): ");
        int testNumber = scanner.nextInt();

        int choice2;
        do {
            System.out.println("Choose an operation:");
            System.out.println("1. Add");
            System.out.println("2. Subtract");
            System.out.println("3. Multiply");
            System.out.println("4. Divide");
            System.out.println("5. Convert to decimal notation");
            System.out.println("6. Convert to string");
            System.out.print("Enter your choice: ");
            choice2 = scanner.nextInt();

            switch (choice2) {
                case 1:
                    Fraction sum = fraction1.add(testNumber);
                    System.out.println(fraction1 + " + " + testNumber + " = " + sum);
                    break;
                case 2:
                    Fraction difference = fraction1.subtract(testNumber);
                    System.out.println(fraction1 + " - " + testNumber + " = " + difference);
                    break;
                case 3:
                    Fraction product = fraction1.multiply(testNumber);
                    System.out.println(fraction1 + " * " + testNumber + " = " + product);
                    break;
                case 4:
                    Fraction quotient = fraction1.divide(testNumber);
                    System.out.println(fraction1 + " / " + testNumber + " = " + quotient);
                    break;
                case 5:
                    System.out.println(fraction1 + " in decimal notation is " + fraction1.toDecimalNotation());
                    System.out.println(testNumber + " in decimal notation is " + (double) testNumber);
                    break;
                case 6:
                    System.out.println(fraction1 + " as a string is \"" + fraction1.toString() + "\"");
                    System.out.println(testNumber + " as a string is \"" + testNumber + "\"");
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        } while (repeatOperation());
    }

    private static boolean repeatOperation() {
        System.out.print("Do you want to perform another operation? (y/n) ");
        return scanner.next().equalsIgnoreCase("y");
    }

    private static Fraction getFraction(String prompt) {
        System.out.print(prompt);
        String[] parts = scanner.next().split("/");
        int numerator = Integer.parseInt(parts[0]);
        int denominator = Integer.parseInt(parts[1]);
        return new Fraction(numerator, denominator);
    }
}




//    public static void main(String[] args) {
//
//        System.out.print("Enter your numerator for first fraction: ");
//        Scanner scan = new Scanner(System.in);
//        int firstNumerator = scan.nextInt();
//        System.out.print("Enter your denominator for first fraction: ");
//        int firstDenominator = scan.nextInt();
//        Fraction firstFraction = new Fraction(firstNumerator, firstDenominator);
//
//        System.out.print("Enter your test number: ");
//        int testNumber = scan.nextInt();
//
//        System.out.print("Enter your numerator for second fraction: ");
//        int secondNumerator = scan.nextInt();
//        System.out.print("Enter your denominator for second fraction: ");
//        int secondDenominator = scan.nextInt();
//        Fraction secondFraction = new Fraction(secondNumerator,secondDenominator);
//
//
//        // double toDecimalNotation(): 1/3 should return 0.33333
//        double toDecimalNotation = firstFraction.toDecimalNotation();
//        System.out.println(toDecimalNotation);
//
//        // string toString(): 1/3 should return “1/3”
//        String toString = firstFraction.toString();
//        System.out.println(toString);
//
//        // Fraction add(int number): 1/3 + 1 should become 4/3
//        Fraction F1AddTestNum = firstFraction.add(testNumber);
//        System.out.print(firstFraction.toString() + " + " + testNumber + " = ");
//        System.out.println(F1AddTestNum);
//
//        // Fraction add(Fraction firstFraction): 1/3 + 1/6 should become 1/2
//        System.out.print(firstFraction.toString() + " + " + secondFraction.toString() + " = ");
//        Fraction F1AddF2 = firstFraction.add(secondFraction);
//        System.out.println(F1AddF2);
//
//        // Fraction subtract(int number): 4/3 - 1 should become 1/3
//        Fraction F1MinTestNum = firstFraction.subtract(testNumber);
//        System.out.print(firstFraction.toString() + " - " + testNumber + " = ");
//        System.out.println(F1MinTestNum);
//
//        // Fraction subtract(Fraction fraction): 1/2 - 1/6 should become 1/3
//        System.out.print(firstFraction.toString() + " - " + secondFraction.toString() + " = ");
//        Fraction F1MinF2 = firstFraction.subtract(secondFraction);
//        System.out.println(F1MinF2);
//
//        // Fraction multiply(int number): 3/4 * 2 should become 3/2
//        System.out.print(firstFraction.toString() + " * " + testNumber + " = ");
//        Fraction F1MultiplyTestNum = firstFraction.multiply(testNumber);
//        System.out.println(F1MultiplyTestNum);
//
//        // Fraction multiply(Fraction fraction): 3/4 * 2/5 should become 3/10
//        System.out.print(firstFraction.toString() + " * " + secondFraction.toString() + " = ");
//        Fraction F1MultiplyF2 = firstFraction.multiply(secondFraction);
//        System.out.println(F1MultiplyF2);
//
//        // Fraction divide(int number): 3/2 / 2 should become 3/4
//        System.out.print(firstFraction.toString() + " / " + testNumber + " = ");
//        Fraction F1DivideTestNum = firstFraction.divide(testNumber);
//        System.out.println(F1DivideTestNum);
//
//        // Fraction divide(Fraction fraction): 3/10 / 2/5 should become 3/4
//        System.out.print(firstFraction.toString() + " / " + secondFraction.toString() + " = ");
//        Fraction F1DivideF2 = firstFraction.divide(secondFraction);
//        System.out.println(F1DivideF2);
//
//    }

