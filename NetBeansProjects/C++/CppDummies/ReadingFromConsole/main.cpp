/* 
 * File:   main.cpp
 * Author: alice
 *
 * Created on May 30, 2014, 6:16 PM
 */

#include <cstdlib>

#include <iostream>
#include <sstream>
#include <conio.h>

#include "ConvertingTypes.h"

using namespace std;

//C++ All-In-One for Dummies, 2nd Edition
//Book I: Introducing C++
//Chapter 8: Using Advanced C++ Features

string EnterOnlyNumbers()
{
    string numAsString = ""; // Holds the numeric string.
    char ch = getch(); // Obtains a single character from the user.

    // Keep requesting characters until the user presses Enter.
    while (ch != '\r') // \r is the enter key
    {
        // Add characters only if they are numbers.
        if (ch >= '0' && ch <= '9')
        {
        cout << ch;
        numAsString += ch;
        }
        // Get the next character from the user.
        ch = getch();
    }

    return numAsString;
}

string EnterPassword()
{
    string numAsString = ""; // Holds the password string.
    char ch = getch(); // Obtains a single character from the user.

    // Keep requesting characters until the user presses Enter.
    while (ch != '\r') // \r is the enter key
    {
    // Display an asterisk instead of the input character.
    cout << '*';
    // Add the character to the password string.
    numAsString += ch;
    // Get the next character from the user.
    ch = getch();
    }

    return numAsString;
}

int main()
{
    // Just a basic name-entering
    string name;
    cout << "What is your name?";
    cin >> name;
    cout << "Hello " << name << endl;

    // Now you are asked to enter a number,
    // but the computer allows you to enter anything!
    int x;
    cout << endl;
    cout << "Enter a number, any number! ";
    cin >> x;
    cout << "You chose " << x << endl;

    // This time you can only enter a number.
    cout << endl;
    cout << "This time you'll only be able to enter a number! " << endl;
    cout << "Enter a number, any number! ";
    string entered = EnterOnlyNumbers();
    ConvertingTypes ct;
    int num = ct.StringToNumber(entered);
    cout << endl << "You entered " << num << endl;

    // Now enter a password!
    cout << endl;
    cout << "Enter your password! ";
    string password = EnterPassword();
    cout << endl << "Shhhh, it's " << password << endl;

    return 0;
}
