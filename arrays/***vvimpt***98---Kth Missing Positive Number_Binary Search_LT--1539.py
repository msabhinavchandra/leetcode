#1539. Kth Missing Positive Number

#python code

##mycode

class Solution:
    def findKthPositive(self, arr: List[int], k: int) -> int:
        # tot_arr=[x for x in range(1,max(arr)+1)]
        # k=k-1
        tot_arr=[x for x in range(1,max(arr)+1) if x not in arr]
        # print(tot_arr)
        if tot_arr==[]:
            return (k+max(arr))
        elif(len(tot_arr)<k):
            return (max(arr)+(k-len(tot_arr)))
        else:
            k=k-1
            return (tot_arr[k])

        
        
#striver_brute

class Solution:
    def findKthPositive(self, arr: List[int], k: int) -> int:
        for i in range(len(arr)):
            if arr[i]<=k:
                k=k+1
            else:
                break
        return k
                
#striver_optimized_binary_search

class Solution:
    def findKthPositive(self, arr: List[int], k: int) -> int:
        low=0
        high=len(arr)-1
        while(low<=high):
            mid=(low+high)//2
            missing=arr[mid]-(mid+1)
            if(missing<k):
                low=mid+1
            else:
                high=mid-1
                #it could have been been returned (low+k), because as (high+1=low)

        return (high+1+k)


