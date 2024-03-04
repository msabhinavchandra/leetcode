//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution {
  public: 
    vector<int> shortestPath(int n, int m, vector<vector<int>>& edges) {
        //time complexity == ElogV + O(n),for the
        //backtracking, similar to djisk's algorithm
        //i am given with the number of nodes-->n
        //it is a 1-based indexing array
        //there are m edges 
        //edges are given in the vector form
        //we need to convert them into a graph(adjacency lists)
        
        //initializing the graph list of vector,where each element in 
        //the vector is a pair,because this is a weighted graph.
        vector<pair<int,int>> adj[n+1];//because this graph is 
        //1-based indexing
        for(auto it:edges){
            adj[it[0]].push_back({it[1],it[2]});
            adj[it[1]].push_back({it[0],it[2]});
        }//my graph it created by the end of the loop
        
        //declaring a priority queue(min heap) to implement dijk algorithm
        priority_queue<pair<int,int>,
        vector<pair<int,int>>,greater<pair<int,int>>> pq;
        
        //declaring the distance array 
        //because it is 1-based indexing,we will declare size as n+1
        // and initialize all the elements to 1e9.
        //not only the distance we also need a parent which will
        //store from where it is coming from.of the same size
        vector<int> dist(n+1,1e9),parent(n+1);
        for(int i=1;i<=n;i++) parent[i]=i;
        //in the parent array we are setting 
        //parent[node]=node kinda of a thing so that
        //we can stop the iteration whenever the parent[node]=node.
        //for any general souce condition
        //but anyhow 1 is the given source condition anyways
        
        //the source node is always 1 so 
        //the distance between the source and the source is 0
        //so
        dist[1]=0;
        //pushing this for the initial condition
        pq.push({0,1});//because it is mentioned for the source always 
        // equal to one but please do consider to find how to 
        //solve the same question for different sources.
        while(!pq.empty()){
            auto it=pq.top();
            int node=it.second;//because that was a pair i take things like
            //this
            int dis=it.first;
            pq.pop();
            
            for(auto it:adj[node]){
                int adjNode=it.first;//because it is a list of 
                //vectors,where every element in
                //the vector can store pairs
                //because this is a weighted graph.
                int edW=it.second;
                //i to need to use the syntax of the pair
                if(dis+edW<dist[adjNode]){
                    dist[adjNode]=dis+edW;
                    pq.push({dist[adjNode],adjNode});
                    //now small change is we also need to store
                    //where it is coming from also.
                    parent[adjNode]=node;
                }//end of if statement
            }//end of for-loop
        } //end while-loop.
        //if the final node is not at all visited from the 
        //source then obviously there will be no distance that will
        //be stored for that respective node in the distance array
        if(dist[n]==1e9) return {-1};
        //if the distance of the last node is not 1e9 then there exists
        // a path which can go from the source to the last node.
        //so there exists a path so just let me declare it
        vector<int> path;
        int node=n;
        while(parent[node]!=node){
            path.push_back(node);
            node=parent[node];
        }
        //at the end we will arrive at a point where parent[node]==node.
        //that the end node start of the source node.
        //actually the source node is also the part of the path
        //only that's why we will add that also.
        path.push_back(node);
        path.push_back(dist[n]);
        //this is how you reverse an array in cpp.
        reverse(path.begin(),path.end());
        return path;
        
    }
};

//{ Driver Code Starts.
int main() {
    // your code goes here
    int t;
    cin >> t;
    while (t--) {
        int n, m;
        cin >> n >> m;
        vector<vector<int>> edges;
        map<pair<int,int>,int> mp;
        for (int i = 0; i < m; ++i) {
            vector<int> temp;
            for (int j = 0; j < 3; ++j) {
                int x;
                cin >> x;
                temp.push_back(x);
            }
            edges.push_back(temp);
            mp[{edges.back()[0],edges.back()[1]}] = edges.back()[2];
            mp[{edges.back()[1],edges.back()[0]}] = edges.back()[2];
        }

        Solution obj;
        vector<int> res = obj.shortestPath(n, m, edges);
        int ans=0;
        for(int i=2;i<res.size();i++)
        {
            ans+=mp[{res[i],res[i-1]}];
        }
        if(res.size()==1) ans=res[0];
        cout<<ans<<endl;
    }
}

// } Driver Code Ends