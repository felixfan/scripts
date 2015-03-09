/* 
 * File:   Paranoid.cpp
 * Author: alice
 * 
 * Created on June 1, 2014, 11:50 PM
 */

#include "Paranoid.h"
#include <iostream>
using namespace std;

void Paranoid(string *realmessage)
{
(*realmessage)[6] = 'i';
realmessage->replace(9, 1, "");
realmessage->insert(18, "ad");
realmessage->replace(15, 2, "in");
realmessage->replace(23, 7, "!");
realmessage->replace(4, 3, "ali");
}



