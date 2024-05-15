# 2 sum 
# abhinav:
class Solution(object):#over here we are using nested for loop and trying to iterate for each and every element
    def twoSum(self, nums, target):#but itself thats why we have i!=j in the line 7 we will check for the existing
        for i in range(len(nums)):#elements to the next furthur elements and if they both add up to the target 
            for j in range(len(nums)):#we will return the respective (i,j) tuple as list.
                if nums[i]+nums[j]==target and i!=j:#
                    return list((i,j))#

                  
# NEETCODE:
class Solution(object):#we are maintaining a hash table for the visited elements list.and checking the difference
    def twoSum(self, nums, target):#of the target and the existing element,wheather it exists in the hash map or not.
        d={}#if it existing the function will return the list of the indices of that existing element and the
        for i,n in enumerate(nums):#difference element in the hash table(diff=target-n,it return n,i basically).
            diff=target-n#otherwise that respective element will be added to the hash map,so that in the next
            if diff in d:#iterations it will check wheather the diff of the target and the end,present in the
                return [d[diff],i]#hash table or not....
            d[n]=i#



