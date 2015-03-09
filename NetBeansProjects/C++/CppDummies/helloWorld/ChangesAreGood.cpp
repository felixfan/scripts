/* 
 * File:   ChangesAreGood.cpp
 * Author: alice
 * 
 * Created on June 1, 2014, 11:40 PM
 */

#include "ChangesAreGood.h"
#include <iostream>
using namespace std;

void ChangesAreGood(int *myparam)
{
(*myparam) += 10;
cout << "Inside the function:" << endl;
cout << (*myparam) << endl;
}

