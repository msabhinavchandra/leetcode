class Solution {
    public List<Long> maximumEvenSplit(long finalSum) {
        if (finalSum % 2 != 0)
            return new ArrayList<Long>();

        List<List<Long>> result = new ArrayList<>();
        List<Long> combination = new ArrayList<Long>();
        findMaxEvenSplit(finalSum, 2, combination, result);
        return result.get(0);

    }

    public void findMaxEvenSplit(long remainingSum, long start, List<Long> combination, List<List<Long>> result) {
        if (remainingSum == 0) {
            result.add(new ArrayList<Long>(combination));
            return;
        }
        if (start > remainingSum)
            return;
        // checking for all the set of possibilites
        for (long i = start; i <= remainingSum; i++) {
            // pick condition
            combination.add(i);
            // check for all the possibilities if i had made this move in my life, what will
            // be the future with this?
            findMaxEvenSplit(remainingSum - i, i + 2, combination, result);
            if (result.size() > 0)
                return;
            // suppose u didn't find, means there is no future for you with this move, so
            // therefore undo the move
            combination.remove(combination.size() - 1);
        }
    }

    /*
     * Algorithm
     * 1-> when the number is odd, you just can't split them into sum of +ve
     * numbers, so return an empty list when you incurred a final sum of odd
     * number
     * 2-> start with the remainingsum, and 2 as the initial even number as the
     * start, and an empty combination
     * 3-> i will try all the possibilities of a even numbers, where the range is
     * from the start to the remaining sum
     * 4-> i will pick the current element and call for all the possibilities
     * (combinations of the cases where) i could have find my result, in that way,
     * 5-> i will call with the start of the next even number, and modified
     * remaining
     * sum.
     * 6->over here whenever i am making the calls, i am making them for the
     * smallest
     * even numbers step by step on an increasing sequence if we observe
     * so when ever i see the result.size()>0 after any backtraking step,i am going
     * to return my answer, because i have found my pair
     * there can be multipile combinations but for me one combination is more than
     * enough
     * 7-> let's say suppose i failed to find the result picking something,
     * that is when the function won't be returned then i am going to undo my move
     * check out for other different possibilites in the for-loop which is going to
     * check
     * for all sets of even number possibilites
     * 8-> one more important thing is you can't start add those elements into your
     * comb
     * which are more than your remaining sum, so this actually happens internally
     * though
     * but still it's better if you write if start> remaining sum then just return
     * that
     * func call there is no point there the remaining sum is exhausted, it's better
     * to check for other possibilites than going over and over with this.
     * 9-> base condition when the remaining sum is 0 add the comb into the result
     * and
     * return the value, it's will be our result, because we are going to check it
     * anyway for the increasing order number of even numbers so the arr size will
     * be
     * as maximum as possible.
     */
}