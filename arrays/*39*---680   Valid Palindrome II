class Solution:
    def validPalindrome(self, s: str) -> bool:
        lf=0
        rt=len(s)-1
        while lf<rt:
            if s[lf]!=s[rt]:
                lfw,rfw=s[lf+1:rt+1],s[lf:rt]
                return (lfw==lfw[::-1] or rfw==rfw[::-1])

            lf+=1
            rt-=1
        
        return True
