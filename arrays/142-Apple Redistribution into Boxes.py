#my solution
class Solution:
    def minimumBoxes(self, apple: List[int], capacity: List[int]) -> int:
        capacity2=sorted(capacity)
        capacity2=capacity2[::-1]
        total=sum(apple)
        counter=0
        while(total>0):
            total-=capacity2[counter]
            counter+=1
            
        return counter
        