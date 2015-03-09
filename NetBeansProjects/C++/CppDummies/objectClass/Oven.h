/* 
 * File:   Oven.h
 * Author: alice
 *
 * Created on June 1, 2014, 11:22 PM
 */

#ifndef OVEN_H
#define	OVEN_H

class Oven {
public:
    Oven();
    Oven(const Oven& orig);
    virtual ~Oven();
    void Bake(int Temperature);
private:
    void TurnOnHeatingElement();
    void TurnOffHeatingElement();

};

#endif	/* OVEN_H */

