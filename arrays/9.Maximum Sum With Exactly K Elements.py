# 2656 leetcode.
class Solution(object):
    def maximizeSum(self, nums, k):
        if 1<=k<=100:
            pass
            summ=0
            if 1<=len(nums)<=100:
                pass
                for i in range(len(nums)):
                    if 1<=nums[i]<=100:
                        pass
                    else:
                        return 0
                    for j in range(k):
                        # v=len(nums)-1
                        # g=nums[v]
                        k=max(nums)+j
                        summ=summ+k
                        # nums[v]=g+1
                        k=k+1
                        # nums.replace(g,g+1)
                        
                    return summ
                    
                   
            else:
                return 0
        else:
            return 0
        
#alternate
class Solution(object):
    def maximizeSum(self, nums, k):
        sum=0
        nums=sorted(nums)
        for i in range(k):
            sum=sum+nums[-1]
            nums[-1]=nums[-1]+1
        return sum


        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
