class Solution {

    int countDistinctIslands(int[][] grid) {
        // Your Code here
        int rowL=grid.length;
        int colL=grid[0].length;
        Set<List<String>> set=new HashSet<>();
        boolean[][] visited=new boolean[rowL][colL];
        
        for(int i=0;i<rowL;i++){
            for(int j=0;j<colL;j++){
                
                if(grid[i][j]==1 && visited[i][j]==false){
                    List<String> shape=new ArrayList<>();
                    bfs(grid,i,j,shape,visited);
                    set.add(shape);
                }
            }
        }
        
        return set.size();
        
    }
    
    void bfs(int[][] grid,int r,int c,List<String> shape,boolean[][] visited){
        int rowL=grid.length;
        int colL=grid[0].length;
        Queue<Pair> queue=new LinkedList<>();
        queue.add(new Pair(r,c));
        int[] rowbuf={0,1,-1,0};
        int[] colbuf={1,0,0,-1};
        
        while(!queue.isEmpty()){
            Pair p=queue.poll();
            int row=p.row;
            int col=p.col;
            shape.add(conString(row-r,col-c));
            //now explore all it's neighbours
            for(int i=0;i<4;i++){
                int nr=row+rowbuf[i];
                int nc=col+colbuf[i];
                if(inBound(nr,nc,rowL,colL)&&grid[nr][nc]==1&&visited[nr][nc]==false){
                    visited[nr][nc]=true;
                    queue.add(new Pair(nr,nc));
                }
            }
            
        }
        
    }
    
    String conString(int r,int c){
        return r+" "+c;
    }
    
    boolean inBound(int r,int c,int rl,int cl){
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