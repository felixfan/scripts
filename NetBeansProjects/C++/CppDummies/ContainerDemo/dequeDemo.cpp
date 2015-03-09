/*
A deque (pronounced “deck”) container is a sequential list of items like vector and list. 
Like vectors and unlike lists, deques allow bracket notation for random access. 
Unlike vector, deque lets you insert items at the beginning and pop items off the beginning. 

you can loop through the deque, accessing its members with a bracket, as if it’s an array.

You can also grab items off the front or back of the deque.

after pop_front or pop_back, the deque is empty!!! 
*/

#include "dequeDemo.h"

#include <iostream>
#include <deque>

using namespace std;

dequeDemo::dequeDemo() {
}

dequeDemo::dequeDemo(const dequeDemo& orig) {
}

dequeDemo::~dequeDemo() {
}

void dequeDemo::dequeExample(){
    deque<int> mydek;
    deque<int> mydek2;
    
    mydek.push_front(10);
    mydek.push_front(20);
    mydek.push_front(30);
    
    mydek.push_back(40);
    mydek.push_back(50);
    mydek.push_back(60);
    
    mydek2=mydek;
    
    cout << "=== deque demo ===" << endl;
    
    cout << "=== loop deque demo ===" << endl;
    int loop;
    for (loop = 0; loop < mydek.size(); loop++)
    {
        cout << mydek[loop] << endl;
    }
    
    cout << "=== pop_front deque demo ===" << endl;
    while (mydek.size() > 0)
    {
        cout << mydek.front() << endl;
        mydek.pop_front();
    }
    
    cout << "=== pop_back deque demo ===" << endl;
    while (!mydek2.empty()){
        cout << mydek2.back() << endl;
        mydek2.pop_back();
    }
    
}

