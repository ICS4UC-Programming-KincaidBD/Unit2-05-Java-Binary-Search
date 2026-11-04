/*
 * This program demonstrates binary search in a sorted array.
 * It generates a random array, sorts it, and searches for a target value entered by the user.
 * @author KincaidBD
 * @since 2026/11/03
 * @version 1.0
 */

// Import Random to make random numbers and Scanner to read user input.
import java.util.Random;
import java.util.Scanner;

// This class creates a number list and searches it for a number the user enters.
public class BinarySearch {
    // The program starts running here.
    public static void main(String[] args) {
        // Set up a Scanner so the program can read what the user types.
        Scanner scanner = new Scanner(System.in);
        // Create an array with 10 random numbers in it.
        int[] array = populateArray(10);
        System.out.print("Enter the target value or 'q' to quit: ");
        // Use this flag to keep asking until the input is a valid integer.
        boolean flag = false;
        int target = 0;
        String user = "";
        // Repeat while the user has not entered a valid number.
        while (flag == false) {
            try {
                // Try to read an integer and save it as the target.
                user = scanner.next();
                target = Integer.parseInt(user);
                flag = true;
            } catch (Exception e) {
                // If the input was not an integer, ask again and clear that input.
                if (user.equals("q")) {
                    System.out.println("Exiting program.");
                    System.exit(0);
                }
                System.out.print("Invalid input. Please enter a valid integer or 'q' to quit: ");
                scanner.nextLine(); // Clear the invalid input
            }
        }
        // Search the array after a valid target has been entered.
        if (flag == true) {
            int result = binarySearch(array, target);
            // A result of -1 means the target was not in the array.
            if (result == -1) {
                System.out.println("Target value not found in the array.");
            }
            // Otherwise, show the index where the target was found.
            else {
                System.out.println("The number " + target + " was found at index: " + result);
            }
        }
        // Close the Scanner when the program is done using it.
        scanner.close();
    }

    // Make and return an array with the requested number of random values.
    public static int[] populateArray(int size) {
        // Create an array that has room for size numbers.
        int[] array = new int[size];
        // Create a random number generator.
        Random random = new Random();
        // Fill each spot in the array with a random number from 0 to 99.
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(100);
        }
        // Give the filled array back to the part of the program that called this method.
        return array;
    }

    // Search a sorted array for the target and return its index, or -1 if it is missing.
    public static int binarySearch(int[] array, int target) {
        // Start searching at the first index.
        int left = 0;
        // Ensure the array is sorted for binary search
        java.util.Arrays.sort(array);
        // Print the sorted array so the user can see what is being searched.
        System.out.println("Array sorted for binary search: " + java.util.Arrays.toString(array));
        // Initialize the right pointer to the last index of the array
        int right = array.length - 1;
        // Perform binary search on the sorted array
        while (left <= right) {
            // Check the middle index between the current left and right limits.
            int mid = left + (right - left) / 2;
            // If the middle value matches, return its index.
            if (array[mid] == target) {
                return mid;
            // If the middle value is too small, search the right half.
            } else if (array[mid] < target) {
                left = mid + 1;
            // If the middle value is too big, search the left half.
            } else {
                right = mid - 1;
            }
        }
        // The target was not found in the array.
        return -1;
    }
}