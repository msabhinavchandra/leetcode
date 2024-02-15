// brute

/* Program to implement a stack using
two queue */
#include <bits/stdc++.h>

using namespace std;

class Stack {
	// Two inbuilt queues
	queue<int> q1, q2;

public:
	void push(int x)
	{
		// Push x first in empty q2
		q2.push(x);

		// Push all the remaining
		// elements in q1 to q2.
		while (!q1.empty()) {
			q2.push(q1.front());
			q1.pop();
		}

		// swap the names of two queues
		queue<int> q = q1;
		q1 = q2;
		q2 = q;
	}

	void pop()
	{
		// if no elements are there in q1
		if (q1.empty())
			return;
		q1.pop();
	}

	int top()
	{
		if (q1.empty())
			return -1;
		return q1.front();
	}

	int size() { return q1.size(); }
};

// Driver code
int main()
{
	Stack s;
	s.push(1);
	s.push(2);
	s.push(3);

	cout << "current size: " << s.size() << endl;
	cout << s.top() << endl;
	s.pop();
	cout << s.top() << endl;
	s.pop();
	cout << s.top() << endl;

	cout << "current size: " << s.size() << endl;
	return 0;
}

// Output:
// current size: 3
// 3
// 2
// 1
// current size: 1

// Optimal

#include<bits/stdc++.h>

using namespace std;

class Stack {
  queue < int > q;
  public:
    void Push(int x) {
      int s = q.size();
      q.push(x);
      for (int i = 0; i < s; i++) {
        q.push(q.front());
        q.pop();
      }
    }
  int Pop() {
    int n = q.front();
    q.pop();
    return n;
  }
  int Top() {
    return q.front();
  }
  int Size() {
    return q.size();
  }
};

int main() {
  Stack s;
  s.Push(3);
  s.Push(2);
  s.Push(4);
  s.Push(1);
  cout << "Top of the stack: " << s.Top() << endl;
  cout << "Size of the stack before removing element: " << s.Size() << endl;
  cout << "The deleted element is: " << s.Pop() << endl;
  cout << "Top of the stack after removing element: " << s.Top() << endl;
  cout << "Size of the stack after removing element: " << s.Size();

}

// Output:

// Top of the stack: 1
// Size of the stack before removing element: 4
// The deleted element is: 1
// Top of the stack after removing element: 4
// Size of the stack after removing element: 3

// Time Complexity: O(N)

// Space Complexity: O(N)