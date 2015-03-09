/*When you iterate through map, you get back not just the value of each item 
 * nor the key of each item. Instead, you get back a pair of things — the key 
 * and the value together. These live inside an instance of a class called Pair.
 * (Although, really, it’s a template.) This pair instance has two member variables, 
 * first and second. The first member refers to the key in the pair, and the 
 * second member refers to the value in the pair.
 */

#include <map>
#include <string>
#include <iostream>
#include <vector>

#include "iteratorDemo.h"

using namespace std;

iteratorDemo::iteratorDemo() {
}

iteratorDemo::iteratorDemo(const iteratorDemo& orig) {
}

iteratorDemo::~iteratorDemo() {
}

void iteratorDemo::iteratorExample(){
    cout << "===iterator demo===" << endl;
    cout << "===Iterating through a map===" << endl;
    map<string, int> NumberWords;
    NumberWords["ten"] = 10;
    NumberWords["twenty"] = 20;
    NumberWords["thirty"] = 30;
    
    map<string, int>::iterator loopy = NumberWords.begin();
    while (loopy != NumberWords.end())
    {
        cout << loopy->first << " ";   // keys
        cout << loopy->second << endl; // values
        loopy++;
    }
    
    cout << "===Iterating through a vector===" << endl;
    vector<string> Words;
    Words.push_back("hello");
    Words.push_back("there");
    Words.push_back("ladies");
    Words.push_back("and");
    Words.push_back("aliens");
    
    vector<string>::iterator vectorloop = Words.begin();
    while (vectorloop != Words.end())
    {
        cout << *vectorloop << endl;
        vectorloop++;
    }
    
}
