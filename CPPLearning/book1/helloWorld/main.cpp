#include <iostream>

#include "GlobalVar.h"
#include "AddOne.h"
#include "BigDog.h"
#include "PrintName.h"
#include "Loops.h"
#include "MathExamples.h"
#include "CharString.h"
#include "IfElse.h"
#include "PointerVariable.h"

using namespace std;

//C++ All-In-One for Dummies, 2nd Edition
//Book I: Introducing C++
//Chapter 1: Creating a First C++ Program
//Chapter 2: Storing Data in C++
//Chapter 3: Directing Your C++ Program Flow
//Chapter 4: Dividing Your Work with Functions
//Chapter 5: Dividing Between Source-Code Files
//Chapter 6: Referring to Your Data through Pointers

int main(int argc, char *argv[])
{
    cout << "Hello, I am your computer talking." << endl;

    //Accessing the Command-Line Parameters
    //The first item in the argv list is always the name of the program
    for (int index=0; index < argc; index++)
    {
    cout << argv[index] << endl;
    }

    //Reading from the Console
    string name;
    cout << "Type your name: ";
    cin >> name;
    cout << "Your name is " << name << endl;

    //Math
    MathExamples();

    //CHAR, STRING
    CharString();

    //if ... else ...
    IfElse();

    //Loops
    Loops();

    //PrintName Function
    PrintName("Thomas", "Jefferson");

    //BigDog Function
    BigDog(3);

    //Deciding between Conditional Operators, ? :
    int first2 = 10;
    int second2 = 20;
    string result2;
    result2 = (first2 == second2) ? "equal" : "not equal";
    cout << result2 << endl;

    //Boolean variables and conditional operators
    bool isequal;
    isequal = (first2 == second2);
    result2 = isequal ? "equal" : "not equal";
    cout << result2 << endl;

    // TEST global var
    cout << "Test global var, it is value is: " << MyGlobalVar << endl; //defined in BigDog.cpp
    MyGlobalVar=9; //reset value
    cout << "Test global var, it is value is: " << MyGlobalVar << endl;

    //Pointer Variable
    PointerVariable();

    return 0;
}

