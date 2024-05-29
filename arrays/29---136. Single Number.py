class Solution(object):
    def singleNumber(self, nums):
        d={}
        for i in range(len(nums)):
            if nums[i] not in d:
                d[nums[i]]=1
            else:
                d[nums[i]]+=1

        for i in d:
            if d[i]==1:
                return i
#alternate
class Solution(object):
    def singleNumber(self, nums):
        d={}
        for i in nums:
            if i not in d:
                d[i]=1
            else:
                d[i]+=1

        for i in d.keys():
            if d[i]==1:
                return i
        """
        :type nums: List[int]
        :rtype: int
        """

#alternate #KrishnaPriya
class Solution(object):
    def singleNumber(self, nums):
        ans=0
        for i in range(len(nums)):
            ans=nums[i]^ans
        # xor operation-->same ^ same = 0
        # anything ^ 0 = anything.
        return ans

        """
        :type nums: List[int]
        :rtype: int
        """

