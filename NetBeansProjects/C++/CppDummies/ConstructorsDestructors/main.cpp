/* 
 * File:   main.cpp
 * Author: alice
 *
 * Created on June 1, 2014, 11:35 PM
 */

#include <cstdlib>

#include <iostream>

using namespace std;

//C++ All-In-One for Dummies, 2nd Edition
//Book I: Introducing C++
//Chapter 7: Working with Classes

class Walnut
{
public:
    int Size;
};

class Squirrel
{
private:
    Walnut *MyDinner;
    string Name;
public:
    Squirrel(string StartName);
    ~Squirrel();
    void WhatIsMyName();
};

Squirrel::Squirrel(string StartName)
{
    cout << "Starting!" << endl;
    MyDinner = new Walnut;
    MyDinner->Size = 30;
    Name = StartName;
}

Squirrel::~Squirrel()
{
    cout << "Cleaning up my mess!" << endl;
    delete MyDinner;
    MyDinner = 0;
}

void Squirrel::WhatIsMyName()
{
cout << "My name is " << Name << endl;
}

int main()
{
    Squirrel *Sam = new Squirrel("Sam");
    Squirrel *Sally = new Squirrel("Sally");

    Sam->WhatIsMyName();
    Sally->WhatIsMyName();

    delete Sam;
    Sam = 0;

    delete Sally;
    Sally = 0;

    return 0;
}



