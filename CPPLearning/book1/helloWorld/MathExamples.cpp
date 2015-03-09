#include <iostream>
#include <math.h>

#include "AddOne.h"

using namespace std;

void MathExamples()
{
    //Creating a Variable
    int mynumber;
    mynumber = 10;
    cout << mynumber << endl;

    //Changing values
    mynumber = 20;
    cout << mynumber << endl;

    //Declaring multiple variables
    int tom, dick, harry;
    tom = 10;
    dick = 20;
    harry = 3254;
    cout << tom << "\t" << dick << "\t" << harry << endl;

    //Setting one variable equal to another
    int start = 50;
    int finish;
    finish = start;
    cout << finish << endl;

    //Adding integer variables
    int s;
    int t;
    s = 37;
    t = 22;
    cout << s + t << endl;

    //Add 1 to a variable
    int z = 1;
    cout << z << endl;
    z = z + 1;
    cout << z << endl;
    z += 1;
    cout << z << endl;
    z++;
    cout << z << endl;

    //Subtracting integer variables
    int final;
    final = 28;
    final = final - 5;
    cout << final << endl;
    final -= 5;
    cout << final << endl;
    final--;
    cout << final << endl;

    //Multiplying, Dividing integer variables
    int first, second, result;
    first = 28;
    second = 14;
    cout << first * second << endl;
    cout << "Dividing 28 by 14." << endl;
    cout << "Quotient" << first / second << endl;
    cout << "Remainder" << first % second << endl;

    cout << fabs(-10.5) << endl;
    cout << fabs(10.5) << endl;
    cout << fabs(-5) << endl;

    double mynumber1 = fabs(-23.87);
    cout << mynumber1 << endl;

    double number = 10.0;
    double exponent = 3.0;
    cout << pow(number, exponent) << endl;

    cout << 1 + 2 << endl;
    cout << 5 + 10 / 2 * 3 + 25 << endl;

    // call other function
    cout << AddOne(99) << endl;
}
