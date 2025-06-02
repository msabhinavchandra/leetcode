package TopoSort;

import java.util.*;

class Solution {
  // Function to return list containing vertices in Topological order.
  static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
    int indegree[] = new int[V];
    for (int i = 0; i < V; i++) {
      for (int it : adj.get(i)) {
        indegree[it]++;
      }
    }

    Queue<Integer> q = new LinkedList<Integer>();
    // Adding all the nodes with indegree 0
    // to the queue
    for (int i = 0; i < V; i++) {
      if (indegree[i] == 0) {
        q.add(i);
      }
    }

    int topo[] = new int[V];
    int i = 0;
    while (!q.isEmpty()) {
      int node = q.peek();
      q.remove();
      topo[i++] = node;
      // node is in your topo sort
      // so please remove it from the indegree

      for (int it : adj.get(node)) {
        indegree[it]--;
        if (indegree[it] == 0) {
          q.add(it);
        }
      }
    }

    return topo;
  }
}

class tUf {
  public static void main(String[] args) {
    int V = 6;
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    for (int i = 0; i < V; i++) {
      adj.add(new ArrayList<>());
    }
    adj.get(2).add(3);
    adj.get(3).add(1);
    adj.get(4).add(0);
    adj.get(4).add(1);
    adj.get(5).add(0);
    adj.get(5).add(2);

    int[] ans = Solution.topoSort(V, adj);
    for (int node : ans) {
      System.out.print(node + " ");
    }
    System.out.println("");
  }
}

// my way of writing

class Solution2 {
  public int[] topoSort(int V, List<List<Integer>> adj) {
    Queue<Integer> queue = new LinkedList<>();
    int[] indegee = new int[V];
    int[] result = new int[V];
    int ptr = 0;
    for (List<Integer> neighbors : adj) {
      for (int each : neighbors)
        indegee[each]++;
    }
    for (int i = 0; i < V; i++) {
      if (indegee[i] == 0)
        queue.add(i);
    }
    while (!queue.isEmpty()) {
      int element = queue.poll();
      result[ptr++] = element;
      // negate the neighbors
      for (int n : adj.get(element)) {
        indegee[n]--;
        if (indegee[n] == 0)
          queue.add(n);
      }
    }
    return result;
  }
}
