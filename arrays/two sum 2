class Solution(object):
    def twoSum(self, numbers, target):
        lf=0

        rf=len(numbers)-1

        while lf<rf:
            if numbers[lf]+numbers[rf]==target:
                return list((lf+1,rf+1))
            elif numbers[lf]+numbers[rf]>target:
                rf=rf-1
            else:
                lf=lf+1
            
#alternate
class Solution(object):
    def twoSum(self, numbers, target):
        d={}
        for i,n in enumerate(numbers):
            diff=target-n
            if diff in d:
                return [d[diff]+1,i+1]
            d[n]=i
        """
        :type numbers: List[int]
        :type target: int
        :rtype: List[int]
        """
