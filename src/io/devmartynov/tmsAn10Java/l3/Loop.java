package io.devmartynov.tmsAn10Java.l3;

import java.util.Scanner;

public class Loop {
    public static void main(String[] args) {
        System.out.print("Task #1 Print not even numbers from range [1, 99) using increment: ");
        printNotEvenNumbersFromRange(1, 99);
        System.out.print("\nTask #2 Print numbers from given range [15, 1) using decrement: ");
        printNumbersFromRangeUsingDecrement(15, 1);
        System.out.println("\nTask #3 Print sum of numbers from given range [1, int): ");
        printNumbersSumFromRange();
        System.out.println("\nTask #4 Print sequence of 7: ");
        printSequenceOf7();
        System.out.println("\nTask #5 Print sequence of 5: ");
        printSequenceOf5();
        System.out.println("\nTask #6 Print squares of numbers in range of [10, 20]: ");
        printNumberSquareFromRange();
    }

    /**
     * Task #1
     * Print not even numbers from given range using increment. [int, int]
     *
     * @param begin begin of rage. Included
     * @param end   end of range. Not included
     */
    public static void printNotEvenNumbersFromRange(int begin, int end) {
        for (int i = begin; i < end; i++) {
            if (i % 2 != 0) { // is even
                System.out.print(i + ", ");
            }
        }
    }

    /**
     * Task #2
     * Print number from given range using decrement
     *
     * @param begin begin of rage. Included
     * @param end   end of range. Not included
     */
    public static void printNumbersFromRangeUsingDecrement(int begin, int end) {
        for (int i = begin; i > end; i--) {
            System.out.print(i + ", ");
        }
    }

    /**
     * Task #3
     * Sum numbers from range [1, int). int is user input number. int is not included in sum.
     */
    public static void printNumbersSumFromRange() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number: ");
        int endOfRange = scanner.nextInt();
        System.out.println("Sum: " + sumNumbersFromRange(1, endOfRange));
    }

    /**
     * Task #4
     * Print sequence of 7.
     */
    public static void printSequenceOf7() {
        printSequence(7, 7, 15);
    }

    /**
     * Task #5
     * Print sequence of 5.
     */
    public static void printSequenceOf5() {
        printSequence(0, -5, 10);
    }

    /**
     * Task #6
     * Print squares of numbers in range of [10, 20].
     */
    public static void printNumberSquareFromRange() {
        for (int i = 10; i <= 20; i++) {
            System.out.print((i * i) + ", ");
        }
    }

    /**
     * Print sequence.
     * @param begin sequence starts with this number
     * @param multiplier index of sequence multiply to this number
     * @param length length of sequence
     */
    private static void printSequence(int begin, int multiplier, int length) {
        int counter = begin / multiplier;

        while (counter < length) {
            System.out.print((multiplier * counter) + ", ");

            counter++;
        }
    }

    /**
     * Sum numbers from given range
     *
     * @param begin begin of rage. Included
     * @param end   end of range. Included
     * @return sum
     */
    private static int sumNumbersFromRange(int begin, int end) {
        int sum = 0;

        for (int i = begin; i <= end; i++) {
            sum += i;
        }

        return sum;
    }
}
