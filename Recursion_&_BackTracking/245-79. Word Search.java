class Solution {

    public boolean exist(char[][] board, String word) {
        boolean[][] vis=new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
            if(checkStartingFromHere(i,j,0,vis,word,board)) return true;

        }
        }
        return false;

    }

            boolean checkStartingFromHere(int r,int c,int pos,boolean[][] vis,String word,char[][] board){
            //base condition for success
            int rl=board.length;int cl=board[0].length;

            if(pos==word.length())
                return true;
            
            //base condtion for failure
            if(!inBound(r,c,rl,cl)||vis[r][c]==true||board[r][c]!=word.charAt(pos))
                return false;

            //pick that position because if matches out criteria
            vis[r][c]=true;
            //mark it visited and checkout for all the other different 
            //possibilities
            boolean res=((checkStartingFromHere(r+1,c,pos+1,vis,word,board))
            ||(checkStartingFromHere(r-1,c,pos+1,vis,word,board))
            ||(checkStartingFromHere(r,c+1,pos+1,vis,word,board))
            ||(checkStartingFromHere(r,c-1,pos+1,vis,word,board)));

            //after checking all the possibilities just undo that move 
            //which you marked as visited just as desicplite , that's it
            vis[r][c]=false;

            return res;
            
            
        }
         boolean inBound(int r,int c,int rl,int cl){
            if(r>=0 && r<rl && c>=0 && c<cl) return true;
            return false;
        }

    /*
     * Again this is one of the best backtraking
     * problems i have solved so far
     * the only speacility is too many conditions for the base case
     * out of which the most important highlight is applying
     * backtracking on grid problems using dfs
     * if a possibility is (out of bounds or visited or letter not equal
     * to the desired letter which we want to search)
     * then we will return false because there is no point is proceding
     * further because future is not good with that move
     * so we return false
     * if everything is going well means if the letter is the desired
     * and unvisited and in bounds
     * mark it visited
     * explore all the 4 directions for the solutions
     * there might be multiple answers.
     */
}