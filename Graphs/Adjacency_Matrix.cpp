// representation of matrix in an adjacency matrix and printing 
//simultaneously
#include <iostream>
#include <bits/stdc++.h>
using namespace std;

// for n vertices and m edges in the respective graph

int main()
{
    int n, m;
    cout << "Enter the number of Vertices in the graph" << endl;
    cin >> n;
    cout << "Enter the number of edges in the graph" << endl;
    cin >> m;//initializing all the elments in the 2d array to 0.
    int adj[n + 1][n + 1]={{0}}; // if the numbering is 1 based/ take it adj[n][n] if the
                           // numbering is 0 based.
    for (int i = 0; i < m; i++)
    { // i am adding all those vertices into the adjacency matrix
        int u, v;
        cout << "Enter the first vertex" << endl;
        cin >> u;
        cout << "Enter the second vertex" << endl;
        cin >> v;
        adj[u][v] = 1;
        adj[v][u] = 1; // removed in the case of directed graph.
    }

    // printing the adjacent matrix
//because this is 1-based indexing elements will start from 1 to n.(unlike 
//zero-based 0 to n-1).
    for (int i = 1; i <= n; i++)
    {
        for (int j = 1; j <= n; j++)
        {
            cout << adj[i][j] << " ";
        }
        cout << endl;
    }

    return 0;
}