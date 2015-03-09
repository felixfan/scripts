/* 
 * File:   main.cpp
 * Author: alice
 *
 * Created on May 22, 2014, 10:03 PM
 */

#include <cstdlib>

#include <iostream>

using namespace std;

// Templatizing a class

template <typename T>
class CoolHolder
{
public:
	T first;
	T second;
	T third;
	T sum()
	{
		return first + second + third;
	}
};

template <typename T>
class SomethingForEveryone
{
public:
	T member;
};

template <int MaxPrice>
class PriceController
{
public:
	int Price;
	void TestPrice()
	{
		if (Price > MaxPrice)
		{
			cout << "Too expensive" << endl;
		}
		else
		{
			cout << "it is cheap" << endl;
		}
	}
};

template<typename K, typename V, int S>
class MyMap
{
protected:
	K key[S];
	V value[S];
	bool used[S];
	int Count;
	int Find(K akey)
	{
		int i;
		for (i = 0; i<S; i++)
		{
			if (used[i] == false)
				continue;
			if (key[i] == akey)
			{
				return i;
			}
		}
		return -1;
	}
	int FindNextAvailable()
	{
		int i;
		for (i = 0; i<S; i++)
		{
			if (used[i] == false)
				return i;
		}
		return -1;
	}
public:
	MyMap()
	{
		int i;
		for (i = 0; i<S; i++)
		{
			used[i] = false;
		}
	}
	void Set(K akey, V avalue)
	{
		int i = Find(akey);
		if (i > -1)
		{
			value[i] = avalue;
		}
		else
		{
			i = FindNextAvailable();
			if (i > -1)
			{
				key[i] = akey;
				value[i] = avalue;
				used[i] = true;
			}
			else
				cout << "Sorry, full!" << endl;
		}
	}
	V Get(K akey)
	{
		int i = Find(akey);
		if (i == -1)
		{
			return 0;
		}
		else
		{
			return value[i];
		}
	}
};

// Templatizing a Function
template <typename T> T AbsoluteValue(T x)
{
	if (x >= 0)
		return x;
	else
		return -x;
}

int main()
{
	CoolHolder<int> IntHolder;
	IntHolder.first = 10;
	IntHolder.second = 20;
	IntHolder.third = 30;
	cout << IntHolder.first << endl;
	cout << IntHolder.sum() << endl;

	CoolHolder<int> AnotherIntHolder;
	AnotherIntHolder.first = 100;
	AnotherIntHolder.second = 200;
	AnotherIntHolder.third = 300;
	cout << AnotherIntHolder.first << endl;
	cout << AnotherIntHolder.sum() << endl;

	CoolHolder<double> FloatHolder;
	FloatHolder.first = 3.1415;
	FloatHolder.second = 4.1415;
	FloatHolder.third = 5.1415;
	cout << FloatHolder.first << endl;
	cout << FloatHolder.sum() << endl;

	CoolHolder<int> *hold;
	for (int loop = 0; loop < 10; loop++)
	{
		hold = new CoolHolder<int>;
		hold->first = loop * 100;
		hold->second = loop * 110;
		hold->third = loop * 120;
		cout << hold->sum() << endl;
		delete hold;
		hold = 0;
	}

	cout << endl << endl;

	SomethingForEveryone<int> JustForMe;
	JustForMe.member = 2;
	cout << JustForMe.member << endl;

	cout << endl << endl;

	const int FredMaxPrice = 30;

	PriceController<FredMaxPrice> FredsToaster;
	FredsToaster.Price = 15;
	FredsToaster.TestPrice();

	PriceController<FredMaxPrice> FredsDrawingSet;
	FredsDrawingSet.Price = 45;
	FredsDrawingSet.TestPrice();

	cout << endl << endl;

	const int JulieMaxPrice = 60;

	PriceController<JulieMaxPrice> JuliesCar;
	JuliesCar.Price = 80;
	JuliesCar.TestPrice();

	cout << endl << endl;

	MyMap<char, int, 10> mymap;

	mymap.Set('X', 5);
	mymap.Set('Q', 6);
	mymap.Set('X', 10);

	cout << mymap.Get('X') << endl;
	cout << mymap.Get('Q') << endl;

	cout << endl << endl;

	int n = -3;
	cout << AbsoluteValue<int>(n) << endl;

	float x = -4.5;
	cout << AbsoluteValue<float>(x) << endl;

	return 0;
}

