#hashing, brute force
'''
Following is the structure of the Node class already defined.

class Node :
    def __init__(self, data) :
        self.data = data
        self.next = None
'''

def detectCycle(head) :
    hashTable=set()
    while(head!=None):
        if head in hashTable:
            return True
        hashTable.add(head)
        head=head.next

    return False
    # Write your code here.
    # pass




#optimal

'''
Following is the structure of the Node class already defined.

class Node :
    def __init__(self, data) :
        self.data = data
        self.next = None
'''

def detectCycle(head) :
    # Write your code here.
    # pass
    if(head==None):
        return False

    fast=head
    slow=head

    while fast and fast.next:
        fast=fast.next.next
        slow=slow.next
        if fast==slow:
            return True
    return False

# go and research about the math, on why this actually works and all the next time you revise this.
































