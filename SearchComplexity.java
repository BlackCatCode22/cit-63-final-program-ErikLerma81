// SearchComplexity.java
// Starter code for final programming assignment in CIT-63 Java Programming Spring 2024


import javax.naming.NameNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.InputMismatchException;

public class SearchComplexity {

    // Linear Search Method
    public static int linearSearch(int[] array, int target) {
        long start = System.nanoTime();
        int IterationCount = 1;
        for (int i = 0; i < array.length; i++) {
            IterationCount++;
            if (array[i] == target) {
                long end = System.nanoTime();
                long time = end - start;
                System.out.println(IterationCount - 1 + " total iterations to find target"  );
                System.out.println("Nano time: " + time);
                return i;  // Returns index of found element
            }
        }
        return -1;  // Target not found
    }

    // Binary Search Method
    public static int binarySearch(int[] array, int target) {
        long start = System.nanoTime();
        return binarySearchRecursive(array, target, 0, array.length - 1,0, start);
    }

    private static int binarySearchRecursive(int[] array, int target, int left, int right, int iterations, long starttime) {
        if (left <= right) {
            int mid = left + (right - left) / 2;
            iterations++;

            if (array[mid] == target) {
                long end = System.nanoTime();
                long time = end - starttime;
                System.out.println(iterations + " total iteration to find target");
                System.out.println("Nano time: " + time);
                return mid;
            } else if (array[mid] < target) {
                return binarySearchRecursive(array, target, mid + 1, right, iterations, starttime);
            } else {
                return binarySearchRecursive(array, target, left, mid - 1, iterations, starttime);
            }
        }
        return -1;  // Target not found
    }



public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int n = 0;
    int[] array = null;
    int target = 0;

    try {
        System.out.println("Enter number of elements in array:");
        n = scanner.nextInt();
        array = new int[n];

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.println("Enter target number to search:");
        target = scanner.nextInt();

    } catch (InputMismatchException e) {
        System.out.println("Input error: Please enter valid integers.");
        System.out.println("Please rerun the program again to proceed");
        return; // Exit the program if there's an input error
    }




        // Linear Search
        int linearResult = linearSearch(array, target);
        System.out.println((linearResult == -1) ? "Target not found by linear search." :
                "Target found by linear search at index: " + linearResult);

        // Binary Search (Array must be sorted)
        Arrays.sort(array);
        int binaryResult = binarySearch(array, target);
        System.out.println((binaryResult == -1) ? "Target not found by binary search." :
                "Target found by binary search at index: " + binaryResult);

        scanner.close();
    }
}

