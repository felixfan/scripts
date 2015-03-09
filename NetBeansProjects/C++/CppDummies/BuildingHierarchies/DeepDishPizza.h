/* 
 * File:   DeepDishPizza.h
 * Author: alice
 *
 * Created on May 23, 2014, 1:38 PM
 */

#ifndef DEEPDISHPIZZA_H_INCLUDED
#define DEEPDISHPIZZA_H_INCLUDED

#include "FrozenPizza.h"

class DeepDishPizza : public FrozenPizza
{
private:
    int Height;
public:
    DeepDishPizza(int APrice, int AWeight, int ADiameter, int AHeight);
    void DumpDensity();
};

#endif // DEEPDISHPIZZA_H_INCLUDED
