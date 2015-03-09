/* 
 * File:   GetSecretCode.cpp
 * Author: alice
 * 
 * Created on June 1, 2014, 11:42 PM
 */

#include "GetSecretCode.h"
#include <iostream>
#include <sstream>
#include <cstdlib>

using namespace std;

string *GetSecretCode()
{
string *code = new string;
code->append("CR");
int randomnumber = rand(); //#include <cstdlib>
ostringstream converter;
converter << randomnumber;
code->append(converter.str());
code->append("NQ");
return code;
}



