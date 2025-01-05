//Recursion

// Java program to find the shortest possible route
// that visits every city exactly once and returns to
// the starting point using memoization and bitmasking

import java.util.*;

class GfG {

    static int totalCost(int mask, int pos, int n,
            int[][] cost) {

        if (mask == (1 << n) - 1) {
            return cost[pos][0];
        }

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if ((mask & (1 << i)) == 0) {

                ans = Math.min(
                        ans, cost[pos][i]+ totalCost(mask | (1 << i), i,n, cost));
            }
        }

        return ans;
    }

    static int tsp(int[][] cost) {
        int n = cost.length;

        // Start from city 0, and only city 0 is
        // visited initially (mask = 1)
        return totalCost(
                1, 0, n,
                cost);
    }


}

// Memoization

public class TSPDP {
    static int n;
    static int[][] distance;
    static int allCityVisited;
    static int[][] dp;

    /*
     * To avoid overlapping subproblems i.e. avoiding a state which has already been
     * computed,
     * we check dp[mask][currCity]. If this comes out to be -1, implies the city
     * hasn't been visited,
     * else the city has already been visited and we return dp[mask][currCity] =
     * ans.
     */
    static int tsp(int mask, int currCity) {
        // If all cities are visited, return the distance from last city to first one
        if (mask == allCityVisited) {
            return distance[currCity][0];
        }
        // If we arrive at a city which is already been computed
        if (dp[mask][currCity] != -1) {
            return dp[mask][currCity];
        }
        // Here we will try to go to every other city to take the minimum answer
        int minDis = Integer.MAX_VALUE;
        // Visiting the unvisited cities
        for (int city = 0; city < n; city++) {
            // Checking if city has been visited or not, by checking ith bit in mask
            if ((mask & (1 << city)) == 0) {
                // Changing the city as visited (visited nask)
                int vmask = mask | (1 << city);
                /*
                 * Storing the distance of current city to the city and then
                 * fetchingremaining distance from recursive call.
                 */
                int dist = distance[currCity][city] + tsp(vmask, city);
                // Storing the shortest distance
                minDis = Math.min(minDis, dist);
            }
        }
        return dp[mask][currCity] = minDis;
    }

    // Initially we make a 2D array of [2^n][n] and initially put -1 at each
    // position
    static int getMinPath_TSP() {
        dp = new int[1 << n][n];
        allCityVisited = (1 << n) - 1;
        for (int i = 0; i < (1 << n); i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        return tsp(1, 0);
    }

}
