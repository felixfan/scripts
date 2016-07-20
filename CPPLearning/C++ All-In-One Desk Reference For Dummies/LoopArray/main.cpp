#include <iostream>

using namespace std;

//C++ All-In-One for Dummies, 2nd Edition
//Book I: Introducing C++
//Chapter 8: Using Advanced C++ Features

const int MyArraySize = 10;

class CrackedMusicCD
{
public:
    string FormerName;
    int FormerLength;
    int FormerProductionYear;
};

void Crunch(int myarray[], int size)
{
    for (int i=0; i<size; i++)
    {
        cout << myarray[i] << endl;
    }
}

int main()
{
    int GrilledShrimp[5];
    for (int i=0; i<5; i++)
    {
        GrilledShrimp[i] = i * 2;
        cout << GrilledShrimp[i] << endl;
    }

    CrackedMusicCD *missing[10];
    for (int i=0; i<10; i++)
    {
        missing[i] = new CrackedMusicCD;
    }

    missing[0]->FormerName = "Shadow Dancing by Andy Gibb";

    cout << missing[0]->FormerName << endl;

    for (int i=0; i<10; i++)
    {
        delete missing[i];
        missing[i] = 0;
    }

    int BigArray[MyArraySize];
    for (int i=0; i<MyArraySize; i++)
    {
        BigArray[i] = i * 2;
    }

    Crunch(BigArray, MyArraySize);

    return 0;
}
