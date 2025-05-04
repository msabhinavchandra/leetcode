#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
#include <stack>
#include <set>
#include <map>
#include <vector>
using namespace std;

class Solution
{
private:
    void dfs(int node, vector<int> adj[], int vis[], vector<int> &ls)
    {
        vis[node] = 1;
        ls.push_back(node);
        // traverse all its neighbours
        for (auto it : adj[node])
        {
            // if the neighbour is not visited
            if (vis[it] == 0)
            {
                dfs(it, adj, vis, ls);
            }
        }
    }

public:
    // Function to return a list containing the DFS traversal of the graph.
    // it intakes the number of Vertices and the adjacency List
    vector<int> dfsOfGraph(int V, vector<int> adj[])
    {
        vector<int> vis(V, 0); // assuming it starts from 0
        int start = 0;
        // create a list to store dfs
        vector<int> ls;
        // call dfs for starting node
        // dfs(start, adj, vis, ls);
        return ls;
    }
};

void addEdge(vector<int> adj[], int u, int v)
{
    adj[u].push_back(v);
    adj[v].push_back(u);
}

void printAns(vector<int> &ans)
{
    for (int i = 0; i < ans.size(); i++)
    {
        cout << ans[i] << " ";
    }
}

int main()
{
    vector<int> adj[5];

    addEdge(adj, 0, 2);
    addEdge(adj, 2, 4);
    addEdge(adj, 0, 1);
    addEdge(adj, 0, 3);

    Solution obj;
    vector<int> ans = obj.dfsOfGraph(5, adj);
    printAns(ans);

    return 0;
}

// -------------------------------------------------------------------------

// this is a successfull DFS of a graph for any source node.

void Dfs(int node, vector<int> &Vis, vector<int> adj[], vector<int> &dfs)
{
    Vis[node] = 1;
    dfs.push_back(node);
    for (auto it : adj[node])
    {
        if (!Vis[it])
        {
            Dfs(it, Vis, adj, dfs);
        }
    }
}

vector<int> dfsOfGraph(vector<int> adj[], int S, int V)
{
    vector<int> Vis(V, 0); // 0-based indexing
    vector<int> dfs;       // where the answer of dfs will be stored.
    Dfs(S, Vis, adj, dfs);
    return dfs;
}

void addEdge(vector<int> adj[], int n, int m)
{

    adj[n].push_back(m);
    adj[m].push_back(n);
}

void PrintAns(vector<int> ans)
{
    for (int i = 0; i < ans.size(); i++)
    {
        cout << ans[i] << " ";
    }
}

int main()
{
    vector<int> adj[7];
    addEdge(adj, 0, 1);
    addEdge(adj, 1, 2);
    addEdge(adj, 2, 3);
    addEdge(adj, 3, 1);
    addEdge(adj, 3, 4);
    addEdge(adj, 3, 6);
    addEdge(adj, 6, 5);
    addEdge(adj, 4, 5);
    vector<int> dfs = dfsOfGraph(adj, 2, 7);
    PrintAns(dfs);

    return 0;
}