#include <iostream>

#include "GlobalVar.h"

using namespace std;

void BigDog(int KibblesCount)
{
cout << "I'm a lucky dog" << endl;
cout << "I have " << KibblesCount << " pieces of food" << endl;
//test global var
MyGlobalVar=10;
cout << "Test: " << MyGlobalVar << endl;
}
