// TC->O(n)
// SC->O(1)

/*The time complexity of the hammingWeight function is O(k), where k is the 
number of bits in the integer. Since the integer n is a 32-bit integer 
(given the maximum constraint 2^31 - 1), the function will loop a maximum of 
32 times regardless of the integer's value. Therefore, it can be specifically 
described as O(32), which simplifies to O(1) in terms of constant time for 32-bit

integers. */

class Solution {
    public int hammingWeight(int n) {
        int num = n;
        int count = 0;
        while (num != 0) {
            if (num % 2 == 1) {
                count += 1;
            }
            // >> arithmetic right shift operator
            // >>> logical right shift operator
            num = num >>> 1;
        }
        return count;
    }
}

//Another approach  Brian Kernighan's algorithm, 
//Same Time complexity -> O(1)
/*The time complexity of the function is O(W), where W is the number of set bits (1s) in the binary representation of n. This algorithm is efficient because it directly counts each set bit by clearing the lowest set bit one at a time with the operation num = num & (num - 1). This operation removes the rightmost 1 bit from num at each step.

This means that the loop runs once for each set bit in n. So, if n has many set 
bits, the function will perform more iterations. In the worst case, when n is a 
number like 2^31 - 1 (which has all bits set), the loop would run 31 times for a 
32-bit integer. In contrast, for numbers with fewer set bits, the loop runs fewer
times. Thus, the time complexity is proportional to the number of set bits rather
than the total number of bits. so in the worst case the number of 1s could by 32
so the time complexity is constant O(1)*/
//space ->O(1)
class Solution {
    public int hammingWeight(int n) {
        int num=n;
        int res=0;
        while(num!=0){
            num=num&(num-1);
            res+=1;
        }
        return res;
    }
}