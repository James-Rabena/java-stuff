import java.util.*;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the size of the array: ");
        int size = sc.nextInt();
        sc.nextLine(); 
        
        Object[] arr = new Object[size];
        
        System.out.println("Enter the elements of the array (numbers or strings): ");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextLine();
        }
        
        
        System.out.println("Elements in reverse order: ");
        for (int i = size - 1; i >= 0; i--) {
            System.out.print(arr[i]);
            if (i > 0) System.out.print(", ");
        }
        System.out.println();
        
        
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                int num1 = asc(arr[j].toString());
                int num2 = asc(arr[j + 1].toString());
                
                if (num1 > num2) {
                    Object temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        
        System.out.println("Elements in ascending order: ");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i]);
            if (i < size - 1) System.out.print(", ");
        }
        System.out.println();
        
        sc.close();
    }
    
    static int asc(String str) {
    return Integer.parseInt(str.replaceAll("[^0-9]", ""));
}
}