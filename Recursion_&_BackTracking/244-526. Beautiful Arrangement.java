class Solution {
    // this whole problem deals with 1-based indexing
    int count = 0;

    public int countArrangement(int n) {
        boolean[] vis = new boolean[n + 1];
        countNoOfArrangements(n, 1, vis);
        return count;

    }

    public void countNoOfArrangements(int N, int pos, boolean[] vis) {
        if (pos > N) {
            count++;
            return;// we made it future is good
        }
        // find and check for all the possibilities
        // 1-based indexing
        for (int i = 1; i <= N; i++) {// 1-based indexing
            // the most important step in this whole problem
            // checking the feasibility of that pick, if feasible, then only pick it
            if (!vis[i] && (pos % i == 0 || i % pos == 0)) {
                // then only pick it
                vis[i] = true;
                countNoOfArrangements(N, pos + 1, vis);// check for the future position and
                // possibilities
                // after checking the future no matter good or not
                // undo that move to check for the existing other iterations of possibilities
                vis[i] = false;
            }
        }

    }
    /*
     * i feel this is probably one of the best backtraking
     * problems i have solved so far
     * the only difference between the other problems and this problems is
     * before picking you are checking the feasibility of that pick
     * if it is feasible then only you will pick and further check the
     * next different set of possibilities of that pick
     * what is the future with this pick
     * see the future check it
     * if good add into res
     * if not backtrack.
     * follow up would be the printing of those possibilities
     * not so different just in the base condition you will add the
     * comb into the result array, that's it.
     */
}