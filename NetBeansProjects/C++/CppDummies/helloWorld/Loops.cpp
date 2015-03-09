/* 
 * File:   Loops.cpp
 * Author: alice
 * 
 * Created on June 1, 2014, 11:46 PM
 */

#include "Loops.h"
#include <iostream>
using namespace std;

void Loops()
{
    //for loop
    int sum = 0;
    int i;
    for (i = 1; i <= 100; i++)
    {
        sum += i;
    }
    cout << sum << endl;

    for (i=10; i>=5; i--)
    {
        cout << i << endl;
    }

    double j;
    double sum2;
    for(j = 0.0; j <= 100.0; j += 0.1)
    {
        sum2 += j;
    }
    cout << sum2 << endl;

    sum=0;
    for(i = 0, j = 10; i <= 5, j <= 20; i++, j = j + 2)
    {
        cout << i << "\t" << j << endl;
        sum += i + j;
    }
    cout << sum << endl;

    //while loop
    i = 0;
    while (i <= 10)
    {
        cout << i << endl;
        i++;
    }

    //do ... while
    i = 0;
    do
    {
        cout << i << endl;
        i++;
    }
    while (i <= 10);

    //break
    for (i=0; i<10; i++)
    {
        cout << i << " ";
        if (i == 5)
        {
            break;
        }
        cout << i * 2 << endl;
    }
    cout << endl;

    //continue
    for (i=0; i<10; i++)
    {
        cout << i << " ";
        if (i == 5)
        {
            cout << endl;
            continue;
        }
        cout << i * 2 << endl;
    }
}



