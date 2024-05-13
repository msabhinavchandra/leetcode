class Solution(object):
    def strStr(self, haystack, needle):
        for i in range(len(haystack)-len(needle)+1):
            if needle == haystack[i:i+len(needle)]:
                return i
            else:
                pass
        return -1
        """
        :type haystack: str
        :type needle: str
        :rtype: int
        """

#alternate
class Solution(object):
    def strStr(self, haystack, needle):
        for i in range(len(haystack)-len(needle)+1):
            if haystack[i:i+len(needle)]==needle:
                return i
        return -1
        """
        :type haystack: str
        :type needle: str
        :rtype: int
        """
        
#alternate
class Solution(object):
    def strStr(self, haystack, needle):
        for i in range(len(haystack)-len(needle)+1):
            if haystack[i:i+len(needle)]==needle:
                return i
        return -1
        """
        :type haystack: str
        :type needle: str
        :rtype: int
        """
   
   
        
