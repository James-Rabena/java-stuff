
public class Array {
    public static void main(String[] args) {
        // 1. 
        String[] tasks = new String[5];

        // 2. Adding Elements
        tasks[0] = "Task 1";
        tasks[1] = "Task 2";
        tasks[2] = "Task 3";
        tasks[3] = "Task 4";
        tasks[4] = "Task 5";

        // 3. 
        System.out.println("Array Tasks:");
        for (int i = 0; i < tasks.length; i++) {
            System.out.println(i + ": " + tasks[i]);
        }

        // 4. 
        System.out.println("\nAttempting to add 6th element...");
        tasks[5] = "Task 6";


        // 5. 
        System.out.println("\nRemoving element at index 2...");
        for (int i = 2; i < tasks.length - 1; i++) {
            tasks[i] = tasks[i + 1];
        }
        tasks[tasks.length - 1] = null;

        // 6. 
        tasks[1] = "Updated Task 2";

        // 7. 
        System.out.println("\nUpdated Array Tasks:");
        for (int i = 0; i < tasks.length; i++) {
            System.out.println(i + ": " + tasks[i]);
        }
        System.out.println("\nArray length: " + tasks.length);
    }
}
