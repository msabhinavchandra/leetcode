class Solution(object):
    def reverse(self, x):
        if x>=0:
            val=int(str(x)[::-1])
        else:
            val=-(int(str(abs(x))[::-1]))
        if (val<-2**31 or val>2**31-1):
            return 0
        else:
            return val
        """
#alternate
class Solution(object):
    def reverse(self, x):
        # if x<=-1*2**31:
        #     return 0
        # if x>=2**31-1:
        #     return 0
        if x>=0:
            x=str(x)
            x=x[::-1]
            x=int(x)
            if x<=-1*2**31:
                return 0
            if x>=2**31-1:
                return 0
            return int(x)
        x=-1*x
        x=str(x)
        x=x[::-1]
        x=-1*int(x)
        if x<=-1*2**31:
            return 0
        if x>=2**31-1:
            return 0
        return (x)
        
        # """
        # # :type x: int
        # # :rtype: int
        # """
