import java.util.Arrays;
import java.util.Scanner;

public class RadixSort {
    
    // Method to get the maximum value in array
    private static int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
    
    // Counting sort based on digit position
    private static void countingSort(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10];
        
        // Store count of occurrences
        for (int i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10]++;
        }
        
        // Change count[i] to actual position
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }
        
        // Build the output array
        for (int i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }
        
        // Copy output array to arr
        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }
    
    // Main radix sort function
    public static void radixSort(int[] arr) {
        int max = getMax(arr);
        
        System.out.println("\nSorting with Radix Sort...");
        int pass = 1;
        
        // Do counting sort for every digit
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(arr, exp);
            System.out.println("Pass " + pass + ": " + Arrays.toString(arr));
            pass++;
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Welcome to the Ultimate Sorter!");
        System.out.println();
        
        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt();
        
        int[] arr = new int[size];
        
        System.out.print("Enter " + size + " numbers: ");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        
        System.out.println("Original Array: " + Arrays.toString(arr));
        System.out.println();
        
        System.out.println("Choose a sorting algorithm:");
        System.out.println("\t1. Bubble Sort");
        System.out.println("\t2. Selection Sort");
        System.out.println("\t3. Insertion Sort");
        System.out.println("\t4. Merge Sort");
        System.out.println("\t5. Quick Sort");
        System.out.println("\t6. Radix Sort");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
        
        if (choice == 6) {
            radixSort(arr);
            System.out.println("Final Sorted Array: " + Arrays.toString(arr));
        } else {
            System.out.println("Please select option 6 for Radix Sort!");
        }
        
        sc.close();
    }
}