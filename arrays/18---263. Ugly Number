class Solution(object):
    def isUgly(self, n):
        if n==0:
            return False
        while n!=1:
            if n%2==0:
                n=n/2
            elif n%3==0:
                n=n/3
            elif n%5==0:
                n=n/5
            else:
                return False
        return True


#alternate
class Solution(object):
    def isUgly(self, n):
        if n<=0:
            return False
        for p in [2,3,5]:
            while n%p==0:
                n=n//p
        return n==1
