class Solution(object):
    def maxNumberOfBalloons(self, text):
            d1={}
            d2={}
            # l=[]
            res=len(text)
            for i in "balloon":
                if i  not in d2:
                    d2[i]=1
                else:
                    d2[i]+=1
            for i in text:
                if i not in d1:
                    d1[i]=1
                else:
                    d1[i]+=1
            for i in d2:
                if i in d1:
                    res=min(res,d1[i]//d2[i])
                else:
                    return 0
                # l.append(int(d1[i]/d2[i]))

            return res
#althernate
class Solution(object):
    def maxNumberOfBalloons(self, text):
        h="balloon"
        d={}
        d1={}
        res=0
        for i in h:
            if i not in d:
                d[i]=1
            else:
                d[i]+=1
        for i in text:
            if i not in d1 and i in h:
                d1[i]=1
            else:
                if i in h:
                    d1[i]+=1
        for i in h:
            if i not in d1:
                return 0
        l=[]
        for i in text:
            if i in h:
                res=d1[i]//d[i]
                l.append(res)
            
        
        return min(l)

        """
        :type text: str
        :rtype: int
        """
            

        
