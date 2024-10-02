class Solution:
    def search(self, nums: List[int], target: int) -> int:
        lf=0
        rt=len(nums)-1
        while lf<=rt:
            mid=(lf+rt)//2
            if nums[mid]>target:
                rt=mid-1
            elif nums[mid]<target:
                lf=mid+1
            else:
                return mid
        return -1
