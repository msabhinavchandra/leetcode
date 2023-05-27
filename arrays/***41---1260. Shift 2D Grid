class Solution:
    def shiftGrid(self, grid: List[List[int]], k: int) -> List[List[int]]:
        res=[]
        temp=[]
        for i in range(len(grid)):#no of rows
            for j in range(len(grid[0])):#no of columns
                temp.append(0)
            res.append(temp)
            temp=[]
        def postoval(r,c):#creating helper function,for pos to val
            return r*len(grid[0])+c
        def valtopos(v):
            return ((v)//len(grid[0]),(v)%len(grid[0]))
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                val=postoval(i,j)
                newr,newc=valtopos((val+k)%(len(grid)*len(grid[0])))
                res[newr][newc]=grid[i][j]

        return res
        
#alternate 
class Solution:
    def shiftGrid(self, grid: List[List[int]], k: int) -> List[List[int]]:
        l=[]
        temp=[]
        new=[]
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                temp.append(0)
            new.append(temp)
            temp=[]
        def mattolis(self,r:int,c:int)->int:
            return r*len(grid[0])+c
        def listomat(self,n:int)->list:
            r=n//len(grid[0])
            c=n%len(grid[0])
            return (r,c)
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                temp=((mattolis(self=9,r=i,c=j)+k)%(len(grid)*len(grid[0])))
                rn,cn=listomat(self=9,n=temp)
                new[rn][cn]=grid[i][j]
                # l[temp]=grid[i][j]
                # rn,cn=listomat(self=9,n=temp)
        # for i in range(len(l)):
        #     rn,cn=listomat(self=9,n=i)
        #     grid[rn][cn]=i

        return new
                

                



