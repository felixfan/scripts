/* 
 * File:   main.cpp
 * Author: alice
 *
 * Created on May 22, 2014, 11:02 PM
 */

#include <cstdlib>

#include <iostream>
#include <map>
#include <string>

using namespace std;

int main()
{
	// supplying to the template the types of first the keys and then the values
	map<string, string> marriages;

	marriages["Tom"] = "Suzy";
	marriages["Harry"] = "Harriet";
	cout << marriages["Tom"] << endl;
	cout << marriages["Harry"] << endl;
	return 0;
}
