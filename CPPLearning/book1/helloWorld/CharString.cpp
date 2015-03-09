#include <iostream>
using namespace std;

void CharString()
{
    //Characters
    char ch;
    ch = 'a';
    cout << ch << endl;

    //Null character
    char nullchar = '\0';

    //Strings
    string mystring;
    mystring = "Hello there";
    cout << mystring << endl;

    //Getting a part of a string
    cout << mystring[2] << endl;
    char mychar = mystring[2];
    cout << mychar << endl;

    //Changing part of a string
    string x = "Hellq ";
    x[4] = 'o';
    cout << x << endl;

    //Adding onto a string
    x += "there";
    cout << x << endl;

    //Adding two strings
    string first1 = "hello ";
    string second1 = "there";
    string third = first1 + second1;
    cout << third << endl;

    //String Functions
    string words = "Something interesting and bizarre";
    cout << words << endl;

    words.insert(10, "seriously ");
    cout << words << endl;

    words.erase(19,16);
    cout << words << endl;

    words.replace(4, 5, "body");
    cout << words << endl;
}
