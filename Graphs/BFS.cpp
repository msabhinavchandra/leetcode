#include <bits/stdc++.h>
using namespace std;

class Solution {
  public:
    //Function to return Breadth First Traversal of given graph.
    //takes in the number of vertices and the adjacency lists.
    vector<int> bfsOfGraph(int V, vector<int> adj[]) {
        int vis[V] = {0}; //we are considering the 0-based indexing obviously
        vis[0] = 1; //we are starting from 0, obviously
        //learn how to start from any source also
        //i think i will be just a small change,that's it, i think you will take the source as
        //a parameter in the function and replace the 0 with the source ig.
        queue<int> q;
        // push the initial starting node 
        q.push(0); //add the source into the queue.
        vector<int> bfs; //an array to store the elements traversed through BFS.
        // iterate till the queue is empty 
        while(!q.empty()) {
           // get the topmost element in the queue 
            int node = q.front(); 
            q.pop(); 
            bfs.push_back(node); 
            // traverse for all its neighbours 
            for(auto it : adj[node]) {
                // if the neighbour has previously not been visited, 
                // store in Q and mark as visited 
                if(vis[it]==0) {
                    vis[it] = 1; 
                    q.push(it); 
                }
            }
        }
        return bfs; 
    }
};

void addEdge(vector <int> adj[], int u, int v) {
    adj[u].push_back(v);
    adj[v].push_back(u);
}

void printAns(vector <int> &ans) {
    for (int i = 0; i < ans.size(); i++) {
        cout << ans[i] << " ";
    }
}

int main() 
{
    vector <int> adj[6];
    
    addEdge(adj, 0, 1);
    addEdge(adj, 0, 2);
    addEdge(adj, 0, 3);
    addEdge(adj, 2, 4);

    Solution obj;
    vector <int> ans = obj.bfsOfGraph(5, adj);
    printAns(ans);

    return 0;
}

// -------------------------------------------------------------------------------
// this program is for any-source.
#include<iostream>
#include<vector>
#include<queue> 
using namespace std;

vector<int> bfsOfGraph(int V,vector<int> adj[],int S){
    vector<int> bfs;
    queue<int> que;
    //
    vector<int> Vis(V,0);
    Vis[S]=1;
    que.push(S);
    while(!que.empty()){
        int res=que.front();
        bfs.push_back(res);
        que.pop();
        for(auto it:adj[res]){
            if(!Vis[it]){
                Vis[it]=1;
                que.push(it);
            }
        }
    }
    return bfs;

}

void addEdge(vector<int> adj[],int n,int m){
    adj[n].push_back(m);
    adj[m].push_back(n);
}

void printAns(vector<int> ans){
for(int i=0;i<ans.size();i++){
    cout<<ans[i]<<" ";
}
}

int main()
{   
    vector <int> adj[5];
    addEdge(adj, 0, 1);
    addEdge(adj, 0, 2);
    addEdge(adj, 0, 3);
    addEdge(adj, 2, 4);

vector <int> ans =bfsOfGraph(5,adj,3);
printAns(ans);
    
    return 0;
}