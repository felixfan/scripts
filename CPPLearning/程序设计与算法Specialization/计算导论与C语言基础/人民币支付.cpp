#include <iostream>
using namespace std;

int main() {
	int n;
	cin >> n;
	cout << n/100 << endl;
	n %= 100;
	cout << n/50 << endl;
	n %= 50;
	cout << n/20 <<endl;
	n %= 20;
	cout << n/10 << endl;
	n %= 10;
	cout << n/5 << endl;
	cout << n%5 << endl;
	return 0;
}
