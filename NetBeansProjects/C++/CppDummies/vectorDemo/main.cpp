/* 
 * File:   main.cpp
 * Author: alice
 *
 * Created on May 22, 2014, 11:04 PM
 */

#include <cstdlib>

#include <iostream>
#include <vector>
#include <string>

using namespace std;

class Employee
{
public:
	string Name;
	string FireDate;
	int GoofoffDays;

	Employee(string aname, string afiredate, int agoofdays) : Name(aname), FireDate(afiredate), GoofoffDays(agoofdays) {}
};

int main()
{
	// A vector that holds strings
	vector<string> MyAliases;
	MyAliases.push_back(string("Bud The Sailor"));
	MyAliases.push_back(string("Rick Fixit"));
	MyAliases.push_back(string("Bobalou Billow"));
	cout << MyAliases[0] << endl;
	cout << MyAliases[1] << endl;
	cout << MyAliases[2] << endl;

	// A vector that holds integers
	vector<int> LuckyNumbers;
	LuckyNumbers.push_back(13);
	LuckyNumbers.push_back(26);
	LuckyNumbers.push_back(52);
	cout << LuckyNumbers[0] << endl;
	cout << LuckyNumbers[1] << endl;
	cout << LuckyNumbers[2] << endl;

	// A vector that holds Employee instances
	vector<Employee> GreatWorkers;
	GreatWorkers.push_back(Employee("George Washington", "123100", 50));
	GreatWorkers.push_back(Employee("Thomas Jefferson", "052002", 40));
	cout << GreatWorkers[0].Name << endl;
	cout << GreatWorkers[1].Name << endl;
	return 0;
}
