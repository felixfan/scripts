/* 
 * File:   FrozenPizza.h
 * Author: alice
 *
 * Created on May 23, 2014, 1:38 PM
 */

#ifndef FROZENPIZZA_H
#define	FROZENPIZZA_H

#include "FrozenFood.h"

class FrozenPizza : public FrozenFood
{
protected:
    int Diameter;
public:
    FrozenPizza(int APrice, int AWeight, int ADiameter);
    void DumpInfo();
};

#endif	/* FROZENPIZZA_H */

