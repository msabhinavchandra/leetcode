class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        int n = rooms.size();// no of rooms

        boolean[] visited = new boolean[n];

        // Applying BFS

        Queue<List<Integer>> queue = new LinkedList<>();

        queue.add(rooms.get(0));

        // We are assuming that 0 is always visited.

        visited[0] = true;

        while (!queue.isEmpty()) {
            List<Integer> room = queue.poll();
            // whatever i am polling from the queue all are visited already
            // i am polling them to check their neighbours
           
            for (Integer a : room) {
                if (!visited[a]) {
                    visited[a] = true;
                    queue.add(rooms.get(a));
                }
            }
           
        }

        for (boolean t : visited) {
            if (!t)
                return false;
        }
        return true;

    }
}