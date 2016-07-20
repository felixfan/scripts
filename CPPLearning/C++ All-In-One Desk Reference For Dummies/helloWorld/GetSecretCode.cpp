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
