class Solution {
    public List<Integer> subsetSums(int[] nums) {
        //your code goes here
        List<Integer> result = new ArrayList<>();
        func(0, nums, 0, result);
        return result;
    }

    public static void func(int index, int[] arr, int sum, List<Integer> result) {
        if (index == arr.length) {
            result.add(sum);
            return;
        }
        sum += arr[index];
        func(index + 1, arr, sum, result);
        sum -= arr[index];
        func(index + 1, arr, sum, result);
    }

} // Line 1: The method 'subsetSums' works with 'nums' which could be more descriptive as 'inputArray'.
// Line 2: Suggest adding a brief comment indicating the purpose of the class.
// Line 5: Improve formatting by adding spaces around binary operators for consistency.
// Line 10: Comment explaining the recursive logic would improve readability, particularly on the base case.