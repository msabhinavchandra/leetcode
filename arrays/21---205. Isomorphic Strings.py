class Solution(object):
    def isIsomorphic(self, s, t):
        d={}
        for i in range(len(s)):
            # d={}
            if s[i] in d:
                if t[i]==d[s[i]]:
                    pass
                else:
                    return False
                pass
            elif t[i] in d.values():
                return False
            else:
                d[s[i]]=t[i]
        return True
        
        
        


