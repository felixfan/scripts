/* 
 * File:   ConvertingTypes.cpp
 * Author: alice
 * 
 * Created on May 30, 2014, 6:19 PM
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


int ConvertingTypes::StringToNumber(string MyString)
{
    istringstream converter(MyString); // Converts from string to number.
    int result; // Contains the operation results.

    converter >> result; // Perform the conversion and return the results.
    return result;
}

string ConvertingTypes::NumberToString(int Number)
{
    ostringstream converter; // Converts from number to string.
    converter << Number; // Perform the conversion and return the results.
    return converter.str();
}

int ConvertingTypes::FloatToIntegerTruncated(float Number)
{
    return (int)Number;
}

int ConvertingTypes::FloatToIntegerRounded(float Number)
{
    return (int)(Number + 0.5);
}

float ConvertingTypes::IntegerToFloat(int Number)
{
    return (float)Number;
}
