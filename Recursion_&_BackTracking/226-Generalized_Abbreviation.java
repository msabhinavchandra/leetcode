import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {
	public static ArrayList < String > findAbbr(String str) {
		// Write your code here.
		ArrayList<String> result=new ArrayList<>();
		helper(str, "", 0, 0, result);
		Collections.sort(result);
		return result;
	}

	//counter, count(for not pick), str (for reference), curr(current string generated)
	public static void helper(String str,String curr,int count,int ptr,
	ArrayList<String> result){
		//base condition for backtracking
		if(ptr==str.length()){
			//if the count is 0
			if(count==0){// that is the not picks are exhausted
			//result is ready to be added
			result.add(curr);
			return;
			}else{//if the not picks are not exhausted and there are still left
			//like p and 2 not picks like count = 2 then do curr+count
			result.add(curr+count);
			return;
			}
		}

		//if there is residue, in the count, when i want to pick, i need to exhaust it 
		//first before i want to pick any letter, first exhaust, then pick a letter

		if(count>0){
		helper(str,curr+""+count+str.charAt(ptr),0,ptr+1,result);
		}else{
		//if the count is 0 then no need to exhaust u can directly pick the char at that ptr
		 helper(str,curr+str.charAt(ptr),0,ptr+1,result);
		}
		//we are exploring for 2 cases that is is pick and if not pick
		//all the above code is for the pick the below one is for not pick
		//if not pick i will increment the residue count, and not add anything to the current

		helper(str,curr,count+1,ptr+1,result);

	}

}

/*
The `Collections.sort(result)` method in your code sorts the ArrayList of strings in natural 
(lexicographical) order. In Java, string comparison is based on lexicographical order, which is 
effectively based on the Unicode values of characters. Here's a detailed explanation of how the 
sorting works:

### Lexicographical Order (ASCII/Unicode Based)
1. **Character-by-Character Comparison**: The strings are compared character by character starting from the 
first character. The comparison continues until a difference is found.
2. **Unicode Values**: Each character has a corresponding Unicode value. For example, the Unicode value for 
'A' is 65, 'B' is 66, 'a' is 97, 'b' is 98, etc.

3. **Sorting Rules**:
   - If the first characters of two strings are different, the string with the smaller Unicode value for the 
   first character is considered smaller.
   - If the first characters are the same, the comparison moves to the second character, and so on.
   - If one string is a prefix of another, the shorter string is considered smaller.

### Example
Given the strings "a1", "a2", "a10", "a11", here is how they are sorted:
- **Step 1**: Compare "a1" with "a2". The first character 'a' is the same, so compare the second character.
 '1' (Unicode 49) is less than '2' (Unicode 50), so "a1" < "a2".
- **Step 2**: Compare "a2" with "a10". The first character 'a' is the same. Compare the second character.
 '2' (Unicode 50) is greater than '1' (Unicode 49), so "a2" > "a10". Hence, "a10" < "a2".
- **Step 3**: Compare "a10" with "a11". The first character 'a' is the same. Compare the second character '1'.
 They are the same. Compare the third character '0' (Unicode 48) is less than '1' (Unicode 49),
  so "a10" < "a11".

So, the sorted order will be: ["a1", "a10", "a11", "a2"].

### Summary
Yes, the sorting is essentially based on the Unicode (previously ASCII) values of characters.
 This method sorts strings lexicographically in a way that might not always align with natural human 
 numeric sorting, especially for alphanumeric strings.

If you need to sort alphanumeric strings in a way that treats numeric parts as numbers 
(e.g., "a10" should come after "a2"), you'd need to implement a custom comparator. 
Let me know if you need more help with that!*/