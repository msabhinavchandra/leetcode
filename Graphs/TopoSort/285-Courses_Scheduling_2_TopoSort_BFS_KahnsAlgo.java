package TopoSort;
import java.util.*;
class Solution {

    public ArrayList<Integer>[] constructAl(int num, int[][] prereq) {

        ArrayList<Integer>[] adjList = new ArrayList[num];

        for (int i = 0; i < num; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int[] e : prereq) {
            adjList[e[1]].add(e[0]);
        }

        return adjList;

    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        if (numCourses == 1 && prerequisites.length == 0)
            return new int[1];
        // edge case

        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer>[] adjList = constructAl(numCourses, prerequisites);
        int[] result = new int[numCourses];
        int[] indegree = new int[numCourses];
        // create an indegree array

        for (ArrayList<Integer> adl : adjList) {
            // n is the arrayList neighbours of n
            for (int n : adl) {
                indegree[n]++;
            }
        }

        // add the 0 indegree into the queue
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        int i = 0;
        while (!queue.isEmpty()) {
            int element = queue.poll();
            result[i++] = element;
            // remove the indegree for it's neighbours
            for (int neighbour : adjList[element]) {
                indegree[neighbour]--;
                if (indegree[neighbour] == 0) {
                    queue.add(neighbour);
                }
            }
        }

        if (i != numCourses)
            return new int[0];

        return result;

    }
}
