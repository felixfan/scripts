/* 
 * File:   main.cpp
 * Author: alice
 *
 * Created on June 1, 2014, 11:18 PM
 */

#include <cstdlib>

#include <iostream>

using namespace std;

//C++ All-In-One for Dummies, 2nd Edition
//Book I: Introducing C++
//Chapter 8: Using Advanced C++ Features

int main()
{
    int Numbers[100];
    for (int i=0; i<100; i++)
    {
        Numbers[i] = i * 10;
    }

    int *cur;
    cur = Numbers;

    cout << *cur << endl;
    cur++;
    cout << *cur << endl;
    cur++;
    cout << *cur << endl;
    cur += 3;
    cout << *cur << endl;
    cur--;
    cout << *cur << endl;
    return 0;
}
