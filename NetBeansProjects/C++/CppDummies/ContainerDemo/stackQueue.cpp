/*Stack: you put items one-by-one on top of it, and you only take items one-by-one 
off the top of it.  This process is sometimes called a First In Last Out (FILO) algorithm.

Queue: You add data at the back of the queue, and take data off one-by-one at the front of the queue.  
This process is sometimes called a First In First Out (FIFO) algorithm.

You normally perform two operations with a stack and a queue:

✦ push: When you add an item to a stack or queue, you push the item. This
puts the item on top of the stack or at the back of the queue.

✦ pop: When you remove an item from a stack or from the front of the
queue, you pop it off.

When you specify a container to use inside the stack or queue, remember to put a space between 
the closing angle brackets. Otherwise, the compiler reads it as a single insertion 
operator, >>, and gets confused.
*/

#include "stackQueue.h"

#include <iostream>
#include <stack>
#include <queue>

using namespace std;

stackQueue::stackQueue() {
}

stackQueue::stackQueue(const stackQueue& orig) {
}

stackQueue::~stackQueue() {
}

void stackQueue::stackQueueExample(){
    cout << "===Stack Demo===" << endl;
    
    stack<int, vector<int> > MyStack; // Remember the space between the > >
    
    MyStack.push(5);
    MyStack.push(10);
    MyStack.push(15);
    MyStack.push(20);
    
    cout << "The 1st element (=20): ";
    // Views the first element in the Queue but does not remove it.
    cout << MyStack.top() << endl;
    
    cout << "The 1st element after pop (=15): ";
    MyStack.pop();
    cout << MyStack.top() << endl;
    MyStack.pop();
    MyStack.push(40);
    cout << MyStack.top() << endl;
    MyStack.pop();

    cout << "===Queue Demo===" << endl;
    
    queue<int> MyQueue;
    // No container specified in the queue, so it uses deque by default. The same goes for stack.
    
    MyQueue.push(5);
    MyQueue.push(10);
    MyQueue.push(15);
    
    cout << MyQueue.front() << endl;
    MyQueue.pop();
    cout << MyQueue.front() << endl;
    MyQueue.pop();
    MyQueue.push(40);
    cout << MyQueue.front() << endl;
    MyQueue.pop();
}