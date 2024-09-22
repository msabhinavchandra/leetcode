/*
A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down). 
A strobogrammatic number must consist of only the digits 0, 1, 6, 8, and 9. 
Each of these digits either remains the same or transforms into another valid strobogrammatic digit when rotated:
	0 rotates to 0
	1 rotates to 1
	6 rotates to 9
	8 rotates to 8
	9 rotates to 6

Given an integer n, print all prime strobogrammatic numbers that are of length n 
and print smallest and largest strobogrammatic numbers of length n.

Input Format:
-------------
Line-1: A single integer n, representing the length of the strobogrammatic numbers to generate.

Output Format:
--------------
Line-1: Return a list of all prime strobogrammatic numbers of length n.
Line-2: Space separated two values, smallest and largest strobogrammatic numbers of length n.

Constraints:
------------
1 ≤ n ≤ 14


Sample Input-1:
---------------
2

Sample Output-1: 
----------------
[11]
11 96


Sample Input-2:
---------------
5

Sample Output-2: 
----------------
[16091, 18181, 19861, 61819]
10001 99866

Sample Input-3:
---------------
4

Sample Output-3: 
----------------
[]
1001 9966

NOTE: Print the results in sorted order to pass the testcases */