/*
Akbar used to play chess with Birbal almost every evening.
Once Akbar has challanged Birbal to place the queens in each row of the board,
such that no queen should attack another queen on the board.

You are given an integer N, indicates the size of the board as N*N.
Your task is to help Birbal to find and win in this challange, 
if there is a solution, print the answer as shown in the samples
Otherwise, print "No Solution"

Input Format:
-------------
An integer N, size of the chess board.

Output Format:
--------------
Print any possible solution.


Sample Input-1:
---------------
4

Sample Output-1:
----------------
0010
1000
0001
0100

Sample Input-2:
---------------
3

Sample Output-2:
----------------
No Solution */

import java.util.*;

public class NQueenProblem {
	int N;
	/* A utility function to print solution */
    
    //Your utility functions goes here
	void solveNQ(){
	    //Write your code here and return boolean value
	    //Create my board
	    int[][] board=new int[N][N];
	    if(QueenAllocate(board,0)==true){
	        printSolution(board);
	        return;
	    }
	    System.out.println("No Solution");
	}
	
	
	boolean QueenAllocate(int[][] board,int col){
	    //if i made it till the end
	    //if i survived it till the end
	    if(col>=N) return true;
	    
	    //if i am figuring out in the mid way
	    
	    //i will figure out for every possible way
	    
	    //for every row, try everything
	    
	    for(int i=0;i<N;i++){
	        //will check if that is the safe position for the queen to place in?
	        //if it is i will see how the life will turn out if i place the queen
	        //at that position
	        if(isSafe(board,i,col)==true){
	            
	            board[i][col]=1;
	            
	            //if my life is turned out well by placing the queen at this above position
	            //then i will go with it :)
	            if(QueenAllocate(board,col+1)==true) return true;
	            
	            //if my function is not returned anything yet, turns out that, my life 
	            //didn't turn out well by placing the queen position there,
	            //so this is a program, i can always go back and revert my choices and 
	            //decisions
	            
	            board[i][col]=0;//it was not worth it :(
	            //placing the queen at this position
	            //i will explore till the end of this loop
	            //and allow more possibilities of my life to come in.
	            //if it happens it happens , if it doesn't it doesn't.
	            
	        }
	        
	    }
	    //if we didn't find any possibility where all the queens are placed in the correct position
	    //we just return false, that it is not possible
	    return false;
	        
	    
	}
	
	boolean isSafe(int[][] board,int row,int col){
	    //to check wheather i can place my queen there or not.
	    //queen's protection is my first priority
	    
	    int i,j;
	    
	    // will check by left end row
	    
	    for(j=col;j>=0;j--){
	        if(board[row][j]==1) return false;
	    }
	    
	    //will check my left end upper diagonal
	    
	    for(i=row,j=col;i>=0 && j>=0;i--,j--){
	        if(board[i][j]==1) return false;
	    }
	    
	    //will check my left end lower diagonal
	    
	    for(i=row,j=col;i<N && j>=0;i++,j--){
	        if(board[i][j]==1) return false;
	    }
	    
	    return true;
	}

}