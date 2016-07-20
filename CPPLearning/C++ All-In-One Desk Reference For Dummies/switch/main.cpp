#include <iostream>
#include <conio.h>

using namespace std;

//C++ All-In-One for Dummies, 2nd Edition
//Book I: Introducing C++
//Chapter 8: Using Advanced C++ Features

int main()
{
    // Display a list of options.
    cout << "Choose your favorite:" << endl;
    cout << "1. Apples " << endl;
    cout << "2. Bananas " << endl;
    cout << "3. Fried worms " << endl;
    cout << "4. Poison Apples " << endl;
    cout << "5. Lobster " << endl;

    // Obtain the user's selection.
    char ch = getch();
    // Continue getting user selections until the user
    // enters a valid number.
    while (ch < '1' || ch > '5')
    {
    ch = getch();
    }
    // Use a switch to display the user's selection.
    cout << "You chose " << ch << endl;

    switch (ch)
    {
        case '1':
            cout << "Apples are good for you!" << endl;
            break;
        case '2':
            cout << "Bananas have plenty of potassium!" << endl;
            break;
        case '3':
            cout << "That's disgusting!" << endl;
            break;
        case '4':
            cout << "All I wanna know is WHY?" << endl;
            break;
        case '5':
            cout << "Expensive but good taste you have!" << endl;
            break;
    }

    return 0;
}
