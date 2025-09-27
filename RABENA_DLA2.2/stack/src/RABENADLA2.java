import java.util.ArrayList;

public class RABENADLA2 {
    static class EmptyStackException extends RuntimeException {
        public EmptyStackException(String message) {
            super(message);
        }
    }

    static class CustomStack<T> {
        private ArrayList<T> elements;
        
        public CustomStack() {
            elements = new ArrayList<>();
        }
        
        public void push(T element) {
            elements.add(element);
        }
        
        public T pop() {
            if (isEmpty()) {
                throw new EmptyStackException("Stack is empty.");
            }
            return elements.remove(elements.size() - 1);
        }
        
        public T peek() {
            if (isEmpty()) {
                throw new EmptyStackException("Stack is empty.");
            }
            return elements.get(elements.size() - 1);
        }
        
        public boolean isEmpty() {
            return elements.isEmpty();
        }
        
        public int size() {
            return elements.size();
        }
    }

    public static void main(String[] args) {
        CustomStack<Integer> stack = new CustomStack<>();
        
        System.out.println("Initial size of stack: " + stack.size());
        
        System.out.println("Pushing 10");
        stack.push(10);
        System.out.println("Pushing 20");
        stack.push(20);
        System.out.println("Pushing 30");
        stack.push(30);
        System.out.println("Pushing 40");
        stack.push(40);
        
        System.out.println("Current size of stack: " + stack.size());
        System.out.println("Top element (peek): " + stack.peek());
        
        System.out.println("Popped element: " + stack.pop());
        System.out.println("New top element (peek): " + stack.peek());
        
        System.out.println("Popping remaining elements:");
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
        
        System.out.println("Is the stack empty? " + stack.isEmpty());
        
        System.out.println("Attempting to pop from an empty stack...");
        try {
            stack.pop();
        } catch (EmptyStackException e) {
            System.out.println("Caught EmptyStackException: " + e.getMessage());
        }
    }
}