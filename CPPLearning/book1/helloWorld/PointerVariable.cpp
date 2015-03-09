#include <iostream>

#include "ChangesAreGood.h"
#include "Paranoid.h"
#include "GetSecretCode.h"
#include "MessMeUp.h"

using namespace std;

void PointerVariable()
{
    int num = 10;
    cout << "num = " << num << endl;

    //declare a pointer variable
    int *pvNum;

    //puts the address of the variable 'num' in the 'pvNum' variable.
    pvNum = &num;
    cout << "pvNum = " << pvNum << endl;

    //two ways to get to the information in a variable
    num = 9;
    cout << "num = " << num << endl;

    *pvNum = 99;
    cout << "num = " << num << endl;

    //example
    int NumberOfPotholes;
    int *ptr = &NumberOfPotholes;
    int SaveForLater;
    *ptr = 6087;
    SaveForLater = *ptr;
    cout << SaveForLater << endl;
    *ptr = 7000;
    cout << *ptr << endl;
    cout << SaveForLater << endl;

    //Pointing to a String with Pointers
    string GoodMovie = "Best in Show";
    string *ptrToString = &GoodMovie;
    cout << *ptrToString << endl;
    *ptrToString = "Galaxy Quest";
    cout << GoodMovie << endl;

    //example
    string HorribleMovie;
    string *ptrToString2;
    HorribleMovie = "L.A. Confidential";
    ptrToString2 = &HorribleMovie;
    for (unsigned i = 0; i < HorribleMovie.length(); i++)
    {
        cout << (*ptrToString2)[i] << " ";
    }
    cout << endl;

    //example: Using Pointers to Point to Something Else and Back Again
    int ExpensiveComputer;
    int CheapComputer;
    int *ptrToComp;
    ptrToComp = &ExpensiveComputer;
    *ptrToComp = 2000;
    cout << *ptrToComp << endl;
    ptrToComp = &CheapComputer;
    *ptrToComp = 500;
    cout << *ptrToComp << endl;

    //Allocating Memory by Using new
    int *ptr2 = new int;
    *ptr2 = 10;
    cout << *ptr2 << endl;

    int *ptr3 = new int(10);
    cout << *ptr3 << endl;

    string *Password = new string("The egg salad is still not fresh.");
    cout << *Password << endl;
    cout << Password->length() << endl;
    cout << (*Password).length() << endl;

    //Freeing Pointers
    delete Password;
    Password = 0;

    //Using Pointers to Modify a Variable Passed into a Function
    int mynumber = 30;
    cout << "Before the function:" << endl;
    cout << mynumber << endl;
    ChangesAreGood(&mynumber);
    cout << "After the function:" << endl;
    cout << mynumber << endl;

    //Using a Function to Modify a String Passed into It by Using Pointers
    string message = "The friends are having dinner";
    cout << message << endl;
    Paranoid(&message);
    cout << message << endl;

    //Returning a Pointer from a String Involves Using an Asterisk in the Return Type
    cout << "method 1" << endl;
    string newcode;
    for (int index = 0; index < 10; index++)
    {
        newcode = *GetSecretCode();
        cout << newcode << endl;
    }

    cout << "method 2" << endl;
    string *newcode2;
    for (int index = 0; index < 10; index++)
    {
        newcode2 = GetSecretCode();
        cout << *newcode2 << endl;
    }

    //Passing by Reference
    int mynumber9 = 30;
    cout << "Before value: " << mynumber9 << endl;
    MessMeUp(mynumber9);
    cout << "After value: " << mynumber9 << endl;
}
