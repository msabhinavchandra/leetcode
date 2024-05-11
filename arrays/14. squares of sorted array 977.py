class Solution(object):
    def sortedSquares(self, nums):
        for i in range(len(nums)):
            nums[i]=nums[i]**2

        return sorted(nums)
    
#alternate 
class Solution:
    def sortedSquares(self, nums: List[int]) -> List[int]:
        for i,n in enumerate(nums):
            nums[i]=n**2

        nums=sorted(nums)
        return nums
