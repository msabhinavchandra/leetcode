import java.util.*;

class Pair{
    int node;
    int dist;
    Pair(int dist,int node){
        this.dist=dist;
        this.node=node;
    }
}

class Solution{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        //Take inputs
        int size=sc.nextInt();
        int[][] adjMat=new int[size][size];
        
        //taking input values
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                adjMat[i][j]=sc.nextInt();
            }
        }//end of taking input values.
        
        int src=sc.nextInt();
        
        int[] result=dijkstraAlgorithm(adjMat,src,size);
        
        System.out.println("Vertex           Distance from Source");
        for(int i = 0;i<result.length;i++){
            System.out.println(i + "                " + result[i]);
        }
        
        
    }//end of main method.
    
    public static int[] dijkstraAlgorithm(int[][] adjMat,int start,int size){
        //initialize PQ(Min-Heap)
        //Syn->PriorityQueue<Obj> name=new PriorityQueue<Pair>(comparator) x,y x-y->ASC && y-x-> DESC.
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x,y) -> x.dist - y.dist);
        //initiaze min dist array
        int[] minDist=new int[size];
        Arrays.fill(minDist,Integer.MAX_VALUE);
       
        minDist[start]=0;//because it is there only.
        //Add the first element into the queue.
        pq.add(new Pair(0,start));
        
    
        //and the rest all initialize to MAX_VALUE becuase we need min dist.
        
        while(pq.size()!=0){//while pq not equal to null(empty)
            
            //pop element from there
            int dist=pq.peek().dist;//distance till here.
            int node=pq.peek().node;
            pq.remove();
            
            //find all it's adjacent nodes(yes iterate i mean :) )
            
            for(int i=0;i<size;i++){//iterate for all nodes, take for only that, for which 
            //is actually the edge of the required node, coming from above.
            //you will add distance till here to from here to the destination.
            if(adjMat[node][i]!=0 && dist+adjMat[node][i]<minDist[i]){
                minDist[i]=dist+adjMat[node][i];
                pq.add(new Pair(minDist[i],i));
            }
            
            //whenever you find the way(dist) to a node is lesser than the curr dist array value 
            //of that node, then update it, update the dist array with the new min dist.
            
            //whenever you update the new min distance add it to the pq along with the updated dist of that
            //node.
            
            //do it till the queue becomes empty.
            
            }//end of for loop
        
        //return the dist array.
        
        
        }//end of while loop
    
    return minDist;
}//end of function. dijkstra

}//end of class Solution.