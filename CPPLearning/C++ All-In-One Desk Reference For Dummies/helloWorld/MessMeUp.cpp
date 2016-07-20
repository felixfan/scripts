#include <iostream>
using namespace std;

void MessMeUp(int &myparam)
{
myparam = myparam * 2 + 10;
cout << "in function value: "<< myparam << endl;
}
