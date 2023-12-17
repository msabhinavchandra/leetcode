class Solution:
    def rotate(self, matrix: List[List[int]]) -> None:

        l,r=0,len(matrix)-1
            #indexing starts from 0

        while(l<=r):
            for i in range(r-l):
                #r-l, because the no of interations in the for loop
                #for every upper interation is (the difference
                #between the left and the right pointers.)
                top,bottom=l,r

                 #storing temp variable.
                topleft=matrix[top][l+i]

                matrix[top][l+i]=matrix[bottom-i][l]

                matrix[bottom-i][l]=matrix[bottom][r-i]

                matrix[bottom][r-i]=matrix[top+i][r]

                matrix[top+i][r]=topleft

            r=r-1
            l=l+1
                










        """
        Do not return anything, modify matrix in-place instead.
        """
        
