class Solution(object):
    def moveZeroes(self, nums):
        maxx=0
        lf=0
        lf2=1
        temp=0
        while lf2<len(nums):
            if (nums[lf]==0 and nums[lf2]!=0):
                temp=nums[lf]
                nums[lf]=nums[lf2]
                nums[lf2]=temp
                lf+=1
            if nums[lf]!=0:
                lf+=1
            lf2+=1

        return nums



        


        """
        :type nums: List[int]
        :rtype: None Do not return anything, modify nums in-place instead.
        """
# alternate
class Solution(object):
    def moveZeroes(self, nums):
        lf=0
        # rt=0
        for rt in range(len(nums)):
             if nums[rt]:
                 nums[lf],nums[rt]=nums[rt],nums[lf]
                 lf+=1
        return nums
#alternate
class Solution(object):
    def moveZeroes(self, nums):
        lf=0
        rt=1
        while rt<len(nums):
            if nums[lf]==0 and nums[rt]!=0:
                nums[lf],nums[rt]=nums[rt],nums[lf]
                lf+=1
                rt+=1
            else:
                if nums[lf]!=0:
                    lf+=1
                rt+=1
        return nums
            
        """
        :type nums: List[int]
        :rtype: None Do not return anything, modify nums in-place instead.
        """



        """
        :type nums: List[int]
        :rtype: None Do not return anything, modify nums in-place instead.
        """
