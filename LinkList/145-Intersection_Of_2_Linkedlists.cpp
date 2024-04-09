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

//the best solution with no space complexity
//sc->O(1)
//tc->O(2*max(len of list1,len of list2)+O(abs(len of list1-len of list2))+O(min(len of list1,len of list2)))

//this is my way same method i will show you a different one with the same code.
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

// same method more organized code.


int getDifference(Node* head1,Node* head2)
{
    int len1=0,len2=0;
    //loop till both reach their end.
    while(head1!=NULL||head2!=NULL)
    {
        if(head1!=NULL){
            ++len1; head1=head1->next;
        }
        if(head2!=NULL)
        {
            ++len2;head2=head2->next;
        }
    }

    return len1-len2;
    //if it was negative it shows that the ll2 is longer than the ll1

}

Node* findIntersection(Node *firstHead, Node *secondHead)
{
    //Write your code here
    Node* temp1=firstHead;
    Node* temp2=secondHead;

    int diff=getDifference(temp1, temp2);
    if(diff<0)
            while(diff++!=0) temp2=temp2->next;//ll2 is longer.
    else while(diff--!=0) temp1=temp1->next;//ll1 is longer.

    //now both are starting from the same point
    while(temp1!=NULL)
    {
        if(temp1==temp2) return temp2;
        temp2=temp2->next;
        temp1=temp1->next;
    }

    return temp1;
    
}

// optimized.

// tc->O(2*max(Length of LL1,Len of LL2))
//do a dry run for clarification
//sc->O(1) //we are not saving anything.


Node* findIntersection(Node *firstHead, Node *secondHead)
{
    //Write your code here
    Node* temp1=firstHead;
    Node* temp2=secondHead;

    while(temp1!=temp2)
    {   
        temp2=temp2->next;
        temp1=temp1->next;

        if(temp1==temp2) return temp2;
        if(temp2==NULL) temp2=firstHead;
        if(temp1==NULL) temp1=secondHead;

    }

    //in an edge case where there are 2 LLs whoose lenth is 0, starting at the same line ll.

    return temp2;

}



