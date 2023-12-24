class Solution(object):
    def merge(self, nums1, m, nums2, n):
       RtPtrX1=len(nums1)-1
       RtPtr2=len(nums2)-1

       El_RtPtr1=m-1#last element index

       #While Right Pointer and The left Pointer greater than or  Equals 0.
       #while the elemental 1st pointer is >=0
    #    and the extreme pointer of the 2nd is >=0.
       while RtPtr2>=0 and El_RtPtr1>=0:
           #if the last element of 2nd array is 
           #Greater than the (elemental)last element of the 
        #    1st array.
            if nums2[RtPtr2]>nums1[El_RtPtr1]:
                #place the last element of the 2nd array into the
                # last element in the first array
                nums1[RtPtrX1]=nums2[RtPtr2]
                
                RtPtrX1-=1
                # after placing decrement the last pointer of the 
                # 1st array
                # extreme position pointer
                RtPtr2-=1
                # and decrease the last pointer of 2nd element too.
                # extreme pointer of the 2nd array.
            else:
                # if the elemental right 1st array pointer
                #  elment is > extreme 2nd array pointer.
                nums1[RtPtrX1]=nums1[El_RtPtr1]
                # add this element to the extreme pointer of the 2nd array.
                RtPtrX1-=1
                # decrement the elemental pointer.
                El_RtPtr1-=1
                # decrement the extreme pointer.

        # if the ending (1st element) of the nums2 is < 1st element in nums1
        # the above loop ends
        # that smalled element will be left over in the array.
        # to add that into the sorted array.
        # if there are any elements left in the 2nd array, after the loop
        # breaks.
       while RtPtr2>=0:
# the loop breaks due to rtptr(elemental pointer)
# but the extreme pointer is still alive. at the required place 
# which is needed to be filled.
            nums1[RtPtrX1]=nums2[RtPtr2]
            RtPtrX1-=1 
            RtPtr2-=1

       return nums1




#alternate
class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        last=m+n-1
        m=m-1
        n=n-1

        while m>=0 and n>=0:
            if nums1[m]>nums2[n]:
                nums1[last]=nums1[m]
                m-=1
            else:
                nums1[last]=nums2[n]
                n-=1
            last-=1
        while n>=0:
            nums1[last]=nums2[n]
            n-=1
            last-=1



        """
        Do not return anything, modify nums1 in-place instead.
        """
