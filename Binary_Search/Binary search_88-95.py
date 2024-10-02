#88
#Find minimum in Rotated Sorted Arra…



import sys
def findMin(arr: [int]):
    low = 0
    high = len(arr) - 1
    ans = sys.maxsize

    while low <= high:
        mid = (low + high) // 2

        # search space is already sorted
        # then arr[low] will always be
        # the minimum in that search space:
        if arr[low] <= arr[high]:
            ans = min(ans, arr[low])
            break
            
        if arr[low] <= arr[mid]:  # if left part is sorted
            ans = min(ans, arr[low])  # keep the minimum
            low = mid + 1  # eliminate left half

        else:  # if right part is sorted
            ans = min(ans, arr[mid])  # keep the minimum
            high = mid - 1  # eliminate right half

    return ans

if __name__ == "__main__":
    arr = [4, 5, 6, 7, 0, 1, 2, 3]
    ans = findMin(arr)
    print("The minimum element is:", ans)


#more clear alternate solution

class Solution:
    def findMin(self, nums: List[int]) -> int:
        # return min(nums)
        # lf=0
        # rt=len(nums)-1
        # while lf<=rt:
        #     if nums[mid]==min

        low=0
        high=len(nums)-1
        ans=1000

        while(low<=high):
            mid=(low+high)//2

            #base condition.

            if(nums[low]<=nums[high]):
                ans=min(ans,nums[low])
                break
            #earlier i had got an error because i didn't give mid equality case
            #yet i included low equal to high equality case.
            #
            elif(nums[low]<=nums[mid]):#when left side array is sorted
                ans=min(ans,nums[low])
                low=mid+1
            #else:#when the right array is sorted.
            elif(nums[mid]<=nums[high]):

                ans=min(nums[mid],ans)

                high=mid-1

        return ans


#89---Find out how many times has an arra…



import sys
def findKRotation(arr : [int]) -> int:
    low = 0
    high = len(arr) - 1
    ans = float('inf')
    index = -1
    while low <= high:
        mid = (low + high) // 2

        # If search space is already sorted,
        # then arr[low] will always be
        # the minimum in that search space
        if arr[low] <= arr[high]:
            if arr[low] < ans:
                index = low
                ans = arr[low]
            break

        # If left part is sorted
        if arr[low] <= arr[mid]:
            # Keep the minimum
            if arr[low] < ans:
                index = low
                ans = arr[low]

            # Eliminate left half
            low = mid + 1
        else:  # If right part is sorted
            # Keep the minimum
            if arr[mid] < ans:
                index = mid
                ans = arr[mid]

            # Eliminate right half
            high = mid - 1

    return index

if __name__ == "__main__":
    arr = [4, 5, 6, 7, 0, 1, 2, 3]
    ans = findKRotation(arr)
    print("The array is rotated", ans, "times.")

# 90--540. Single Element in a Sorted Array,leetcode


class Solution:
    def singleNonDuplicate(self, nums: List[int]) -> int:
        if len(nums)==1:
            return nums[0]
        if nums[0]!=nums[1]:
            return nums[0]
        if nums[len(nums)-1]!=nums[len(nums)-2]:
            return nums[len(nums)-1]
        lf=1
        rt=len(nums)-2
        while(lf<=rt):
            mid=(lf+rt)//2
            if nums[mid]!=nums[mid-1] and nums[mid]!=nums[mid+1]:
                return nums[mid]
            if (mid%2==1 and nums[mid-1]==nums[mid])or(mid%2==0 and nums[mid+1]==nums[mid]):
                lf=mid+1
            else:
                rt=mid-1


#91 ---162. Find Peak Element

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        lf=1
        rt=len(nums)-2
        if len(nums)==1:
            return 0
        elif nums[0]>nums[1]:
            return 0
        elif nums[len(nums)-2]<nums[len(nums)-1]:
            return len(nums)-1
        while(lf<=rt):
            mid=(lf+rt)//2
            if nums[mid]>nums[mid-1] and nums[mid]>nums[mid+1]:
                return mid
            elif nums[mid]>nums[mid-1]:
                lf=mid+1
            elif nums[mid-1]>nums[mid]:
                rt=mid-1
    

#92----squareroot of a number
#BS---4.2----1st problem
#bruteforce
def sqroot(n):
    ans=0
    for i in range(1,n+1):
        if (i*i<=n):
            ans=i
        else:
            break
    return ans
print(sqroot(17))

#striver optimal

def floorSqrt(n):
    lf, rt = 1, n
    ans = 1
    while (lf <= rt):
        mid = (lf + rt) // 2
        if (mid * mid) <= n:
            ans = mid
            lf= mid + 1
        else:
            rt = mid - 1
    return ans


#93---nth root bs answers 2nd question

#brute

def NthRoot(n: int, m: int) -> int:
    for i in range(m):
        if i**n==m:
            return i
        elif i**n>m:
            break
    return -1

#striver optimal

#handling the edge cases
def func(mid, n, m):
    ans = 1
    for i in range(1, n + 1):
        ans *= mid
        if ans > m:
            return 2
    if ans == m:
        return 1
    return 0


#real solution using binary search
def NthRoot(n: int, m: int) -> int:
    # Write Your Code Here
    # pass
    lf=1
    rt=m
    ans=-1
    while (lf<=rt):
        mid=(lf+rt)//2
        if (mid**n)==m:
            ans=mid
            break
            # lf=mid+
        elif (mid**n)<m:
            lf=mid+1
        else:
            rt=mid-1
    if ans!=-1:
        return ans
    else:
        return -1

#94--Koko Eating Bananas(875 leetcode)---python

class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        maxi=max(piles)
        import math

        def calculate_total_hours(self,piles:List[int],curr:int)->int:
            tot_hours=0
            for i in range(len(piles)):
                tot_hours+=math.ceil(piles[i]/curr)

            return tot_hours
        lf=1
        rt=maxi
        while(lf<=rt):
            mid=(lf+rt)//2
            tot=calculate_total_hours(1,piles,mid)
            if(tot<=h):
                rt=mid-1
            else:
                lf=mid+1
            
        return lf

#same problem in java is available.


#95---Minimum days to make M bouquets | Binary Search(leetcode 1482)

class Solution(object):
    def minDays(self, bloomDay, m, k):
        """
        :type bloomDay: List[int]
        :type m: int
        :type k: int
        :rtype: int
        """
        def possible(bloomDay,day,m,k):
            n=len(bloomDay)
            cnt=0
            noOfB=0
            for i in range(n):
                if bloomDay[i]<=day:
                    cnt+=1
                else:
                    noOfB+=cnt//k
                    cnt=0
            noOfB+=cnt//k
            return noOfB>=m

        
        val=m*k
        n=len(bloomDay)
        if val>n:
            return -1
        mini=min(bloomDay)
        maxi=max(bloomDay)

        lf=mini
        
        # temp=list(bloomDay)
        # temp = sorted(list(set(temp)))
        ans=0
        rt=maxi
        while lf<=rt:
            mid=(lf+rt)//2
            if possible(bloomDay,mid,m,k):
                    ans=mid
                    rt=mid-1
            else:
                    lf=mid+1

        return ans
         





