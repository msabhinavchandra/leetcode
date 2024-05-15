class Solution(object):
    def majorityElement(self, nums):
        d={}
        for i in range(len(nums)):
            if nums[i] in d:
                d[nums[i]]=d[nums[i]]+1
            else:
                d[nums[i]]=1
        for i in d.keys():
            if d[i]>len(nums)/2:
                return i
#alternate
class Solution(object):
    def majorityElement(self, nums):
        d={}
        for i in nums:
            if i not in d:
                d[i]=1
            else:
                d[i]+=1
        for i in d.keys():
            if d[i]>len(nums)/2:
                return i
        """
        :type nums: List[int]
        :rtype: int
        """
