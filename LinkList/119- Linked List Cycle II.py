# brute force

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

#Equivalent Java Code
'''
public class Solution {
    public ListNode detectCycle(ListNode head) {

        Set<ListNode> set=new HashSet<>();
        ListNode temp=head;
        while(temp!=null){
            if(set.contains(temp)) return temp;
            set.add(temp);
            temp=temp.next;
        }   
        return null;     
    }
}
'''

# optimal


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

#Java Equivalent Code

'''
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                ListNode temp=head;
                while(temp!=fast){
                    temp=temp.next;
                    fast=fast.next;
                }
                return temp;
            }
        }
        return null;
    }
}
'''
















    # Write your code here
    # pass
    

# later revise the mathematical explanation of it, on why it works.
































