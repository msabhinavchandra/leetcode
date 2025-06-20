class Solution {

    class DSJ {

        int size;
        int[] parent;

        // constructor
        DSJ(int i) {
            size = i;
            parent = new int[i];
            initialize();
        }

        private void initialize() {
            for (int i = 0; i < size; i++) {
                parent[i] = i;
            }
        }

        public int find(int node) {
            if (parent[node] == node)
                return node;
            else
                return find(parent[node]);
        }

        public void union(int x, int y) {
            int parentX = find(x);
            int parentY = find(y);
            if (parentX < parentY) {

                parent[parentY] = parentX;

            } else if (parentX > parentY) {

                parent[parentX] = parentY;

            }
        }

    }

    public String smallestEquivalentString(String s1, String s2, String baseStr) {

        // the one with the least ascii make it the parent

        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();

        int size = s1.length();

        DSJ dsj = new DSJ(26);

        int i = 0;

        while (i < size) {

            dsj.union(arr1[i] - 'a', arr2[i] - 'a');

            i++;
        }
        char[] newarray = baseStr.toCharArray();
        for (i = 0; i < baseStr.length(); i++) {
            int parent = dsj.find(newarray[i] - 'a');
            newarray[i] = (char) (parent + 'a');
        }
        return new String(newarray);
    }
}

// ascii wit

// Another version of my solution
class Solution2 {

    class DSU {

        // a parent Array
        int[] parent = new int[26];

        // contructor
        DSU() {
            initialize();
        }

        void initialize() {
            // initialize the parent with itself first
            // and the ranks of all of them to 0 initially
            for (int i = 0; i < 26; i++) {
                parent[i] = i;
            }
        }

        // union function 
        // if equal do sth, if unequal do sth else
        void union(int a, int b) {
            int pa = findParent(a);
            int pb = findParent(b);

            if (pa == pb) {
                // then don't do anything just return it
                return;
            } else if (pa > pb) {
                // join pb to pa
                parent[pa] = pb;

            } else {
                parent[pb] = pa;
            }
        }

        // find parent function prefer path compression
        int findParent(int n) {
            if (n == parent[n])
                return n;
            return parent[n]=findParent(parent[n]);// path compression
        }

    }

    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        DSU dsu = new DSU();
        for (int i = 0; i < s1.length(); i++) {
            // union them
            dsu.union(s1.charAt(i) - 'a', s2.charAt(i) - 'a');
        }
        String answer = "";
        for (int i = 0; i < baseStr.length(); i++) {
            // union them
            answer += (char) ((dsu.findParent(baseStr.charAt(i) - 'a')) + 'a') + "";
        }

        return answer;

    }
}