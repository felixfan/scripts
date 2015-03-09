/* 
 * File:   ConvertingTypes.h
 * Author: alice
 *
 * Created on June 1, 2014, 11:31 PM
 */

#ifndef CONVERTINGTYPES_H
#define	CONVERTINGTYPES_H

using namespace std;

class ConvertingTypes {
public:
    ConvertingTypes();
    ConvertingTypes(const ConvertingTypes& orig);
    virtual ~ConvertingTypes();
private:

};

int StringToNumber(string MyString);
string NumberToString(int Number);
int FloatToIntegerTruncated(float Number);
int FloatToIntegerRounded(float Number);
float IntegerToFloat(int Number);

#endif	/* CONVERTINGTYPES_H */

