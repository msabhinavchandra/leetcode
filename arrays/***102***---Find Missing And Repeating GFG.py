
class Solution:
    def findTwoElement( self,arr, n): 
        
        repeated=n+1
        missed=n-1
        
        #repeating
        for i in range(1,n+1):
            key=abs(arr[i-1])-1#converting into implicit 
            #indexing
            
            if(arr[key]<0):#if already -ve store the answer,as it is repeating.
                
                repeated = key+1#converting into explicit indexing
                #storing the answer.
                
            else:
                arr[key]*=-1
        
        for i in range(n):#looping in implicit indexing.
            if arr[i]>0:
                missing=i+1#converting into explicit indexing.
                
                
        return [repeated,missing]
                
            
        
