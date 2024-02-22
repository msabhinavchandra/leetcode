#include <iostream>
using namespace std;
#include <queue>

class heap
{
public:
    int arr[100];
    int size = 0;

    void insert(int val)
    {

        size = size + 1;
        int index = size;
        arr[index] = val;

        while (index > 1)
        {
            int parent = index / 2;

            if (arr[parent] < arr[index])
            {
                swap(arr[parent], arr[index]);
                index = parent;
            }
            else
            {
                return;
            }
        }
    }

    void print()
    {
        for (int i = 1; i <= size; i++)
        {
            cout << arr[i] << " ";
        }
        cout << endl;
    }

    // function for deleting an element in the Heap
    void deleteFromHeap()
    {
        if (size == 0)
        {
            cout << "Nothing to delete" << endl;
            return;
        }
        // if not above then come down
        arr[1] = arr[size]; // add the last element to the first.
        size--;

        // take the root node to the correct position.
        int i = 1; // points to the root node, which was the last element earlier
        // the worst it can go is to the last element
        while (i < size)
        {
            int leftIndex = 2 * i;
            int rightIndex = 2 * i + 1;
            if (leftIndex <= size && arr[i] < arr[leftIndex])
            {
                swap(arr[leftIndex], arr[i]);
                i = leftIndex;
            }
            else if (rightIndex <= size && arr[i] < arr[rightIndex])
            {
                swap(arr[rightIndex], arr[i]);
                i = rightIndex;
            }
            else
            {
                return;
            }
        }
    }

    // Heapify Algorithm
    void heapify(int arr[], int n, int i)
    {
        int largest = i;
        int left = 2 * i;
        int right = 2 * i + 1;
        if (left <= n && arr[largest] < arr[left] && arr[left] > arr[right])
        {
            largest = left;
        }
        else if (right <= n && arr[largest] < arr[right] && arr[left] < arr[right])
        {
            largest = right;
        }

        if (largest != i)
        {
            swap(arr[largest], arr[i]);
            heapify(arr, n, largest);
        }
    }
};

void heapSort(int arr[],int n){
    int size=n;
    while(size>1){
        //step1:swap
        swap(arr[size],arr[1]);
        size--;
        heapify(arr,size,1);
    }
}

int main()
{
    heap hp;
    // hp.insert(5);
    // hp.insert(2);
    // hp.insert(6);
    // hp.insert(8);
    // hp.insert(9);
    // hp.insert(4);
    // cout<<"Before Deletion"<<endl;
    // hp.print();
    // hp.deleteFromHeap();
    // cout<<"After Deletion"<<endl;
    // hp.print();

    int arr[6] = {-1, 10, 20, 30, 40, 50};
    int n = 5;
    // for (int i = n / 2 ; i > 0; i--)//because at index 0 there is -1
    // {
    //     hp.heapify(arr, n, i);//hepifying every node,which has children.
    // }
    // cout << "After Heapification" << endl;
    // for (int i = 1; i <= n; i++)
    // {
    //     cout << arr[i] << " ";
    // }

    // by default this will be a max heap.
    priority_queue<int> pq;

    // pq.push(4);
    // pq.push(2);
    // pq.push(5);
    // pq.push(3);
    // cout<<"Element at top "<<pq.top()<<endl;
    // pq.pop();
    // cout<<"Element at top "<<pq.top()<<endl;
    // if(pq.empty()){
    // cout<<"Queue is empty"<<endl;
    // }else{
    // cout<<"Queue is not empty"<<endl;
    // minheap

    // if i want to make a min heap.

    priority_queue<int, vector<int>, greater<int>> minheap;

    // minheap.push(4);
    minheap.push(2);
    minheap.push(5);
    minheap.push(1);
    cout << "Element at top " << minheap.top() << endl;
    minheap.pop();
    cout << "Element at top " << minheap.top() << endl;
    if (minheap.empty())
    {
        cout << "Queue is empty" << endl;
    }
    else
    {
        cout << "Queue is not empty" << endl;
    }

    return 0;
}
