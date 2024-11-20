/*
You are given a binary tree with unique values for its nodes and two distinct nodes p and q. 
Your task is to find the Lowest Common Ancestor (LCA) of these two nodes.

The Lowest Common Ancestor is defined as the deepest node in the binary tree 
that has both p and q as descendants (where a node can be a descendant of itself).

Input Format:
-------------
Line-1: A list of integers (space-separated) representing the binary tree in level order traversal. 
Line-2: Two integers p and q, representing the values of the two nodes for which the LCA is to be determined.

NOTE: Use -1 for null nodes.

Output Format:
--------------
Line-1: Print the value of the Lowest Common Ancestor.

Sample Input-1:
---------------
3 5 1 6 2 0 8 -1 -1 7 4
5 1

Sample Output-1:
----------------
3

Sample Input-2:
---------------
3 5 1 6 2 0 8 -1 -1 7 4
5 4

Sample Output-2:
----------------
5
*/
import java.util.*;
