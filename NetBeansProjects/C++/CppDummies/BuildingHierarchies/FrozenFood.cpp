/* 
 * File:   FrozenFood.cpp
 * Author: alice
 * 
 * Created on May 23, 2014, 1:38 PM
 */


#include "FrozenFood.h"


FrozenFood::FrozenFood(int APrice, int AWeight)
{
    Price = APrice;
    Weight = AWeight;
}

int FrozenFood::GetPrice()
{
    return Price;
}

int FrozenFood::GetWeight()
{
    return Weight;
}
