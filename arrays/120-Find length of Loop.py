# brute force
class Node:
    def __init__(self, data=0, next=None):
        self.val = data
        self.next = next


# Please do not change code above.

def findlength(head:Node):
    temp=head.next
    count=1
    while(temp!=head):
        count+=1
        temp=temp.next

    return count


def lengthOfLoop(head: Node) -> int:
    # Write your code here
    # pass
    hashtable=set()
    while(head!=None):
        if head in hashtable:
            ans=findlength(head)
            return ans
            
        hashtable.add(head)
        head=head.next

    return 0


# optimal 


class Node:
    def __init__(self, data=0, next=None):
        self.val = data
        self.next = next


# Please do not change code above.

def findlength(head:Node):
    temp=head.next
    count=1
    while(temp!=head):
        count+=1
        temp=temp.next

    return count


def lengthOfLoop(head: Node) -> int:
    # Write your code here
    # pass
    slow=head
    fast=head

    while fast and fast.next:
        slow=slow.next
        fast=fast.next.next

        if slow==fast:

            ans=findlength(slow)

            return ans
    
    return 0

























































