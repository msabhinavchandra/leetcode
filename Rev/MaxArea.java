import java.util.LinkedList;
import java.util.Queue;
class Solution
{
    //Function to find unit area of the largest region of 1s.
    public int findMaxArea(int[][] grid)
    {
        // Code here
        int rowL=grid.length;
        int colL=grid[0].length;
        boolean[][] vis=new boolean[rowL][colL];
        int[] rowbuf={0,1,-1,0,1,-1,1,-1};
        int[] colbuf={1,0,0,-1,-1,1,1,-1};
        Queue<Pair> queue=new LinkedList<>();
        int maxArea=0;
        
        for(int i=0;i<rowL;i++){
            for(int j=0;j<colL;j++){
                
                if(grid[i][j]==1 && vis[i][j]==false){
                    queue.add(new Pair(i,j));
                    vis[i][j]=true;
                    //try out bfs to find the area from here
                    int currArea=0;
                    
                    while(!queue.isEmpty()){
                        Pair p=queue.poll();
                        currArea++;
                        int row=p.row;
                        int col=p.col;
                        //explore the neighbours
                        for(int k=0;k<8;k++){
                            int nr=row+rowbuf[k];
                            int nc=col+colbuf[k];
                            
                            if(inBound(nr,nc,rowL,colL)&&grid[nr][nc]==1&&vis[nr][nc]==false){
                             
                             vis[nr][nc]=true;
                             queue.add(new Pair(nr,nc));
                            
                        }
                        
                    }
                    
                } maxArea=Math.max(currArea,maxArea);
                
            }
        }
        
    }
    
  
    return maxArea;
 
}

 public boolean inBound(int r,int c,int rl,int cl){
        
        if(r>=0 && r<rl && c>=0 && c<cl) return true;
        
        return false;
        
    }

   class Pair{
        int row;
        int col;
        Pair(int r,int c){
            row=r;
            col=c;
        }
    }

}