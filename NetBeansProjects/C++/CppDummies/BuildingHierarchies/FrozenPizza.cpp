/* 
 * File:   FrozenPizza.cpp
 * Author: alice
 * 
 * Created on May 23, 2014, 1:38 PM
 */

#include <iostream>
#include "FrozenPizza.h"

using namespace std;

FrozenPizza::FrozenPizza(int APrice, int AWeight, int ADiameter):FrozenFood(APrice, AWeight)
{
    Diameter = ADiameter;
}

void FrozenPizza::DumpInfo()
{
    cout << "\tFrozen pizza info:" << endl;
    cout << "\t\tWeight: " << Weight << " ounces" << endl;
    cout << "\t\tDiameter: " << Diameter << " inches" << endl;
}
