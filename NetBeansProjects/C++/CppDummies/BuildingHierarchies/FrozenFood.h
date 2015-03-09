/* 
 * File:   FrozenFood.h
 * Author: alice
 *
 * Created on May 23, 2014, 1:38 PM
 */

#ifndef FROZENFOOD_H_INCLUDED
#define FROZENFOOD_H_INCLUDED

class FrozenFood
{
private:
    int Price;
protected:
    int Weight;
public:
    FrozenFood(int APrice, int AWeight);
    int GetPrice();
    int GetWeight();
};

#endif // FROZENFOOD_H_INCLUDED
