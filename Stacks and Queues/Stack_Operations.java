import java.util.Stack;

class StackExample {
    public static void main(String[] args) {
        // Create a stack of integers
        Stack<Integer> stack = new Stack<>();

        // Pushing elements onto the stack
        stack.push(10);
        stack.push(20);
        stack.push(30);

        // Popping an element from the stack
        int topElement = stack.pop();
        System.out.println("Popped element: " + topElement);

        // Peeking at the top element
        topElement = stack.peek();
        System.out.println("Top element: " + topElement);

        // Checking if the stack is empty
        boolean isEmpty = stack.isEmpty();
        System.out.println("Is stack empty? " + isEmpty);

        // Finding the position of an element
        int position = stack.search(20);
        if (position != -1) {
            System.out.println("Element found at position: " + position);
        } else {
            System.out.println("Element not found in the stack");
        }

        // Iterating over the stack
        System.out.println("Stack elements:");
        for (Integer element : stack) {
            System.out.println(element);
        }
    }
}
