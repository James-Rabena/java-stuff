// ArrayListExample.java
import java.util.ArrayList;

public class DLAArrayList {
    public static void main(String[] args) {
        // 1. 
        ArrayList<String> tasks = new ArrayList<>();

        // 2. 
        tasks.add("Task 1");
        tasks.add("Task 2");
        tasks.add("Task 3");
        tasks.add("Task 4");
        tasks.add("Task 5");

        // 3. 
        System.out.println("ArrayList Tasks:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println(i + ": " + tasks.get(i));
        }

        // 4. 
        System.out.println("\nAdding more tasks...");
        tasks.add("Task 6");
        tasks.add("Task 7");

        // 5. 
        System.out.println("\nRemoving element at index 2...");
        tasks.remove(2);

        // 6. 
        tasks.set(1, "Updated Task 2");

        // 7.
        System.out.println("\nUpdated ArrayList Tasks:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println(i + ": " + tasks.get(i));
        }
        System.out.println("\nArrayList size: " + tasks.size());
    }
}
