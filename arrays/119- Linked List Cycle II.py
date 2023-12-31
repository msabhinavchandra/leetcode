# brute force

'''
Following is the structure of the Node class already defined.

class Node:
    def __init__(self, data):
        self.data = data
        self.next = None
        
'''

def firstNode(head):
    # Write your code here
    # pass
    st=set()
    while head!=None:
        if head in st:
            return head
        st.add(head)
        head=head.next
    
    return None

# optimal

'''
Following is the structure of the Node class already defined.

class Node:
    def __init__(self, data):
        self.data = data
        self.next = None
        
'''

def firstNode(head):
    slow=head
    fast=head
    while fast and fast.next:
        fast=fast.next.next
        slow=slow.next
        if(fast==slow):
            temp=head
            while(temp!=fast):
                temp=temp.next
                fast=fast.next

            return temp
    
    return None

















    # Write your code here
    # pass
    

# later revise the mathematical explanation of it, on why it works.
































