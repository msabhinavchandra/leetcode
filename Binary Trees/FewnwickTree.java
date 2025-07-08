// Online Java Compiler
// Use this editor to write, compile and run your Java code online

/*
 Malika taught a new fun time program practice for Engineering Students.
As a part of this she has given set of N numbers, and asked the students 
to perform the operations listed below:
1. sumRange(start, end) - return the sum of numbers between the indices start and end, both are inclusive.
2. update(ind, val) - update the value at the index 'ind' to 'val'.

Your task is to solve this problem using Fenwick Tree concept.

Input Format:
-------------
Line-1: Two integers N and Q, size of the array(set of numbers) and query count.
Line-2: N space separated integers.
next Q lines: Three integers option, start/ind and end/val.

Output Format:
--------------
An integer result, for every sumRange query.


Sample Input-1:
---------------
8 5
1 2 13 4 25 16 17 8
1 2 6		//sumRange
1 0 7		//sumRange
2 2 18	//update
2 4 17	//update
1 2 7		//sumRange

8 5
1 2 13 4 25 16 17 8
1 2 6		
1 0 7	
2 2 18	
2 4 17	
1 2 7		

Sample Output-1:
----------------
75
86
80



Sample Input-2:
---------------
8 5
1 2 13 4 25 16 17 8
1 2 6		
1 0 7		
2 2 18	
2 4 17	
1 0 7

Sample Output-2:
----------------
75
86
83
*/
import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arrSize = sc.nextInt();
        int noOfOps = sc.nextInt();
        // i am taking the array as 1-based index
        // to not have any problems
        int[] arr = new int[arrSize + 1];
        int[] Bit = new int[arrSize + 1];
        List<Integer> result = new ArrayList<>();
        // first take the array input
        for (int i = 1; i <= arrSize; i++) {
            arr[i] = sc.nextInt();
        }
        // array input completed.
        // 1 for sum range
        // 2 for an update
        // i need to build the BIT
        // for which i will be needing the Update function.
        for (int i = 1; i <= arrSize; i++) {
            update(Bit, i, arr[i], arrSize);
        }
        while (noOfOps-- > 0) {
            int op = sc.nextInt();
            if (op == 1) {
                // sum range query
                int start = sc.nextInt();
                int end = sc.nextInt();
                int sum = sumRange(Bit, start, end, arrSize);
                result.add(sum);
            } else if (op == 2) {
                // update query
                int ind = sc.nextInt();
                int val = sc.nextInt();
                // remove that val at that index
                update(Bit, ind, -arr[ind], arrSize);
                arr[ind] = val;
                // add the new value there
                update(Bit, ind, val, arrSize);
            }
        }
        System.out.println(result);
    }

    public static void update(int[] bit, int index, int val, int size) {
        while (index <= size) {
            bit[index] = bit[index] + val;
            index = index + (index & -index);
        }
    }

    public static int sum(int[] bit, int index, int size) {
        int sum = 0;
        while (index > 0) {
            sum = sum + bit[index];
            index = index - (index & -index);
        }
        return sum;
    }

    public static int sumRange(int[] bit, int start, int end, int size) {
        return sum(bit, end, size) - sum(bit, start - 1, size);
    }

}