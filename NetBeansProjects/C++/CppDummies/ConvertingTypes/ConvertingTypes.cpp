/* 
 * File:   ConvertingTypes.cpp
 * Author: alice
 * 
 * Created on June 1, 2014, 11:31 PM
 */
#include <iostream>
#include <sstream> // for istringstream, ostringstream
#include "ConvertingTypes.h"
using namespace std;

ConvertingTypes::ConvertingTypes() {
}

ConvertingTypes::ConvertingTypes(const ConvertingTypes& orig) {
}

ConvertingTypes::~ConvertingTypes() {
}



int StringToNumber(string MyString)
{
    istringstream converter(MyString); // Converts from string to number.
    int result; // Contains the operation results.

    converter >> result; // Perform the conversion and return the results.
    return result;
}

string NumberToString(int Number)
{
    ostringstream converter; // Converts from number to string.
    converter << Number; // Perform the conversion and return the results.
    return converter.str();
}

int FloatToIntegerTruncated(float Number)
{
    return (int)Number;
}

int FloatToIntegerRounded(float Number)
{
    return (int)(Number + 0.5);
}

float IntegerToFloat(int Number)
{
    return (float)Number;
}


