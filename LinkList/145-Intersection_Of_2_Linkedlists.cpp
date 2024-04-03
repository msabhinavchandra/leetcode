//brute force
//tc->O(m*n)
//sc->O(1)

Node* findIntersection(Node *firstHead, Node *secondHead)
{   
    //brute force
    Node* head1=firstHead;
    Node* head2=secondHead;
    Node* temp;
    while(head1!=NULL){
        temp=head2;
        while(temp!=NULL){
            if(temp==head1) return head1;
            temp=temp->next;
        }
        head1=head1->next;
    }
    //Write your code here
    return NULL;
}

//optimal
//using hashmap
// Time Complexity: O(n+m)
// Space Complexity: O(n)

#include <unordered_set>
Node* findIntersection(Node *firstHead, Node *secondHead)
{
    //Write your code here
    unordered_set<Node*> st;
    Node* head1=firstHead;
    Node* head2=secondHead;
    while(head1!=NULL){
        st.insert(head1);
        head1=head1->next;
    }
    while(head2!=NULL){
        if(st.find(head2)!=st.end()) return head2;
        head2=head2->next;
    }
    return NULL;
}

