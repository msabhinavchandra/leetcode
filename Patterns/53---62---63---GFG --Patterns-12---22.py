#***    53---GFG pattern 12
class Solution:
    def printTriangle(self, N):
        for h in range(N):
            for j in range(h+1):
                print(j+1,end=" ")
            for k in range(2*N-2*h-2):
                print(" ",end=" ")
            for j in range(h,-1,-1):
                print(j+1,end=" ")
            print("")
        # Code here
      
#54---GFG pattern 13
class Solution:
    def printTriangle(self, N):
        counter=1
        for i in range(N):
            for j in range(i+1):
                print(counter,end=" ")
                counter+=1
            print()
       
#***55---GFG pattern 14
class Solution:
    def printTriangle(self, N):
        for i in range(N):
            for j in range(i+1):
                print(chr(65+j),end="")
            print()
        # Code here
        
        
#***56---GFG pattern 15
class Solution:
    def printTriangle(self, N):
        for i in range(N):
            for j in range(0,N-i):
                print(chr(65+j),end="")
            print()
        # Code here
        
        
#***57---GFG pattern 16
class Solution:
    def printTriangle(self, N):
        for i in range(N):
            for j in range(i+1):
                print(chr(i+65),end="")
            print()
        # Code here
          


#***58---GFG pattern 17
class Solution:
    def printTriangle(self, N):
        for i in range(N):
            for j in range(i,N-1):
                print(" ",end="")
            for g in range(i+1):
                print(chr(65+g),end="")
            temp=65+g-1
            for j in range(i):
                print(chr(temp-j),end="")
            print()
        # Code here


#***59---GFG pattern 18
class Solution:
    def printTriangle(self, N):
        for i in range(N):
            for j in range(1+i):
                print(chr(65+N-1-j),end=" ")
            print()
            
#alternate
for i in range(N):
    for j in range(i+1,0,-1):
        print(chr(65+N-j),end=" ")
    print()
    
   

#***60---GFG pattern 19
class Solution:
    def printTriangle(self, N):
        for i in range(N):
            for j in range(i,N):
                print("*",end="")
            for k in range(i):
                print(" ",end=" ")
            for j in range(i,N):
                print("*",end="")
            print()
        for i in range(N):
            for j in range(1+i):
                print("*",end="")
            for k in range(2*N-2*(i+1)):
                print(" ",end="")
            for j in range(1+i):
                print("*",end="")
            print()
            
            
#***61---GFG Pattern 20
class Solution:
    def printTriangle(self, N):
        for i in range(N):
            for j in range(1+i):
                print("*",end="")
            for k in range(N-i-1):
                print(" ",end=" ")
            for j in range(1+i):
                print("*",end="")
            print()
        for i in range(N-1):
            for j in range(i,N-1):
                print("*",end="")
            for k in range(1+i):
                print(" ",end=" ")
            for j in range(i,N-1):
                print("*",end="")
            print()
        # Code here
        
        
#***62---GFG Pattern 21
class Solution:
    def printTriangle(self, N):
        for j in range(N):
            if j==0 or j==N-1:
                for t in range(N):
                    print("*",end="")
                print()
            else:
                print("*",end="")
                for k in range(N-2):
                    print(" ",end="")
                print("*",end="")
                print()
                
                
#***63---GFG Pattern 22
class Solution:
    def printTriangle(self, N):
        for i in range(2*N-1):
            for j in range(2*N-1):
                right=2*N-1-1-j
                bottom=2*N-1-1-i
                print(N-min(i,j,right,bottom),end=" ")
            print()
        # Code here


            
