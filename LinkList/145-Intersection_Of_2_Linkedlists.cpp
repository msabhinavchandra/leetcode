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

//the best with no space 



Node* goTogerther(Node* large,Node* small,int dif){
    while(dif!=0){
        large=large->next;
        dif--;
    }

    while(small!=NULL)
    {
        if(large==small) return large;
        large=large->next;
        small=small->next;
    }

    return NULL;

}

Node* findIntersection(Node *firstHead, Node *secondHead)
{
    //Write your code here
    Node* temp1=firstHead;
    Node* temp2=secondHead;
    int l1=0;
    int l2=0;
    while(temp1!=NULL)
    {   
        temp1=temp1->next;
        l1++;

    }
    while(temp2!=NULL)
    {   
        temp2=temp2->next;
        l2++;

    }
    int diff;
    if(l1>l2){
        diff=l1-l2;
        return goTogerther(firstHead,secondHead,diff);
    }
    else if(l2>l1){
        diff=l2-l1;
        return goTogerther(secondHead,firstHead,diff);

    }
    else{
        diff=l2-l1;
        return goTogerther(secondHead,firstHead,diff);

    }



}

