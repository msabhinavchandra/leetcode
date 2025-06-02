package TopoSort;

import java.util.*;

class ParallelCourses {
    public int minimumSemesters(int numCourses, int[][] prerequisites, int maxCourses) {
        // create an adjacency list to represent the graph
        int graph[][] = new int[numCourses + 1][numCourses + 1];
        int[] indegree = new int[numCourses + 1];

        // populate the adjacency list using the prerequisites array
        for (int[] prerequisite : prerequisites) {
            int u = prerequisite[0];
            int v = prerequisite[1];
            graph[u][v] = 1;
            indegree[v]++;
        }
        // Perform a topological sort to find the order in which the courses should be
        // taken
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        int semesters = 0;
        int coursesTaken = 0;
        while (!queue.isEmpty()) {
            int coursesThisSemester = Math.min(queue.size(), maxCourses);
            for (int i = 0; i < coursesThisSemester; i++) {
                int u = queue.poll();
                coursesTaken++;
                for (int v = 1; v <= numCourses; v++) {
                    if (graph[u][v] == 1 && --indegree[v] == 0)
                        queue.add(v);
                }
            }
            semesters++;
        }
        if (coursesTaken != numCourses) {
            return -1; // cannot complete all courses
        }
        return semesters;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int numCourses = s.nextInt();
        int c = s.nextInt();
        int prerequisites[][] = new int[c][2];
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < 2; j++) {
                prerequisites[i][j] = s.nextInt();
            }
        }
        int maxCourses = s.nextInt();
        ParallelCourses p = new ParallelCourses();
        System.out.println(p.minimumSemesters(numCourses, prerequisites, maxCourses));
    }
}