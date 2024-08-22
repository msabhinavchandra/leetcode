# brute force
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

#Equivalent Java Code
'''
class Solution

{   static int findlength(Node thead){
    Node temp=thead.next;
    int count=1;
    while(temp!=thead){
        count+=1;
        temp=temp.next;
    }
    return count;
}
    //Function to find the length of a loop in the linked list.
    static int countNodesinLoop(Node head)
    {
        //Add your code here.
        Set<Node> hashTable=new HashSet<>();
        
        Node temp=head;
        
        while(temp!=null){
            if(hashTable.contains(temp)){
                int len=findlength(temp);
                return len;
            }
            hashTable.add(temp);
            temp=temp.next;
        }
        
        return 0;
        
    }
}
'''


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

#Equivalent Java Code
'''
class Solution
{   
    static int findlength(Node thead){
        Node temp=thead.next;
        int count=1;
        while(temp!=thead){
            count+=1;
            temp=temp.next;
        }
        return count;
    }
    //Function to find the length of a loop in the linked list.
    static int countNodesinLoop(Node head)
    {
        //Add your code here.
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                int len=findlength(slow);
                return len;
            }
        }
        return 0;
    }
}
'''

























































