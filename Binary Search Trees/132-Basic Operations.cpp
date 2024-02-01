#include<iostream>
using namespace std;
#include<queue>

class Node{
    public:
    int data;
    Node* left;
    Node* right;
    Node(int val){
        data=val;
        left=NULL;
        right=NULL;
    }
};

class BinarySearchTree
{
    public:
    Node *root;
    //constructor
    BinarySearchTree()
    {
        root=NULL;
    }
    //i am declaring all the methods inside but i will define them outside :)
    Node *CreateRoot();
    //return value will be Node* because, it returns the Node of the root 

    //insertion of a node(value) in the Binary Search tree
    // it returns root of the BST
    //you will pass the root as well as the value to be inserted as parameters
    Node* Insert(Node* curr,int val);//i am declaring it, i will define it outside.

    //declaring the level order binary Search tree printing  Funtion.
    void printLevelOrder(Node* curr);//nothing to return so, void 

    //i am going to write the function for the search element in the BST
    //the return value will be Node*, if the element exists, then the function
    //will return it's root pointer,otherwise it returns NULL

    Node* SearchElement(Node* curr,int key);//i am declaring over here
// i will define outside

//for deleting a specific node in a BST we need 3 functions(methods), all these 3
//are required for deleting a specific node, 

//the first function is for like the complete function, which returns the 
//modified root of the BST, after element deletion
Node* deleteNode(Node* root,int key);//the parameters we are passing are root of the
//BST and the key , value which we want to delete from the BST

//and one more thing we are just rearranging the links, but not really deleting that
//at this point of time,i will do that in the second interation of this topic 
//after exam

//we need helper function which will rearrange the links of the Node,which has to be
//deleted.Which returns the left of the element(which is to be deleted)

//of the if the (parent->right) is the (element which is needed to be deleted)
//which we will re-attach the parent->right=helperfunction(parent->right)

//so that the element is deleted.

//if the (parent->left) is the (element which is needed to be deleted)
//we will re-attach the parent->left=helperfuntion(parent->left)

//if the root of the Node which is needed to be deleted (root->left==NULL)
// then it's right is returned in the helper funtion(iff root->right!=NULL)
//which will get attacted to the parent->left or parent->right
//whichever denotes the node which is needed to be deleted

//if the both root(of the element which is needed to be deleted) ->right as well as 
//the left are NULL, then NULL will be returned in the helper funtion
//to whome the parent->left or parent->right, whatever denotes the
//will be attatched to NULL, means the parent becomes leaf(may or may not), cuz it's one of the
//child is a leaf (which is needed to be deleted).

//so helper function returns the Node* value pointer

Node* helper(Node* root);

//now we need another function which can get us the last right of the parent
//where the tobedeleted element's ->right has to be re-attach over there
//be it on the left subtree or the right subtree

Node* findLastRight(Node* root);


};

Node* BinarySearchTree::deleteNode(Node* root,int key){
    //obv if the root is NULL, then there's nothing to delete
    // so, we will return also NULL
    if(root==NULL){
        return NULL;
    }
    //if the situation is like below,then helper function will take care of it
    //by attatching the right child to the lastrightelement of leftChild.
    // and the helper function will return the modified node.
    if(root->data==key){
        return helper(root);
    }
    //the root of the BST doesn't change after it doesn't satisfy the above conditions
    Node* dummy=root;
    while(root!=NULL){
        if(root->data>key){//if the key is less than root->data
            //then i will to left obv
            if(root->left!=NULL && root->left->data==key){
                //the root->left Node is obv less than data
                //as well as the key is less
                //means the minute they are unequal shows us that
                //the key must actually be larger than it or greater than it
                //so we will jump,make root=root->left,so that
                //we start afresh and make comparisions with this
                //and the key all again from the line 107
                root->left=helper(root->left);
                //so the element which is needed to be deleted is found and we will 
                // replace the pointer pointing towards it to the pointer
                // (head) which we are going to get from the helper function and
                // vice verca.

                //then our job is done, we will break the loop
                break;
            }
            else{//idc if it's not equal to key,then i will jump on Node to left(as key is less)
                root=root->left;
            }
        }
        else{//if root->data<key,if the key is greater than the root->data
        //then  i will go right obv
        if(root->right!=NULL && root->right->data==key){
            root->right=helper(root->right);
            break;
        }
        else{
            root=root->right;
        }
        }
    }
    return dummy;

}

