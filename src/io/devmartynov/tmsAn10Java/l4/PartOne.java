package io.devmartynov.tmsAn10Java.l4;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Homework.
 * Part #1.
 */
public class PartOne {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        checkIfNumberInsideArray();
        removeNumberFromArray();
        getMinMaxAndMiddleNumberFormArray();
        getAverageOfNumbersFromTwoArraysAndResult();
    }

    /**
     * Task #1
     * Crate integer array.
     * Print message if array contains number.
     * Number is given through console input.
     */
    public static void checkIfNumberInsideArray() {
        int[] array = new RandomIntArray(10).get();
        String arrayAsString = Arrays.toString(array);
        System.out.println("Array: " + arrayAsString);
        System.out.print("Enter number to check if it's inside the array: ");
        int toCheckNumber = scanner.nextInt();
        Arrays.sort(array);
        boolean included = Arrays.binarySearch(array, toCheckNumber) >= 0;
        System.out.printf("Число " + toCheckNumber + (included ? "" : " не ") + "входит в массив " + arrayAsString);
    }

    /**
     * Task #2
     * Crate integer array.
     * Remove number from array.
     * Number is given through console input.
     * Print message if array doesn't contain number;
     */
    public static void removeNumberFromArray() {
        int[] array = {11, 11, 11, 14, 16, 8, 33, 17, 8, 16};
        System.out.println("Array: " + Arrays.toString(array));
        System.out.print("Enter number to remove from array: ");
        int toRemoveNumber = scanner.nextInt();
        boolean successful = false;
        int i = 0;

        while (i < array.length) {
            if (array[i] == toRemoveNumber) {
                System.arraycopy(array, i + 1, array, i, array.length - i - 1);
                array = Arrays.copyOfRange(array, 0, array.length - 1);
                i = 0;
                successful = true;
            } else {
                i++;
            }
        }

        System.out.println(
            "Число "
                + toRemoveNumber
                + (successful ? " успешно удално из массива. " : " отсутсвует в массиве. ")
                + "Результирующий массив: " + Arrays.toString(array)
        );
    }

    /**
     * Task #3
     * Create random integer array.
     * Print min, max, and middle element in array.
     * It should be possible to create array of custom size.
     * Array size is given through console input.
     */
    public static void getMinMaxAndMiddleNumberFormArray() {
        System.out.print("Enter size of array: ");
        int size = scanner.nextInt();
        int[] array = new SortedIntArray(new RandomIntArray(10)).get();
        String arrayAsString = Arrays.toString(array);
        System.out.println("Array: " + arrayAsString);
        System.out.println("Min value is: " + array[0]);
        System.out.println("Max value is: " + array[size - 1]);
        System.out.println("Middle value is: " + (size % 2 == 0 ? "no middle value" : array[size / 2]));
    }

    /**
     * Task #4
     * Create two arrays of 5 numbers.
     * Print arrays in two different lines.
     * Calculate average of numbers in each array.
     * Print if averages is equal or one is bigger than another.
     */
    public static void getAverageOfNumbersFromTwoArraysAndResult() {
        int size = 5;
        int[] array1 = new RandomIntArray(size).get();
        int[] array2 = new RandomIntArray(size).get();

        System.out.println("Array 1: " + Arrays.toString(array1));
        System.out.println("Array 2: " + Arrays.toString(array2));

        int sumOfArray1 = 0;
        int sumOfArray2 = 0;

        for (int i = 0; i < size; i++) {
            sumOfArray1 += array1[i];
            sumOfArray2 += array2[i];
        }

        int averageOfArray1 = sumOfArray1 / size;
        int averageOfArray2 = sumOfArray2 / size;

        String message;

        if (averageOfArray1 == averageOfArray2) {
            message = "Averages are equal " + averageOfArray1;
        } else {
            boolean firstBigger = averageOfArray1 > averageOfArray2;
            message = String.format(
                "Average of numbers inside %s: %d is bigger than %s: %d",
                firstBigger ? "array1" : "array2",
                firstBigger ? averageOfArray1 : averageOfArray2,
                firstBigger ? "array2" : "array1",
                firstBigger ? averageOfArray2 : averageOfArray1
            );
        }

        System.out.println(message);
    }

    private static void removeElement(int[] array, int index) {
        // copy elements from original array from beginning till index into copyArray
        System.arraycopy(array, 0, array, 0, index);

        // copy elements from original array from index+1 till end into copyArray
        System.arraycopy(array, index + 1, array, index, array.length - index - 1);
    }
}
