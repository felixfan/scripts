/* 
 * File:   main.cpp
 * Author: alice
 *
 * Created on May 22, 2014, 10:47 PM
 */

#include <cstdlib>

#include <iostream>
#include <list>
#include <string>

using namespace std;

class Duck
{
public:
	string name;
	int weight;
	int length;
};

ostream &operator << (ostream &out, const Duck &duck)
{
	cout << "(" << duck.name;
	cout << ", " << duck.weight;
	cout << ", " << duck.length;
	cout << ")";
	return out;
}

list<Duck>::iterator MoveToPosition(list<Duck> *mylist, int pos)
{
	list<Duck>::iterator res = mylist->begin();
	for (int loop = 1; loop <= pos; loop++)
	{
		res++;
	}
	return res;
}

void DumpDucks(list<Duck> *mylist)
{
	list<Duck>::iterator iter = mylist->begin();
	while (iter != mylist->end())
	{
		cout << *iter << endl;
		iter++;
	}
}

int main()
{
	list<Duck> Inarow;

	// Push some at the beginning
	Duck d1 = { "Jim", 20, 15 }; // Braces notation!
	Inarow.push_front(d1);

	Duck d2 = { "Sally", 15, 12 };
	Inarow.push_front(d2);

	// Push some at the end
	Duck d3 = { "Squakie", 18, 25 };
	Inarow.push_back(d3);

	Duck d4 = { "Trumpeter", 19, 26 };
	Inarow.push_back(d4);

	Duck d5 = { "Sneeky", 12, 13 };
	Inarow.push_back(d5);

	// Display the ducks
	cout << " == == == Display the ducks == == = " << endl;
	DumpDucks(&Inarow);

	// Reverse
	Inarow.reverse();
	cout << " == == == Reverse == == = " << endl;
	DumpDucks(&Inarow);

	// Splice
	// Need another list for this
	list<Duck> extras;

	Duck d6 = { "Grumpy", 8, 8 };
	extras.push_back(d6);

	Duck d7 = { "Sleepy", 8, 8 };
	extras.push_back(d7);

	Duck d8 = { "Ornery", 8, 8 };
	extras.push_back(d8);

	Duck d9 = { "Goofy", 8, 8 };
	extras.push_back(d9);

	cout << " == == == extras == == = " << endl;
	DumpDucks(&extras);

	/*
	The start and end position of the second list(the one we’re splicing members from) 
	and the position in the first list where we want to put the spliced members.

	MoveToPosition is a template function, but we didn’t provide the typename in angle brackets.
	The compiler can figure out which class version we need

	the elements that were inside the two lists before and after the splice
	the ducks moved from one list to another

	the splice includes the start position up to but not including the ending position
	*/
	list<Duck>::iterator first = MoveToPosition(&extras, 1);
	list<Duck>::iterator last = MoveToPosition(&extras, 3);
	list<Duck>::iterator into = MoveToPosition(&Inarow, 2);
	Inarow.splice(into, extras, first, last);

	cout << " == == == extras after splice == == = " << endl;
	DumpDucks(&extras);

	cout << " == == == Inarow after splice == == = " << endl;
	DumpDucks(&Inarow);

	return 0;
}

