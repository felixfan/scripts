/* 
 * File:   Oven.cpp
 * Author: alice
 * 
 * Created on June 1, 2014, 11:22 PM
 */

#include "Oven.h"
#include <iostream>

using namespace std;

Oven::Oven() {
}

Oven::Oven(const Oven& orig) {
}

Oven::~Oven() {
}


void Oven::TurnOnHeatingElement()
{
    cout << "Heating element is now ON! Be careful!" << endl;
}

void Oven::TurnOffHeatingElement()
{
    cout << "Heating element is now off. Relax!" << endl;
}
void Oven::Bake(int Temperature)
{
    TurnOnHeatingElement();
    cout << "Baking!" << endl;
    TurnOffHeatingElement();
}


