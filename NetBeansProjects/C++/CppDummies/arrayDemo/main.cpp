/* 
 * File:   main.cpp
 * Author: alice
 *
 * Created on May 30, 2014, 6:04 PM
 */

#include <cstdlib>

#include <iostream>
#include "MyInt.h"

using namespace std;

int MyNumbers[] = {1,2,3,4,5,6,7,8,9,10};           // initialize an array without specifying the number of elements
int MyNumbers2[10] = {1,2,3,4,5,6,7,8,9,10};        // initialize an array with specifying the number of elements
extern int MyInts[];                                // skip the number in brackets when you use the extern word.

int AddUp(int Numbers[], int Count) {              // skip specifying the array size when you pass an array into a function
    int sum = 0;
    for (int loop = 0; loop < Count; loop++) {
        sum += Numbers[loop];
    }
    return sum;
}

void ProcessArray(int Numbers[]) {
    cout << "Inside function: Size in bytes is " << sizeof(Numbers) << endl;
}

int MemorizeThis[10][20];

int Numbers[5][6] = {
    {1,2,3,4,5,6},
    {7,8,9,10,12},
    {13,14,15,16,17,18},
    {19,20,21,22,23,24},
    {25,26,27,28,29,30}
};

int AddAll(int MyGrid[10][20]) {
    int sum = 0;
    for (int x = 0; x < 10; x++) {
        for (int y = 0; y < 20; y++) {
            sum += MyGrid[x][y];
        }
    }
    return sum;
}

const int secondD = 20;   // second dimesion
typedef int GridSecond[secondD]; //define a new type: GridSecond
int AddAll2(GridSecond MyGrid[], int firstD) { // same as AddAll function but more flexible
    int sum = 0;
    for (int x = 0; x < firstD; x++) {
        for (int y = 0; y < secondD; y++) {
            sum += MyGrid[x][y];
        }
    }
    return sum;
}


int main(int argc, char *argv[])
{
    int x, y;
    for (x= 0; x < 10; x++){
        for (y = 0; y < 20; y++ ) {
            MemorizeThis[x][y] = x * y;
        }
    }

    cout << "declaring array:" << endl;

    cout << "\t" << MyNumbers[3] << endl;
    cout << "\t" << MyNumbers2[3] << endl;

    cout << "extern declaring array:" << endl;
    cout << "\t" << MyInts[5] << endl;

    cout << "sum of the array:" << endl;
    cout << "\t" << AddUp(MyNumbers, 10) << endl;

    cout << "better approach to calculate the sum of the array:" << endl;
    cout << "\t" << AddUp(MyNumbers, sizeof(MyNumbers) / sizeof(int)) << endl;

    cout << endl << endl;

    cout << "Outside function: Size in bytes is ";
    cout << sizeof(MyNumbers) << endl;
    ProcessArray(MyNumbers); // you¡¯re passing an array, you¡¯re really passing a pointer to an array.

    cout << endl << endl;

    cout << "MemorizeThis[9][13] = " << MemorizeThis[9][13] << endl;
    cout << "Number of elements: " << sizeof(MemorizeThis) / sizeof(int) << endl;

    cout << endl << endl;

    cout << "Sum of two dimension array:" << endl;
    cout << AddAll(MemorizeThis) << endl;
    cout << "Sum of two dimension array (another method):" << endl;
    cout << AddAll2(MemorizeThis,10) << endl;

    cout << endl << endl;

    cout << "command-line parameters:" << endl;
    int loop;
    for (loop = 0; loop < argc; loop++) {
        cout << argv[loop] << endl;
    }

    cout << endl << endl;

    int *MyArray = new int[50];
    MyArray[0] = 25;
    cout << "MyArray[0] = " << MyArray[0] << endl;
    cout << "Address of MyArray[0]: " << MyArray << endl;
    delete[] MyArray;
    MyArray = 0;
    cout << "Address of MyArray[0]: " << MyArray << endl;

    cout << endl << endl;

    const int Permanent[5] = { 1, 2, 3, 4, 5 };    // Building constant arrays
    cout << "constant arrays: " << Permanent[1] << endl;

    return 0;
}
