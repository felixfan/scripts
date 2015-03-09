/* 
 * File:   ConvertingTypes.h
 * Author: alice
 *
 * Created on May 30, 2014, 6:19 PM
 */

#ifndef CONVERTINGTYPES_H
#define	CONVERTINGTYPES_H

using namespace std;

class ConvertingTypes {
public:
    ConvertingTypes();
    ConvertingTypes(const ConvertingTypes& orig);
    virtual ~ConvertingTypes();
    int StringToNumber(string MyString);
    string NumberToString(int Number);
    int FloatToIntegerTruncated(float Number);
    int FloatToIntegerRounded(float Number);
    float IntegerToFloat(int Number);
private:

};

#endif	/* CONVERTINGTYPES_H */

