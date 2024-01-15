class Solution(object):
    def hammingWeight(self, n):
        counter=0
        while n:
            if n%2==1:
                counter+=1
                n=n>>1
            else:
                n=n>>1
        return counter

#alternate

class Solution(object):
    def hammingWeight(self, n):
        res=0
        while n:
            n=n&(n-1)
            res+=1
        return res







    
        """
        :type n: int
        :rtype: int
        """
