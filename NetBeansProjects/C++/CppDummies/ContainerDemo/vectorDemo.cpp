/*
 * At this point, you may be wondering, what’s the advantage to using a vector 
 * instead of a regular, plain old, no-frills array? The advantage is that, 
 * when you declare the vector instance, you don’t need to know up front 
 * how many items will be going in it. With an array, you need to know the size 
 * when you declare it.
 * 
 * A vector is the closest thing the Standard Library has to an array. In fact, 
 * a vector is very much like an array, except (being a class template) you get 
 * all the goodies that go with a class, such as member functions that operate 
 * on vector.
 * 
 * Here are some things you can do with vector:
 * 
 * Add items to the end of it 
 * Access its members by using bracket notation 
 * Iterate through it, either from beginning to end or from end back to beginning
 
 */
#include <iostream>
#include <vector>
#include "vectorDemo.h"

using namespace std;

vectorDemo::vectorDemo() {
}

vectorDemo::vectorDemo(const vectorDemo& orig) {
}

vectorDemo::~vectorDemo() {
}

void vectorDemo::vectorExample(){
    cout << "===vector demo===" << endl;
    
    // A vector that holds strings
    vector<string> names;   
    names.push_back("Tom");
    names.push_back("Dick");
    names.push_back("Harry");
    names.push_back("April");
    names.push_back("May");
    names.push_back("June");
    cout << names[0] << endl;
    cout << names[5] << endl;
    
    // A vector that holds integers
    vector<int> LuckyNumbers;
    LuckyNumbers.push_back(13);
    LuckyNumbers.push_back(26);
    LuckyNumbers.push_back(52);
    cout << LuckyNumbers[0] << endl;
    cout << LuckyNumbers[1] << endl;
    cout << LuckyNumbers[2] << endl;
    
    // A vector that holds Employee instances
    vector<Employee> GreatWorkers;
    GreatWorkers.push_back(Employee("George Washington","12310", 50));
    GreatWorkers.push_back(Employee("Thomas Jefferson","052002", 40));
    cout << GreatWorkers[0].Name << endl;
    cout << GreatWorkers[1].FireDate << endl;
}