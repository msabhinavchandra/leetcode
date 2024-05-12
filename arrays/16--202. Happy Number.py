class Solution(object):
    def isHappy(self, n):
        visit=set()
        while n  not in visit:
            visit.add(n)
            n=sum(int(digits)**2 for digits in str(n))
            if n==1:
                return True
        return False

