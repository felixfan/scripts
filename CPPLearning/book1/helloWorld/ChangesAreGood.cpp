#include <iostream>
using namespace std;

void ChangesAreGood(int *myparam)
{
(*myparam) += 10;
cout << "Inside the function:" << endl;
cout << (*myparam) << endl;
}
