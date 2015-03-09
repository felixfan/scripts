/* 
 * File:   main.cpp
 * Author: alice
 *
 * Created on May 22, 2014, 10:06 PM
 */

#include <cstdlib>

#include <iostream>
#include <map>
#include <vector>
#include <string>

using namespace std;

int main()
{
	// Iterating through a map
	map<string, int> NumberWords;
	NumberWords["ten"] = 10;
	NumberWords["twenty"] = 20;
	NumberWords["thirty"] = 30;
	map<string, int>::iterator loopy = NumberWords.begin();
	while (loopy != NumberWords.end())
	{
		cout << loopy->first << " ";
		cout << loopy->second << endl;
		loopy++;
	}
	// Iterating through a vector
	vector<string> Words;
	Words.push_back("hello");
	Words.push_back("there");
	Words.push_back("ladies");
	Words.push_back("and");
	Words.push_back("aliens");
	vector<string>::iterator vectorloop = Words.begin();
	while (vectorloop != Words.end())
	{
		cout << *vectorloop << endl;
		vectorloop++;
	}
	return 0;
}


