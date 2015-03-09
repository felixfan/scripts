/* 
 * File:   main.cpp
 * Author: alice
 *
 * Created on May 23, 2014, 1:35 PM
 */

#include <cstdlib>

#include <iostream>
#include "FrozenPizza.h"
#include "DeepDishPizza.h"

using namespace std;

int main(int argc, char *argv[])
{
    cout << "Thin crust pepperoni" << endl;
    FrozenPizza pepperoni(450, 12, 14);
    pepperoni.DumpInfo();
    cout << "\tPrice: " << pepperoni.GetPrice() << " cents" << endl;

    cout << "Deep dish extra-cheese" << endl;
    DeepDishPizza extracheese(650, 21592, 14, 3);
    extracheese.DumpInfo();
    extracheese.DumpDensity();
    cout << "\tPrice: " << extracheese.GetPrice() << " cents" << endl;

    return 0;
}


