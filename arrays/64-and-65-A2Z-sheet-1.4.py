# 64 GFG Basic Maths count digits 1.4
# Code stridio striver

# Method 1
import math
def count_digits(n):
    digits = math.floor(math.log10(n) + 1)
    return digits

# Method 2
def count_digits(n):
    count = 0
    x = n
    while x != 0:
        x //= 10
        count += 1
    return count

# Method 3
def count_digits(n):
    x = str(n)
    return len(x)

# *** GFG
class Solution:
    def evenlyDivides(self, N):
        n = str(N)
        counter = 0
        for i in n:
            if int(i) == 0:
                continue
            elif N % int(i) == 0:
                counter += 1
        return counter

# *** 65 GFG LCM HCF 1.4
class Solution:
    def lcmAndGcd(self, A, B):
        import math
        gcd = math.gcd(A, B)
        return A * B // gcd, gcd

    # Alternate method
    def lcmAndGcd(self, A, B):
        for i in range(min(A, B), 0, -1):
            if A % i == 0 and B % i == 0:
                break
        return A * B // i, i
