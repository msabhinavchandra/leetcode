//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;
//this is implementation of the Dijkstra's algorithm with the help of a 
//priority queue.
//TC-->Elog(V)ddd
//this is not at all applicable for the negative distances.
// } Driver Code Ends
class Solution
{
	public:
	//Function to find the shortest distance of all the vertices
    //from the source vertex S.
    vector <int> dijkstra(int V, vector<vector<int>> adj[], int S)
    {   
        //decalaring a priority queue,min heap for storing the 
        // pairs of the nodes along with the shortest distance
        priority_queue<pair<int,int>,vector<pair<int,int>>,
        greater<pair<int,int>>> pq;
        //and this is how you initialize an vector
        //array with the help of size.
        vector<int> dist(V);//we always had a distance array
        //of the same size.
        //mark every value as infinite.
        //in our case,infinite is a very very large value.
        for(int i=0;i<V;i++) dist[i]=1e9;
        // 1e9 represents 10^9 large number.
        dist[S]=0;//the distance of the source node from the source node is 
        //always zero.
        pq.push({0,S});//the things are stored in the form of
        //a pair where the pair is in the form of(distance,node).
        //now we completed for all the base conditions and set them be it 
        //for the priority queue as well as for the distance array.
        //now we will loop,keep iterating through the priority queue 
        //till it's empty.
        while(!pq.empty()){
            //now i will take the distance of the top() element and the 
            //node of it
            int dis=pq.top().first;
            int node=pq.top().second;
            //once i am taken i will erase that element from the priority queue.
            pq.pop();
            
            //now traverse for all the adjacency nodes for the curr respective.
            //node.
            for(auto it: adj[node]){
                //the way the things are stored in the adjacency
                // are different from the way the things aree stored in the
                //pair of a priority so please don't get confused.
                //yes the order is quite different when it comes to the
                // priority -->(shortest_distance,node).
                int edgeWeight=it[1];
                int adjNode=it[0];
                
                //we will check the distance in the pre-existing set of 
                //the places to check wheather it is lesser than them or 
                //not if they are less we naturally replace them.
                if(dis+edgeWeight<dist[adjNode]){
                    dist[adjNode]=dis+edgeWeight;
                    pq.push({dist[adjNode],adjNode});
                }//end of if statement.
                
            }//end of for-loop
            
        }//end of while loop.
        
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
