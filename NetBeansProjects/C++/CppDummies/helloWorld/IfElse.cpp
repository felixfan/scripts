/* 
 * File:   IfElse.cpp
 * Author: alice
 * 
 * Created on June 1, 2014, 11:45 PM
 */

#include "IfElse.h"
#include <iostream>
using namespace std;

void IfElse()
{
    //if ... else
    int i;
    cout << "Type any number: ";
    cin >> i;
    if(i > 10)
    {
        cout << "It's greater than 10." << endl;
    }
    else if(i == 10)
    {
        cout << "It's equal to 10" << endl;
    }
    else
    {
        cout << "It's less than 10." << endl;
    }
}



