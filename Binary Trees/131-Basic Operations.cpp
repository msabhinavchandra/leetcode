#include <iostream>
using namespace std;
#include<queue>

class Node
{

public:
    int data;
    Node *left;
    Node *right;

    Node(int val)
    { // constructor

        data = val;
        left = NULL;
        right = NULL;
    }
};

void preorder(Node *root)
{ // i will pass root.
    if (root == NULL)
    {
        return;
    }
    cout << root->data << " ";
    preorder(root->left);
    preorder(root->right);
    return;
}

void inorder(Node *root)
{ // i will pass root.
    if (root == NULL)
    {
        return;
    }

    inorder(root->left);
    cout << root->data << " ";
    inorder(root->right);
    return;
}

void postorder(Node *root)
{ // i will pass root.
    if (root == NULL)
    {
        return;
    }

    postorder(root->left);
    postorder(root->right);
    cout << root->data << " ";
    return;
}

void printLevelOrder(Node* root){
    if(root==NULL){//firstly if the root given itself is null,then there is no
        return;//point in printing it's elements in the level order way
    }
    queue<Node*> q;
    q.push(root);//push the first root into the queue.
    q.push(NULL);//serves purpose for the first time,to know that wheather the
                    //the level of the queue is done or not.  
    while(!q.empty()){//we will loop through the queue untill it gets empty,to print all the level order elements.
        Node *node=q.front();//temp kinda of a thing.
        q.pop(); 
        if(node!=NULL){//this is to check if the element in the queue is NULL or not
            cout<<node->data<<" ";//if it isn't print it's root and check if
            if(node->left){//it has left or right branches, if they are not NULL
                q.push(node->left);//push them into the queue.
            }
            if(node->right){
                q.push(node->right);
            }
        }
        else if(!q.empty()){//when you encounter NULL in the queue.
            q.push(NULL);//if it shows that u r done with your level.
        }
            
    }//while loop breaks when queue becomes empty,that's when all the elements are
}//printed.

Node* Create(){//preorder kinda of a creation of binary tree.
    int data;//for the data inside the node which is about to get inserted.
    cout<<"Enter data(-1 for no data): ";
    cin>>data;
    if(data==-1){
        return NULL;
    }
    Node* newnode=new Node(data);//dynamic memory allocation.
    cout<<"Enter Left Child of "<<data<<" : "<<endl;
    newnode->left=Create();
    cout<<"Enter Right Child of "<<data<<" : "<<endl;
    newnode->right=Create();
    return newnode;
}

//Find the height of the binary tree

int Height(Node* root){
    if(root==NULL){
        return 0;
    }
    int lf=Height(root->left);
    int rt=Height(root->right);
    if(lf>rt){
        return lf+1;
    }
    else{
        return rt+1;
    }
}


int main()
{                             // first i am making a binary tree
    //Node *root=Create(); // dynamic memory allocation.
    Node *root=new Node(1);
    root->left = new Node(2);
    root->right = new Node(3);
    root->left->left = new Node(4);
    // root->left->right = new Node(5);
    // root->right->left = new Node(6);
    // root->right->right = new Node(7);
    // Create();
    // preorder(root);
    // output:
    // 1 2 4 5 3 6 7
    // inorder(root);
    // output:
    // 4 2 5 1 6 3 7
    // cout<<" ";
    // postorder(root);
    printLevelOrder(root);
    // output:
    // 1 2 3 4 5 6 7
    int ht=Height(root);
    cout<<endl<<"Height: "<<ht;
    return 0;
}
