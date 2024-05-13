class Solution(object):
    def canPlaceFlowers(self, flowerbed, n):
        counter=0
        flowerbed.insert(0,0)
        flowerbed.insert(len(flowerbed),0)
        for i in range(1,len(flowerbed)-1): 
            if flowerbed[i]==0 and flowerbed[i+1]==0 and flowerbed[i-1]==0:
                counter+=1
                flowerbed[i]=1
        

        return n<=counter
                #n is min amount of flowers that can be added.
                
#alternate
class Solution(object):
    def canPlaceFlowers(self, flowerbed, n):
        flowerbed=[0]+flowerbed+[0]
        empty=0 if flowerbed[0] else 1
        for i in range(1,len(flowerbed)-1):
            if flowerbed[i]:
                n-=int((empty-1)/2)
                empty=0
            else:
                empty+=1
                #n is min amount of flowers that can be added.
        n-=int(empty/2)
        return n<=0

        """
        :type flowerbed: List[int]
        :type n: int
        :rtype: bool
        """
#alternate
class Solution(object):
    def canPlaceFlowers(self, flowerbed, n):
        flowerbed.insert(0,0)
        flowerbed.insert(len(flowerbed),0)
        i=1
        ptr=0
        counter=0
        while ptr<len(flowerbed)-2:
            if flowerbed[ptr:ptr+3]==[0,0,0]:
                flowerbed[ptr+1]=1
                counter+=1
            ptr+=1
        return n<=counter
        
        """
        :type flowerbed: List[int]
        :type n: int
        :rtype: bool
        """
 
