class Solution(object):
    def removeDuplicates(self, nums):
        lf=1
        rt=1
        while rt<len(nums):
            if nums[rt-1]==nums[rt]:
                rt=rt+1
            else:
                nums[lf]=nums[rt]
                lf=lf+1
                rt=rt+1
        return lf
