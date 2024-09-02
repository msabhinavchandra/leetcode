class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subseq = new ArrayList<>();
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        func(0, arr, subseq, n, k, result);
        return result;
    }

    public static void func(int index, int[] arr, List<Integer> subseq, int sum, int k, List<List<Integer>> result) {
        if (sum == 0 && subseq.size() == k) {
            result.add(new ArrayList<>(subseq));
            return;
        }
        
        if (sum < 0 || subseq.size() > k || index >= arr.length) {
            return;
        }

        // pick the current element
        subseq.add(arr[index]);
        func(index + 1, arr, subseq, sum - arr[index], k, result);

        // don't pick the current element
        subseq.remove(subseq.size() - 1);
        func(index + 1, arr, subseq, sum, k, result);
    }
}
