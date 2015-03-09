#ifndef OVEN_H_INCLUDED
#define OVEN_H_INCLUDED

class Oven
{
private:
    void TurnOnHeatingElement();
    void TurnOffHeatingElement();
public:
    void Bake(int Temperature);
};

#endif // OVEN_H_INCLUDED
