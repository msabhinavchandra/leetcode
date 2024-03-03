//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution
{//the only difference between this approach and the pq is that
//over here we will be deleting the element from the set as 
//we are going to add a better pair from the set simultaneouly
//which will save an iteration for us,that's the only difference
	public:
	//Function to find the shortest distance of all the vertices
    //from the source vertex S.
    vector <int> dijkstra(int V, vector<vector<int>> adj[], int S)
    {
        set<pair<int,int>> st;//and i initializing the set
        //so store my (shortdistance,node)
        //will interate till it's empty.
        vector<int> dist(V,1e9);
        //this above command will intialize a vector array of the 
        //name dist,of size V, where every element in that
        //array is 1e9 which is almost infinity
        //a big number in cpp
        st.insert({0,S});
        dist[S]=0;
        
        while(!st.empty()){
            
            auto it=*(st.begin());
//st.begin(), will be my pointer which points towards the begining
//element of my set(the set will store all the elements in the
//ascending order.of the distance.)so to find the value that is stored
//inside the address,we are dereferencing it with the * that's it.
    int node=it.second;
    int dis=it.first;
    st.erase(it);
    for(auto it:adj[node]){
        int adjNode=it[0];
        int edgW=it[1];
        
        if(dis+edgW<dist[adjNode]){
            //erase if it existed.
            if(dist[adjNode]!=1e9){
                st.erase({dist[adjNode],adjNode});
            }
            dist[adjNode]=dis+edgW;
            st.insert({dist[adjNode],adjNode});
        }
        
    }
            
        }
        
        return dist;
    }
};


//{ Driver Code Starts.


int main()
{
    int t;
    cin >> t;
    while (t--) {
        int V, E;
        cin >> V >> E;
        vector<vector<int>> adj[V];
        int i=0;
        while (i++<E) {
            int u, v, w;
            cin >> u >> v >> w;
            vector<int> t1,t2;
            t1.push_back(v);
            t1.push_back(w);
            adj[u].push_back(t1);
            t2.push_back(u);
            t2.push_back(w);
            adj[v].push_back(t2);
        }
        int S;
        cin>>S;
        
        Solution obj;
    	vector<int> res = obj.dijkstra(V, adj, S);
    	
    	for(int i=0; i<V; i++)
    	    cout<<res[i]<<" ";
    	cout<<endl;
    }

    return 0;
}


// } Driver Code Ends