import java.util.LinkedList;
import java.util.Iterator;

public class LinkedListExample {
    public static void main(String[] args) {
        // Create a LinkedList
        LinkedList<String> list = new LinkedList<>();

        // Add elements to the LinkedList
        list.add("Element 1");
        list.add("Element 2");
        list.add("Element 3");

        // Add elements at specific positions
        list.addFirst("First Element");
        list.addLast("Last Element");
        list.add(2, "Middle Element");

        // Access elements
        String firstElement = list.getFirst();
        String lastElement = list.getLast();
        String elementAtIndex = list.get(2);

        System.out.println("First Element: " + firstElement);
        System.out.println("Last Element: " + lastElement);
        System.out.println("Element at Index 2: " + elementAtIndex);

        // Iterate through the LinkedList
        System.out.println("Iterating through the LinkedList:");
        for (String element : list) {
            System.out.println(element);
        }

        // Remove elements
        list.removeFirst();
        list.removeLast();
        list.remove(2);

        // Check if the LinkedList contains an element
        boolean contains = list.contains("Element 2");
        System.out.println("Contains 'Element 2': " + contains);

        // Get the size of the LinkedList
        int size = list.size();
        System.out.println("Size of the LinkedList: " + size);

        // Clear all elements from the LinkedList
        list.clear();
        System.out.println("LinkedList cleared. Size: " + list.size());
    }
}
