class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        findCombinations(1, n, combination, k, result);
        return result;
    }

    public void findCombinations(int start, int n, List<Integer> combination, int k, List<List<Integer>> result) {
        // base condition
        if (combination.size() == k) {
            result.add(new ArrayList<Integer>(combination));
            return;
        }

        for (int i = start; i <= n; i++) {
            combination.add(i);
            findCombinations(i + 1, n, combination, k, result);
            combination.remove(combination.size() - 1);
        }

    }

    // algorithm
    // 1-> start from initial index
    // 2-> pick it
    // 3-> try out all the possible combinations of the case when picked that start
    // index
    // 4-> base condition when the combination.size()==k add it to your result.
    // 5-> After exploring all the possibilities undo that move
    // 6-> to try out all other indeces thinking what would be the scenarios and
    // cases
    // if that respective was the start at first.
    // try out this for all the cases, putting all the indeces as the start once and
    // check
    // and try out all the possibilities
}