# ***66 Check for Prime - Striver A2Z Basic Maths
def isprime(self, N: int) -> bool:
    counter = 0
    for i in range(1, N + 1):
        if N % i == 0:
            counter += 1
    return counter == 2

# ***Alternate
class Solution:
    def isPrime(self, N):
        import math
        count = 0
        for i in range(1, int(math.sqrt(N)) + 1):
            if N % i == 0:
                count += 1
                if N // i != i:
                    count += 1
        return 1 if count == 2 else 0

# ***67 Armstrong Numbers
class Solution:
    def armstrongNumber(ob, n) -> str:
        summ = 0
        ini = n
        while n != 0:
            summ += (n % 10) ** 3
            n = n // 10
        return "Yes" if summ == ini else "No"

# ***68 Print All Divisors
class Solution:
    def sumOfDivisors(self, N):
        def findfactsum(self, n: int) -> int:
            import math
            res = []
            for i in range(1, int(math.sqrt(n)) + 1):
                if n % i == 0:
                    res.append(i)
                    if n // i != i:
                        res.append(n // i)
            return sum(res)

        res = 0
        for i in range(1, N + 1):
            res += findfactsum(self=9, n=i)
        return res

# ***69 Largest Element in Array
def largest(arr, n):
    return max(arr)

# ***70 Second Largest Element
class Solution:
    def print2largest(self, arr, n):
        temp = max(arr)
        while temp in arr:
            arr.remove(temp)
        return -1 if not arr else max(arr)

# ***Striver Optimized
class Solution:
    def print2largest(self, arr, n):
        def secdmax(self, ar: list) -> int:
            max_val = ar[0]
            secmax = -1
            for n in ar:
                if n > max_val:
                    secmax = max_val
                    max_val = n
                elif n > secmax and n < max_val:
                    secmax = n
            return secmax

        return secdmax(9, ar=arr)

# ***71 Check if Array Is Sorted and Rotated
class Solution:
    def check(self, nums: List[int]) -> bool:
        temp = list(nums)
        for n in temp:
            nums.append(n)
            nums.pop(0)
            if nums == sorted(nums):
                return True
        return False

# ***71 Check if Array Is Sorted
class Solution:
    def arraySortedOrNot(self, arr, n):
        return 1 if arr == sorted(arr) else 0

# ***72 Rotate Array
class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        temp = list(nums)
        k = k % len(temp)
        for n in temp:
            if len(temp) - k == 0:
                break
            nums.append(n)
            nums.pop(0)

# Left Rotate by One Place
def leftrotatebyoneplace(self, n: list) -> list:
    temp = n[0]
    for i in range(1, len(n)):
        n[i - 1] = n[i]
    n[len(n) - 1] = temp
    return n

# Left Rotate by N Places
def movebydplaces(self, n: list, k: int) -> list:
    k = k % len(n)
    temp = n[:k]
    for i in range(k, len(n)):
        n[i - k] = n[i]
    for j in range(len(n) - k, len(n)):
        n[j] = temp[j - (len(n) - k)]
    return n

# Optimal Rotate by N Places
def movebynplaces(self, n: list, k: int) -> list:
    n[:k] = n[k - 1::-1]
    n[k:] = n[:k - 1:-1]
    n = n[::-1]
    return n

# ***73 Linear Search
class Solution:
    def searchInSorted(self, arr, N, K):
        return 1 if K in arr else -1

# ***74 Union of Two Sorted Arrays
class Solution:
    def findUnion(self, a, b, n, m):
        lis = []
        lf1, lf2 = 0, 0
        while lf1 < len(a) and lf2 < len(b):
            if a[lf1] < b[lf2]:
                if not lis or a[lf1] != lis[-1]:
                    lis.append(a[lf1])
                lf1 += 1
            else:
                if not lis or b[lf2] != lis[-1]:
                    lis.append(b[lf2])
                lf2 += 1
        while lf1 < len(a):
            if a[lf1] != lis[-1]:
                lis.append(a[lf1])
            lf1 += 1
        while lf2 < len(b):
            if b[lf2] != lis[-1]:
                lis.append(b[lf2])
            lf2 += 1
        return lis

# ***74 Intersection of Two Arrays
def findArrayIntersection(arr: list, n: int, brr: list, m: int):
    i, j = 0, 0
    count = []
    while i < n and j < m:
        if arr[i] == brr[j]:
            count.append(arr[i])
            i += 1
            j += 1
        elif arr[i] < brr[j]:
            i += 1
        else:
            j += 1
    return count

# ***75 Missing Number
def missingNumber(a: List[int], N: int) -> int:
    summ = (N * (N + 1)) // 2
    return summ - sum(a)

# ***76 Max Consecutive Ones
def consecutiveOnes(arr: List[int]) -> int:
    maxx, counter = 0, 0
    for i in arr:
        if i == 1:
            counter += 1
        else:
            maxx = max(counter, maxx)
            counter = 0
    return max(counter, maxx)

# ***77 Subarray with Given Sum
def longestSubarrayWithSumK(a: [int], k: int) -> int:
    lf, rt = 0, 0
    l = []
    while rt < len(a):
        if sum(a[lf:rt + 1]) == k:
            l.append(rt - lf + 1)
            rt += 1
        elif sum(a[lf:rt + 1]) > k:
            lf += 1
        else:
            rt += 1
    return max(l)

# ***78 Search a 2D Matrix
class Solution:
    def searchMatrix(self, matrix, target):
        for row in matrix:
            if target in row:
                return True
        return False

# ***79 Row with Max 1s
class Solution:
    def rowWithMax1s(self, arr, n, m):
        macs, res = 0, -1
        for i in range(len(arr)):
            if arr[i].count(1) > macs:
                macs = arr[i].count(1)
                res = i
        return res

# ***82 Print Matrix in Spiral Form
def print_clock_elements(self, n: list) -> None:
    top, down, left, right, dir = 0, len(n), 0, len(n), 0
    while top <= down and left <= right:
        if dir == 0:
            for i in range(top, right):
                print(n[top][i], end=" ")
            top += 1
        elif dir == 1:
            for i in range(top, down):
                print(n[i][right - 1], end=" ")
            right -= 1
        elif dir == 2:
            for i in range(right - 1, left - 1, -1):
                print(n[down - 1][i], end=" ")
            down -= 1
        elif dir == 3:
            for i in range(down - 1, top - 1, -1):
                print(n[i][left], end=" ")
            left += 1
        dir = (dir + 1) % 4

# ***83 Lower Bound
def lowerBound(arr: [int], n: int, x: int) -> int:
    lf, rt = 0, len(arr) - 1
    while lf <= rt:
        mid = (lf + rt) // 2
        if arr[mid] >= x and (mid == 0 or arr[mid - 1] < x):
            return mid
        elif arr[mid] >= x:
            rt = mid - 1
        else:
            lf = mid + 1
    return n

# ***84 Upper Bound
def upperBound(arr: [int], x: int, n: int) -> int:
    lf, rt = 0, n
    while lf <= rt:
        mid = (lf + rt) // 2
        if arr[mid] > x:
            rt = mid - 1
        else:
            lf = mid + 1
    return lf

# ***85 Binary Search Range
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if target not in nums:
            return [-1, -1]
        lf, rt = 0, len(nums) - 1
        st, ed = -1, -1
        while lf <= rt:
            mid = (lf + rt) // 2
            if nums[mid] <= target:
                st = mid
                lf = mid + 1
            else:
                rt = mid - 1
        lf, rt = 0, len(nums) - 1
        while lf <= rt:
            mid = (lf + rt) // 2
            if nums[mid] >= target:
                ed = mid
                rt = mid - 1
            else:
                lf = mid + 1
        return [ed, st]

# ***86 Search in Rotated Sorted Array I
def search(arr, n, k):
    low, high = 0, n - 1
    while low <= high:
        mid = (low + high) // 2
        if arr[mid] == k:
            return mid
        if arr[low] <= arr[mid]:
            if arr[low] <= k <= arr[mid]:
                high = mid - 1
            else:
                low = mid + 1
        else:
            if arr[mid] <= k <= arr[high]:
                low = mid + 1
            else:
                high = mid - 1
    return -1

# ***87 Search in Rotated Sorted Array II
def searchInARotatedSortedArrayII(arr: List[int], k: int) -> bool:
    low, high = 0, len(arr) - 1
    while low <= high:
        mid = (low + high) // 2
        if arr[mid] == k:
            return True
        if arr[low] == arr[mid] == arr[high]:
            low += 1
            high -= 1
            continue
        if arr[low] <= arr[mid]:
            if arr[low] <= k <= arr[mid]:
                high = mid - 1
            else:
                low = mid + 1
        else:
            if arr[mid] <= k <= arr[high]:
                low = mid + 1
            else:
                high = mid - 1
    return False
