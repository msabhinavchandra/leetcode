//Bit Manipulation Way
/* Time Complexity: O(2^n * n)
Reason: O(2^n) for the outer for loop and O(n) for the inner for loop.
Space Complexity:
Although a new string sub is constructed in each iteration, this string is eventually stored in the 
output list ans, which is not considered in auxiliary space.Thus, the space complexity is 
O(1) because no additional space (other than the input and the output) grows with the size of the input.
The result set (i.e., the list of subsequences in ans) is not counted towards the space complexity
calculation because it's considered part of the output.
*/
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        // iterate over all possible binary masks
        for (int num = 0; num < (1 << n); num++) {
            List<Integer> subset = new ArrayList<>();

            // For each bit in the mask,check if it's set and include the corresponding
            // element
            for (int i = 0; i < n; i++) {
                if ((num & (1 << i)) != 0)
                    subset.add(nums[i]);

            }
            result.add(subset);// For list of integers you will add an integer
            // for the list of Lists, you will add a list
        }
        return result;
    }
}




// Recursion way
// TC->the time taken is directly proportional to the no of subsequences we generate because generating 
//every subsequence takes time, so my time taken will be the time taken to generate all the subsequences
//so for a length of n i will get 2^n subsequences so the time complexity becomes O(2^n)
//and after retrieving the subsequence we need to make a copy out of it to store in the result
//so that copy operation for every subsequence is O(n) where n is the size of the subsequence
//There fore the overall time complexity becomes O(2^n*n)

//Space complexity->is equal to the amount of memory used by the algorithm to calculate the result
//in my recursion the maximum depth of recursion is equal to the length of my nums n, space complexity
//is directly proportional to the depth of the recursion call stack, so the space compexity for n
// elements is O(n), because that is my maximum depth of the recursion call stack 

/* Intuition: Since we are generating subsets two cases will be possible, either you can pick the 
character or you cannot pick the character and move to the next character.*/

class Solution {

    public static void generateSubsets(int ind,int[] nums,List<Integer> currentSubset,List<List<Integer>> result){
        //Base case:if the index reaches the length of nums, it exceeded, time to print the subsequence
        if(ind==nums.length){
            //add the current subset to the result
            result.add(new ArrayList<>(currentSubset));//Any changes made to the currenSubset List won't be affected
            //for a copy which was added into the List of lists which is our result, that's why we make a copy and
            //add it.
            //For a list of Integers u will add an integer
            //For a list of lists u will add a list
            return;
        }
        //include the current element
        currentSubset.add(nums[ind]);
        generateSubsets(ind+1,nums,currentSubset,result);
        //Backtracking by removing the current element
        currentSubset.remove(currentSubset.size()-1);
        generateSubsets(ind+1,nums,currentSubset,result);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();//result will store all the subsets
        List<Integer> currentSubset=new ArrayList<>();//explicitly naming currentSubset
        //one List we are using to retrieve and store all possible outcomes of a subsequece
        //without any hassle by just making a copying out of it and adding to the result so that
        //any changes made to this across other possibilities doesn't affect the added subsequence
        generateSubsets(0,nums,currentSubset,result);
        return result;

        
    }
}