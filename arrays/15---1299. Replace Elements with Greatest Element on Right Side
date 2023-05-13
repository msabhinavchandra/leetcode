class Solution(object):
    def replaceElements(self, arr):
       rightmax=-1
       maxx=-1
       for i in range(len(arr)-1,-1,-1):
           temp=arr[i]
           arr[i]=rightmax
           maxx=max(rightmax,temp)
           rightmax=maxx
           
       return arr
         
       
