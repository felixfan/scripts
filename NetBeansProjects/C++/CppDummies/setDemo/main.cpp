/* 
 * File:   main.cpp
 * Author: alice
 *
 * Created on May 22, 2014, 10:09 PM
 */

#include <cstdlib>

#include <iostream>
#include <string>
# include <algorithm>  //set_intersection, set_union function
#include <set>

using namespace std;

void DumpClass(set<string> *myset)
{
	set<string>::iterator iter = myset->begin();
	while (iter != myset->end())
	{
		cout << *iter << endl;
		iter++;
	}
}

int main()
{
	set<string> EnglishClass;
	set<string> HistoryClass;

	EnglishClass.insert("Zeus");
	EnglishClass.insert("Magellan");
	EnglishClass.insert("Vulcan");
	EnglishClass.insert("Ulysses");
	EnglishClass.insert("Columbus");

	HistoryClass.insert("Vulcan");
	HistoryClass.insert("Ulysses");
	HistoryClass.insert("Ra");
	HistoryClass.insert("Odin");

	
	// List the items
	// ordered
	cout << "==List the items==" << endl << endl;
	set<string>::iterator iter = EnglishClass.begin();
	while (iter != EnglishClass.end())
	{
		cout << *iter << endl;
		iter++;
	}

	// Find an item
	cout << "==Find an item==" << endl << endl;
	iter = EnglishClass.find("Columbus");
	cout << *iter << endl;


	// Finding an Intersection and a Union with set

	set<string> Union;
	set<string> Intersection;

	//////////// method 1

	// The first part is the type of the variable, a template called insert_iterator.
	// The template parameter is the type of set, in this case set<string>.
	// The next part is the instance name, IntersectIterate, 
	// and the constructor requires two things : the set that will hold the intersection
	//	(called Intersection) and an iterator pointing to the the beginning of the Intersection set.
	insert_iterator< set<string> > IntersectIterate(Intersection, Intersection.begin());
	insert_iterator< set<string> > UnionIterate(Union, Union.begin());

	set_intersection(EnglishClass.begin(), EnglishClass.end(), HistoryClass.begin(), HistoryClass.end(), IntersectIterate);

	cout << " == = Intersection == = " << endl;
	DumpClass(&Intersection);

	set_union(EnglishClass.begin(),EnglishClass.end(),HistoryClass.begin(), HistoryClass.end(),UnionIterate);

	cout << endl << " == = Union == = " << endl;
	DumpClass(&Union);

	/////////////// method 2
	set_intersection(EnglishClass.begin(),EnglishClass.end(), 
		HistoryClass.begin(), HistoryClass.end(), 
		inserter(Intersection, Intersection.begin()));

	set_union(EnglishClass.begin(),EnglishClass.end(),
		HistoryClass.begin(), HistoryClass.end(),
		inserter(Union, Union.begin()));

	cout << " == = Intersection == = " << endl;
	DumpClass(&Intersection);
	cout << endl << " == = Union == = " << endl;
	DumpClass(&Union);

	return 0;
}

