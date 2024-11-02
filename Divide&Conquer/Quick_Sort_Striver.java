import java.util.Arrays;

public class QuickSort {

    // Method to partition the array
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low;
        int j = high;

        while (i < j) {
            while (i <= high - 1 && arr[i] <= pivot) {
                i++;
            }

            while (j >= low + 1 && arr[j] > pivot) {
                j--;
            }

            if (i < j) {
                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // Swap arr[low] and arr[j]
        arr[low] = arr[j];
        arr[j] = pivot;

        return j;
    }

    // QuickSort algorithm
    private static void qs(int[] arr, int low, int high) {
        if (low < high) {
            int pIndex = partition(arr, low, high);
            qs(arr, low, pIndex - 1);
            qs(arr, pIndex + 1, high);
        }
    }

    // Method to perform quick sort
    public static int[] quickSort(int[] arr) {
        qs(arr, 0, arr.length - 1);
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {4, 6, 2, 5, 7, 9, 1, 3};
        
        System.out.println("Before Using Quick Sort:");
        System.out.println(Arrays.toString(arr));

        arr = quickSort(arr);
        
        System.out.println("After Using Quick Sort:");
        System.out.println(Arrays.toString(arr));
    }
}
