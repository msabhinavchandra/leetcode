class Solution(object):
    def numUniqueEmails(self, emails):
        uniq=set()
        for e in emails:
            local,domain=e.split('@')
            local=local.split("+")[0]
            local=local.replace(".","")
            uniq.add((local,domain))
        return len(uniq)
    

#alternate

class Solution(object):
    def numUniqueEmails(self, emails):
        uniq=set()
        # local=''
        # domain=''
        # i=0
        for e in emails:
                i=0
                local=''
                domain=''

                while e[i] not in ["@","+"]:
                    if e[i]!='.':
                        local=local+e[i]
                    i=i+1
                while e[i]!='@':
                    i=i+1
                domain=e[i:]
                uniq.add((local,domain))

        return len(uniq)




     

        """
        :type emails: List[str]
        :rtype: int
        """
#alternate
