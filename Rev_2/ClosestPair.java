package Rev_2;

//optimal tc->O(n1+n2) and sc->O(1)

import java.util.*;

public class ClosestPair {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l1 = sc.nextInt();
        int[] arr1 = new int[l1];
        for (int i = 0; i < l1; i++)
            arr1[i] = sc.nextInt();
        int l2 = sc.nextInt();
        int[] arr2 = new int[l2];
        for (int i = 0; i < l2; i++)
            arr2[i] = sc.nextInt();
        int target = sc.nextInt();

        int[] result = new int[2];

        findPair(l1, arr1, l2, arr2, target, result);

        System.out.println(result[0] + "," + result[1]);
    }

    public static void findPair(int l1, int[] arr1, int l2, int[] arr2, int target, int[] result) {
        int absdiff = Integer.MAX_VALUE;
        int first = 0; // for l1
        int last = l2 - 1; // for l2
        // System.out.println("Inside the function ");
        int diff = 0;
        while (first < l1 && last >= 0) {
            // do the sum 
            int sum = arr1[first] + arr2[last];
            diff = Math.abs(sum - target);
            if (diff < absdiff) {
                absdiff = diff;
                result[0] = arr1[first];
                result[1] = arr2[last];
            }
            if (sum == target) {
                return; // best case scenario
            } else if (sum > target) {
                last--;
            } else if (sum < target) {
                first++;
            }
        }
    }
}