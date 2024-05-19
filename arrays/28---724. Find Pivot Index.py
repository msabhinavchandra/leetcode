class Solution(object):
    def pivotIndex(self, nums):
        total=sum(nums)
        lfsum=0
        pivot=0
        rtsum=total-lfsum-nums[pivot]
        # pivot=0
        while pivot<len(nums)-1:
            if lfsum!=rtsum:
                lfsum=lfsum+nums[pivot]
                pivot=pivot+1
                rtsum=rtsum-nums[pivot]
            else:   
                return pivot
        if lfsum==rtsum:
            return pivot
        return -1

#alternate
class Solution(object):
    def pivotIndex(self, nums):
        total=sum(nums)
        lfsum=0
        pivot=0
        rtsum=total-lfsum-nums[pivot]
        # pivot=0
        while pivot<len(nums):
            if pivot==len(nums)-1 and lfsum!=rtsum:
                return -1
            if lfsum!=rtsum:
                lfsum=lfsum+nums[pivot]
                pivot=pivot+1
                rtsum=rtsum-nums[pivot]
            else:
                return pivot
        # if lfsum==rtsum:
        #     return pivot
        return -1

        """
        :type nums: List[int]
        :rtype: int
        """
#alternate
class Solution(object):
    def pivotIndex(self, nums):
        lfsum=0
        total=sum(nums)
        for i in range(len(nums)):
            rtsum=total-nums[i]-lfsum
            if rtsum==lfsum:
                return i
            lfsum+=nums[i]
        return -1


        """
        :type nums: List[int]
        :rtype: int
        """
#revised
class Solution(object):
    def pivotIndex(self, nums):
        # nums=nums.insert(0,0)x    
        nums.insert(len(nums),0)
        nums.insert(0,0)
        tot=sum(nums)
        lfsum=0
        # rtsum=tot-pivot
        for i in range(1,len(nums)-1):
            pivot=nums[i]
            rtsum=tot-pivot-lfsum
            if lfsum==rtsum:
                return i-1
            lfsum+=pivot
            rtsum=rtsum-pivot
        return -1
        """
        :type nums: List[int]
        :rtype: int
        """
