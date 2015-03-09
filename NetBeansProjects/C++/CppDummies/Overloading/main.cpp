/* 
 * File:   main.cpp
 * Author: alice
 *
 * Created on June 1, 2014, 11:20 PM
 */

#include <cstdlib>

#include <iostream>

using namespace std;

//C++ All-In-One for Dummies, 2nd Edition
//Book I: Introducing C++
//Chapter 7: Working with Classes

class Cat
{
public:
    string name;
};

class Dog
{
public:
    string name;
};

class Human
{
public:
    string name;
};

class Door
{
private:
    int HowManyInside;
public:
    void Start();
    void GoThrough(Cat *acat);
    void GoThrough(Dog *adog);
    void GoThrough(Human *ahuman);
};

void Door::Start()
{
    HowManyInside = 0;
}

void Door::GoThrough(Cat *somebody)
{
    cout << "Welcome, " << somebody->name << endl;
    cout << "A cat just entered!" << endl;
    HowManyInside++;
}

void Door::GoThrough(Dog *somebody)
{
cout << "Welcome, " << somebody->name << endl;
cout << "A dog just entered!" << endl;
HowManyInside++;
}

void Door::GoThrough(Human *somebody)
{
cout << "Welcome, " << somebody->name << endl;
cout << "A human just entered!" << endl;
HowManyInside++;
}

int main()
{
    Door entrance;
    entrance.Start();

    Cat *SneekyGirl = new Cat;
    SneekyGirl->name = "Sneeky Girl";

    Dog *LittleGeorge = new Dog;
    LittleGeorge->name = "Little George";

    Human *me = new Human;
    me->name = "Jeff";

    entrance.GoThrough(SneekyGirl);
    entrance.GoThrough(LittleGeorge);
    entrance.GoThrough(me);

    delete SneekyGirl;
    SneekyGirl = 0;

    delete LittleGeorge;
    LittleGeorge = 0;

    delete me;
    me = 0;

    return 0;
}
