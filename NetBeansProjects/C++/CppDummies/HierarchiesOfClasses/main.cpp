/* 
 * File:   main.cpp
 * Author: alice
 *
 * Created on June 1, 2014, 11:28 PM
 */

#include <cstdlib>

#include <iostream>

using namespace std;

//C++ All-In-One for Dummies, 2nd Edition
//Book I: Introducing C++
//Chapter 7: Working with Classes

class Vehicle
{
public:
    int NumberOfWheels;
    void Drive()
    {
        cout << "Driving, driving, driving..." << endl;
    }
};

class Toyota : public Vehicle
{
public:
    void MeAndMyToyota()
    {
        cout << "Just me and my Toyota!" << endl;
    }
};

int main()
{
    Toyota MyCar;
    MyCar.MeAndMyToyota();
    MyCar.Drive();

    return 0;
}
