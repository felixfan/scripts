/* 
 * File:   main.cpp
 * Author: alice
 *
 * Created on May 30, 2014, 6:08 PM
 */

#include <cstdlib>

#include <iostream>

using namespace std;

class Gobstopper {
public:
    int WhichGobstopper;
    int Chew(string name) {
        cout << WhichGobstopper << endl;
        cout << name << endl;
        return WhichGobstopper;
    }
    static string MyClassName() {
        return "Gobstopper!";
    }
};

int TheSecretNumber(int x) {
    return x + 1;
}

int main(int argc, char *argv[])
{
    /*
    Pointing a variable to a function
    This defines a new type called FunctionPtr that
    returns an integer (the leftmost int) and
    takes an integer as a parameter (the rightmost int, which must be in parentheses).
    The middle part of this statement is the name of the new type,
    and you must precede it by an asterisk,
    which means that it¡¯s a pointer to all the rest of the expression.
    Also, you must put the type name and its preceding asterisk inside parentheses.
    */
    typedef int (*FunctionPtr)(int);
    FunctionPtr address = &TheSecretNumber;

    /*
    without using a typedef:
    int (*address)(int) = &TheSecretNumber;
    */

    int MyPasscode = 20;
    cout << address(MyPasscode) << endl;

    /*
    Pointing a variable to a member function
    If you look closely at the typedef, it looks similar to a regular function pointer.
    The only difference is that the classname and two colons precede the asterisk.
    Other than that, it¡¯s a regular old function pointer.
    */
    typedef int (Gobstopper::*GobMember)(string);
    GobMember func = &Gobstopper::Chew;

    Gobstopper inst;
    inst.WhichGobstopper = 10;
    inst.Chew("Greg W.");
    (inst.*func)("Greg W.");

    /*
    Pointing to static member functions
    */
    typedef string (*StaticMember)();
    StaticMember staticfunc = &Gobstopper::MyClassName;
    /*
    to call staticfunc, we didn¡¯t have to refer to a specific instance,
    and we didn¡¯t need to refer to the class, either.
    Because the truth is that deep down inside,
    the static function is just a plain old function.
    */
    cout << staticfunc() << endl;

    // A reference refers to another variable
    int ImSomebody;
    int &BestReference = ImSomebody;
    BestReference = 10;
    cout << ImSomebody << endl;

    return 0;
}
