#include <iostream>

#include <ctime>
#include <cstdlib>

using namespace std;

//C++ All-In-One for Dummies, 2nd Edition
//Book I: Introducing C++
//Chapter 8: Using Advanced C++ Features

int main()
{
    // Re-seed the random-number generator
    time_t now; //ctime
    time(&now); //ctime

    srand(now); //cstdlib
    rand();      //cstdlib

    // Print out a list of random numbers
    for (int i=0; i<5; i++)
    {
        cout << rand() % 100 << endl;
    }

    cout << "constant seeding" << endl;
    srand(9);
    for (int i=0; i<5; i++)
    {
        cout << rand() % 100 << endl;
    }

    return 0;
}

