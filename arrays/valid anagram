class Solution(object):
    def isAnagram(self, s, t):
        if len(s)!=len(t):
            return False
        l=[]
        for i in s:
           l.append(i)
        for j in t:
            if j in l:
                pass
                l.remove(j)
            
            else:
                return False
        return True
#alternate
class Solution(object):
    def isAnagram(self, s, t):
        d={}
        c={}
        for i,n in enumerate(s):
            if n not in d:
                d[n]=1
            else:
                d[n]+=1
        for i,n in enumerate(t):
            if n not in c:
                c[n]=1
            else:
                c[n]+=1
        if c!=d:
            return False
        return True
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
    
