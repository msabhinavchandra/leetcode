class Solution {

    // i need a hashset to store the unique values
    Set<String> set = new HashSet<>();

    public int maxUniqueSplit(String s) {
        return DFS(s, 0);
    }

    public int DFS(String s, int curr) {
        // base condition if we exceed the curr that means return 0, because u can't
        // make any
        // unique combiantions out of something which is ""
        if (curr == s.length())
            return 0;
        int res = 0;
        // run the for-loop for checking the range of possibilites
        for (int i = curr; i < s.length(); i++) {
            String substr = s.substring(curr, i + 1);// (0,1),(0,2),(0,3),for len 3 abc max (0,3) str 0 1 2 3 is
                                                     // excluding
            // initially the set is empty at the first call so in the first rec call all the
            // possibilites
            // will be included in the set, but as the set keeps on growing with more and
            // more rec calls
            // this important step comes in handy with us to us, that where before we are
            // trying out a possibility
            // does that possibility already exists, if yes, then there is no point in
            // trying it let's just skip that
            // possibility to try out all the different possibilities in our for to find
            // that possibility which
            // has the potential of giving us the max res max number of unique elements
            // possibillty.
            if (set.contains(substr))
                continue;// res will be 0 only so far and i won't be updated because
            // we are skipping this respective loop.
            // below will be executed if that is a unqie possibility and worth exploring
            // by adding it into out set and tryoing out the ftutue
            set.add(substr);
            res = Math.max(res, 1 + DFS(s, i + 1));
            // till i it is placed, and i want to check all the possibiliteis of my string
            // from i+1, to make
            // the respective unique combinations.because till i , unique combinations are
            // already made and
            // added into the set so far.(from curr-> i) combinations, from i+1->end of
            // string, should be explored
            // (which is the future)
            // after exploring this possibility, provide space for other to perform and show
            // their capabilitoes
            // by clearing the spcae you used, remove the substr from the set, and provide
            // the un-modified
            // set for the next iterations possibilities to try out and for
            set.remove(substr);

        } // end of for-loop
        return res;// after all the possibilities are explored, our best case result will be stored
                   // in the res.
        // so we return it.

        // if

    }
    /*
     * Again i feel this is one of the best Backtracking problems i have solved so
     * far
     * where the
     * 1-> trying out all the possibilities
     * 2-> after trying every possibility, your undoing that move and giving that
     * space for the other iterations
     * to try out there different moves,
     * 3-> for every possibility i am recording my res
     * 4-> my final result will be the maximum res i have acquired so far, among all
     * the possibilities
     * 5-> my result will be the most maximum of all the possibilities
     * 6-> that's it.
     */
}