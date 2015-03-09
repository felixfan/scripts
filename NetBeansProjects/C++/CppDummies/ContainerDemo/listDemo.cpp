/*
A list is a simple container similar to an array, except you can’t access the
members of list by using a bracket notation as you can in vector or an
array. You don’t use list when you don’t need access to only one item in
the list; you use it when you plan to traverse through the list, item-by-item.

To add items to a list, use the list’s push_front member function or its
push_back member function. The push_front function inserts the item in the 
beginning of the list. The push_back function adds the item to the end of the list. 

With a list, you do not have random access to the list.
 */

#include "listDemo.h"

#include <iostream>
#include <list>

using namespace std;

listDemo::listDemo() {
}

listDemo::listDemo(const listDemo& orig) {
}

listDemo::~listDemo() {
}

class Duck
{
    public:
    string name;
    int weight;
    int length;
};

ostream &operator << (ostream &out, const Duck &duck)
{
    cout << "(" << duck.name;
    cout << "," << duck.weight;
    cout << "," << duck.length;
    cout << ")";
    return out;
}
void PrintList(list<Duck> *mylist)
{
    list<Duck>::iterator iter = mylist->begin();
    while (iter != mylist->end())
    {
        cout << *iter << endl;
        iter++;
    }
}

// MoveToPosition, is a template function.
list<Duck>::iterator MoveToPosition(list<Duck> *mylist, int pos)
{
    list<Duck>::iterator res = mylist->begin();
    for (int loop = 1; loop <= pos; loop++)
    {
        res++;
    }
    return res;
}


void listDemo::listExample(){
    list<Duck> Inarow;
    
    // Push some at the beginning
    Duck d1 = {"Jim", 20, 15}; // Braces notation!
    Inarow.push_front(d1);
    
    Duck d2 = {"Sally", 15, 12};
    Inarow.push_front(d2);
    
    // Push some at the end
    Duck d3 = {"Squakie", 18, 25};
    Inarow.push_back(d3);
    
    Duck d4 = {"Trumpeter", 19, 26};
    Inarow.push_back(d4);
    
    Duck d5 = {"Sneeky", 12, 13};
    Inarow.push_back(d5);
    
    // Display the ducks
    cout << "===========" << endl;
    cout << "Inarow:" << endl;
    PrintList(&Inarow);
    
    // Reverse
    Inarow.reverse();
    cout << "===========" << endl;
    cout << "Inarow (reversed):" << endl;
    PrintList(&Inarow);
    
    // Splice
    // Need another list for this
    list<Duck> extras;
    
    Duck d6 = {"Grumpy", 8, 8};
    extras.push_back(d6);
    
    Duck d7 = {"Sleepy", 8, 8};
    extras.push_back(d7);
    
    Duck d8 = {"Ornery", 8, 8};
    extras.push_back(d8);
    
    Duck d9 = {"Goofy", 8, 8};
    extras.push_back(d9);
    
    cout << "===========" << endl;
    cout << "extras:" << endl;
    PrintList(&extras);
    
    // move the elements in extras (from position 1 to position 3) to Inarow (at position 2)
    // the splice includes the start position up to but not including the ending position.
    list<Duck>::iterator first = MoveToPosition(&extras, 1);
    list<Duck>::iterator last = MoveToPosition(&extras, 3);
    list<Duck>::iterator into = MoveToPosition(&Inarow, 2);
    Inarow.splice(into, extras, first, last);
    
    cout << "===========" << endl;
    cout << "extras after splice:" << endl;
    PrintList(&extras);
    
    cout << "===========" << endl;
    cout << "Inarow after splice:" << endl;
    PrintList(&Inarow);
}
