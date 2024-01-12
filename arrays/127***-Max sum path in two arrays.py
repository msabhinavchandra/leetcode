#Your task is to complete this function
#Function should return an integer denoting the required answer
class Solution:
    def maxSumPath(self, arr1, arr2, m, n):
        sum1=0
        sum2=0
        i=0
        j=0
        result=0
        while(i<m and j<n):
            if(arr1[i]>arr2[j]):
                # why am o adding, every thing when it was small?
                # cuz, it is sorted and i want both the pointers
                # to reach the common point,so when one is less
                # increment it, and vice versa, till we reach a
                # common point.which exists no matter what.
                #increment less, right-sum
                sum2+=arr2[j]
                j+=1
            
            elif(arr2[j]>arr1[i]):
                
                #increment less, right-sum
                sum1+=arr1[i]
                i+=1
            
            else:#when arr[i]==arr[j]
                result+=max(sum1,sum2)+arr1[i]
                sum1=sum2=0
                i+=1
                j+=1
        
        while(i<m):
            # if there are more elements left in the arr1,after the
            # common point was reached.
            sum1+=arr1[i]
            i+=1
            
        while(j<n):
            # if there are more elements left in the arr2,after the
            # common points was reached.
            sum2+=arr2[j]
            j+=1
            
        result+=max(sum1,sum2)#the last set of sums,after the common
        # points have reached,whoose maximum of 2 we needed to
        # be added to the result
        
        return result
                
                
                
        #code here
