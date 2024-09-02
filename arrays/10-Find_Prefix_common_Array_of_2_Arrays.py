class Solution(object):
    def findThePrefixCommonArray(self, A, B):
        if 1<=len(A)==len(B)<=50:
            pass
            for i in range(len(A)):
                if (1<=A[i]<=len(A) and 1<=B[i]<=len(B)):
                    pass
                
                else:
                    return 0
                if (type(A[i])==int and type(B[i])==int):
                    pass
                
                    liss=[]
                    C=[]
                    counter=0
                    for j in range(len(A)):
                        for h in range(0,j+1):
                            q=A[h]
                            if q in B[0:j+1]:
                                counter=counter+1
                            
                        C.append(counter)
                        counter=0
                        # liss.append(q)
                        # w=A[j]
                        # if w in A[0:j+1]:
                        #     counter=counter+1
                        # liss.append(w)
#                         if q==w or q in liss or w in liss:
                            
#                         else:
#                             C[j]=0
#                         liss.append(q)
#                         liss.append(w)
                    return C
                            
                    
                else:
                    return 0
                
                    
        else:
            return 0
#alternate
class Solution:
    def findThePrefixCommonArray(self, A: List[int], B: List[int]) -> List[int]:
        a=0
        b=0
        counter=0
        a1=set()
        b1=set()
        l=[]
        i=1
        while i<=len(A):
            for j in A[:i]:
                if j in B[:i]:
                    counter+=1
                # a+=1
                # b+=1
                # i+=1
            a+=1
            b+=1
            i+=1

            l.append(counter)
            counter=0
        return l
