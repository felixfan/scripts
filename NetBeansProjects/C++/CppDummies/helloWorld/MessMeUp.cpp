/* 
 * File:   MessMeUp.cpp
 * Author: alice
 * 
 * Created on June 1, 2014, 11:49 PM
 */

#include "MessMeUp.h"
#include <iostream>
using namespace std;

void MessMeUp(int &myparam)
{
myparam = myparam * 2 + 10;
cout << "in function value: "<< myparam << endl;
}



