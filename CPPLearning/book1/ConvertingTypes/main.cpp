#include <iostream>
#include <sstream> // for istringstream, ostringstream

#include "ConvertingTypes.h"

using namespace std;

//C++ All-In-One for Dummies, 2nd Edition
//Book I: Introducing C++
//Chapter 8: Using Advanced C++ Features

int main()
{
    float NumberOfKids; // Contains the theoretical number of kids.
    int ActualKids; // Contains an actual number of kids.

    /* You can theoretically have 2.5 kids, but in the real world,
    you can¡¯t. Convert the theoretical number of kids to a real
    number by truncating NumberOfKids and display the results. */

    cout << "Float to Integer" << endl;
    cout << "(Truncated)" << endl;

    NumberOfKids = 2.5;
    ActualKids = FloatToIntegerTruncated(2.5);

    cout << NumberOfKids << " " << ActualKids << endl;

    // Perform the same task as before, but use a theoretical 2.1 kids this time.
    NumberOfKids = 2.1;
    ActualKids = FloatToIntegerTruncated(2.1);
    cout << NumberOfKids << " " << ActualKids << endl;

    // This time we¡¯ll use 2.9 kids.
    NumberOfKids = 2.9;
    ActualKids = FloatToIntegerTruncated(2.9);
    cout << NumberOfKids << " " << ActualKids << endl;

    cout << "Float to Integer" << endl;
    // This process rounds the number, instead of truncating it.
    // We do it using the same three numbers as before.
    cout << "(Rounded)" << endl;

    NumberOfKids = 2.5;
    ActualKids = FloatToIntegerRounded(2.5);
    cout << NumberOfKids << " " << ActualKids << endl;
    // Do it again using 2.1 kids.
    NumberOfKids = 2.1;
    ActualKids = FloatToIntegerRounded(2.1);
    cout << NumberOfKids << " " << ActualKids << endl;
    // Do it yet again using 2.9 kids.
    NumberOfKids = 2.9;
    ActualKids = FloatToIntegerRounded(2.9);
    cout << NumberOfKids << " " << ActualKids << endl;

    cout << endl << "Integer to Float" << endl;
    // In this case, use the StringToNumber() function to perform the conversion.
    ActualKids = 3;
    NumberOfKids = IntegerToFloat(ActualKids);
    cout << NumberOfKids << endl << endl;

    cout << "String to number" << endl;
    int x = StringToNumber("12345") * 50;
    cout << x << endl << endl;

    cout << "Number to string" << endl;
    // In this case, use the NumberToString() function to perform the conversion.
    string mystring = NumberToString(80525323);
    cout << mystring << endl;

    return 0;
}