Node* BinarySearchTree::helper(Node* root){
    //obv if the Nodetobedelted->left is NULL
    //to need to rearrange the links,directly the  Nodetobedeleted->right is
    //returned and vice versa,if both are NULL, NULL will be returned Obv
    //which will set itselves
    if(root->left==NULL)
        return root->right;

    else if(root->right==NULL)
        return root->left;
    
    //the right child is being saved to that we won't loose it
    //we are going to attach this to the lastrightelement of the leftchild.
    Node* rightchild=root->right;
//   the lastrightelement of the root->left element has to be found out, to 
//   insert the rightchild at the lastrightelement
    Node* lastright=findLastRight(root->left);
    //now the rightchild is inserted at the lastright->right 
    //because obviously the (all the elements) of the rightchild will be greater than
    //each and everyelement of the left subtree, so there has to be no problem
    //in re-attaching the rightchild at the lastright->right .
    lastright->right=rightchild;
// after this is done,the root->left becomes the new root(parent) after the element(relinkation or deletion)
//which we are returning, it will return,whatever is returned, it will be attatched
//to the parent->right or parent->left according to the situation.
    return root->left;
}

Node* BinarySearchTree::findLastRight(Node* root){
    if(root->right==NULL){
        return root;
    }
    return findLastRight(root->right);
}

Node* BinarySearchTree::SearchElement(Node* curr,int key){
    if (curr==NULL){
        return NULL;
    }
    else if(curr->data==key){
        return curr;
    }
    else if(curr->data>key){
        return SearchElement(curr->left,key);
    }
    
    return SearchElement(curr->right,key);

}

//definition of CreateRoot
Node* BinarySearchTree::CreateRoot(){
    if(this->root==NULL){//obv it will be
        int data;//the data, which we want to be the root of the BST
        cout<<"Enter root: ";
        cin>>data;
        Node *newnode=new Node(data);
        //because this->root is NULL, and we are initializing the root of the BST
        this->root=newnode;
        cout<<"The Root Created Successfully: "<<endl;
        return this->root;
    }
    cout<<"Root already created"<<endl;
    return this->root;
}

//Insertion method Definition
Node* BinarySearchTree::Insert(Node* curr,int val){
    if(curr==NULL){
        Node* newnode=new Node(val);
        return newnode;
    }
    else if(val>curr->data){
        curr->right=Insert(curr->right,val);
    }
    else if(val<curr->data){
        curr->left=Insert(curr->left,val);
    }
    return curr;
}

//Printing the levelOrderway of Binary Search Tree to check the insertions
void BinarySearchTree::printLevelOrder(Node *curr){
    //there is no point in printing if curr==NULL
    if(curr==NULL){
        return;
    }
    queue<Node*>q;
    q.push(root);
    q.push(NULL);
    while(!q.empty()){
        Node *node=q.front();
        q.pop();
        if(node!=NULL){
            cout<<node->data<<" ";
            if(node->left)
                q.push(node->left);
            if(node->right)
                q.push(node->right);
        }
        else if(!q.empty()){//q non empty means null might be present only
            q.push(NULL);
        }
    }
}



int main()
{   BinarySearchTree Bst;
    Node *rooOfBst=Bst.CreateRoot();
    // cout<<"The root is: "<<rooOfBst->data;
    // Bst.Insert(rooOfBst,100);
    Bst.Insert(rooOfBst,50);
    Bst.Insert(rooOfBst,200);
    Bst.Insert(rooOfBst,40);
    Bst.Insert(rooOfBst,70);
    Bst.Insert(rooOfBst,150);
    Bst.Insert(rooOfBst,300);
    Bst.printLevelOrder(rooOfBst);
    Bst.Insert(rooOfBst,175);
    cout<<"----------------after---------"<<endl;
    Bst.printLevelOrder(rooOfBst);
    Bst.deleteNode(rooOfBst,70);
    Bst.deleteNode(rooOfBst,200);
    cout<<"----------------after---------deletion"<<endl;

    Bst.printLevelOrder(rooOfBst);

    // Node* test=Bst.SearchElement(Bst.root,1000);
    // if(test==NULL){
    //     cout<<endl<<"Element is not present";
    // }
    // else{
    //     cout<<endl<<"Element is present.";
    // }
    return 0;
}
