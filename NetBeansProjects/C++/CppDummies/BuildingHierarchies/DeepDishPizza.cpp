/* 
 * File:   DeepDishPizza.cpp
 * Author: alice
 * 
 * Created on May 23, 2014, 1:38 PM
 */


#include <iostream>
#include "DeepDishPizza.h"

using namespace std;

DeepDishPizza::DeepDishPizza(int APrice,int AWeight,int ADiameter,int AHeight):FrozenPizza(APrice,AWeight,ADiameter)
{
    Height = AHeight;
}

void DeepDishPizza::DumpDensity()
{
    // Calculate pounds per cubic foot of deep-dish pizza
    cout << "\tDensity: ";
    cout << Weight * 12 * 12 * 12 * 14 / (Height * Diameter * 22 * 16);
    cout << " pounds per cubic foot" << endl;
}
