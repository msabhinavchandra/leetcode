class Solution(object):
    def maxSubArray(self, nums):
     sum1=0
    #  max=-10001
    #  if len(nums)==1:
    #      max=nums[0]
    #      return max
     max1=nums[0]
     for i in nums:
         if sum1<0:
             sum1=0
         sum1=sum1+i
         max1=max(sum1,max1)
     
     return max1
#alternate
class Solution(object):
    def maxSubArray(self, nums):
        maxsum=nums[0]
        cursum=0
        for n in nums:
            if cursum<0:
                cursum=0
            cursum=cursum+n
            maxsum=max(cursum,maxsum)
        return maxsum
        """
        :type nums: List[int]
        :rtype: int
        """
