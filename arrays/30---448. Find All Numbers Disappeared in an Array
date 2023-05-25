class Solution(object):
    def findDisappearedNumbers(self, nums):
        d={}
        d2={}
        l=[]
        for i in range(len(nums)):
            if nums[i] not in d:
                d[nums[i]]=1
            else:
                d[nums[i]]+=1
        for i in range(len(nums)):
            d2[i+1]=1
        for i in d2:
            if i not in d:
                l.append(i)
        return l
#alternate
class Solution(object):
    def findDisappearedNumbers(self, nums):
        leng=len(nums)
        d={}
        # nums=list(set(nums))
        for i in nums:
            if i not in d:
                d[i]=1
            else:
                d[i]+=1

        l=[]
        for i in range(1,leng+1):
            if i not in d:
                l.append(i)
        return l

        """
        :type nums: List[int]
        :rtype: List[int]
        """
