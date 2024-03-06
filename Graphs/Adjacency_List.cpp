#include <bits/stdc++.h>
#include <iostream>
using namespace std;

// in the adjacency list, we will have a list of lists,where each node(vertex)
// represents index of the list and it's adjacent elements will be stored in that
// list(of it's respective index).

int main()
{
    int n, m;
    cout << "Enter the number of vertices" << endl;
    cin >> n;
    cout << "Enter the number of Edges" << endl;
    cin >> m;
    // timecomplexity=O(2E)because for pair of nodes there is an edge.
    //  1 from one node and the other from the other so we are counting
    // one edge twice in
    // an adjecency list.
    // so therefore the time complexity is twice the number of edges in the graph.
    vector<int> adj[n + 1]; // list of lists, of size n+1(if the vertices
    // starts from 1, the size can be declared n only iff the vertices start from
    //  the zero)
    for (int i = 0; i < m; i++)
    {
        int u, v;
        cout << "Enter the first vertex" << endl;
        cin >> u;
        cout << "Enter the second vertex" << endl;
        cin >> v;
        adj[u].push_back(v);
        adj[v].push_back(u);
    }

    // for printing respective adjacency list.
    // because the vertices start from 0.
    for (int i = 0; i < n; i++)
    {   
        cout<<i<<"-->";
        for(int j=0; j< adj[i].size();j++){
            cout<<adj[i][j]<<",";
        }
        cout<<endl;
    }
    return 0;
}
//output:
// 0-->3,1,2,
// 1-->0,2,
// 2-->0,1,
// 3-->0,

// --------------------------------------------------------------------------------------

//almost the same program but for the 1-based indexing
#include <bits/stdc++.h>
#include <iostream>
using namespace std;

// in the adjacency list, we will have a list of lists,where each node(vertex)
// represents index of the list and it's adjacent elements will be stored in that
// list(of it's respective index).

int main()
{
    int n, m;
    cout << "Enter the number of vertices" << endl;
    cin >> n;
    cout << "Enter the number of Edges" << endl;
    cin >> m;
    // timecomplexity=O(2E)because for pair of nodes there is an edge.
    //  1 from one node and the other from the other so we are counting
    // one edge twice in
    // an adjecency list.
    // so therefore the time complexity is twice the number of edges in the graph.
    vector<int> adj[n + 1]={{}}; // list of lists, of size n+1(if the vertices
    // starts from 1, the size can be declared n only iff the vertices start from
    //  the zero)
    for (int i = 0; i < m; i++)
    {
        int u, v;
        cout << "Enter the first vertex" << endl;
        cin >> u;
        cout << "Enter the second vertex" << endl;
        cin >> v;
        adj[u].push_back(v);
        adj[v].push_back(u);
    }

    // for printing respective adjacency list.
    // because the vertices start from 0.
    // cout<<adj;
    for (int i = 1; i <= n; i++)
    {   
        cout<<i<<"-->";
        //In C++, vectors are zero-indexed, meaning that
        //elements are indexed from 0 to size-1.
        for(int j=0; j< adj[i].size();j++){
            cout<<adj[i][j]<<",";
        }
        cout<<endl;
    }
    return 0;
}
