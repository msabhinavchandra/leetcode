import java.util.LinkedList;
import java.util.Queue;

class LinkedListQueueExample {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();

        // Adding elements to the queue
        queue.add("Element 1");
        queue.add("Element 2");
        queue.add("Element 3");

        // Displaying the queue
        System.out.println("Queue: " + queue);

        // Removing elements from the queue
        String removedElement = queue.poll(); // poll() removes and returns the head of the queue
        System.out.println("Removed Element: " + removedElement);
        System.out.println("Queue after removal: " + queue);

        // Peek at the head of the queue without removing it
        String head = queue.peek();
        System.out.println("Head of the queue: " + head);
    }
}
