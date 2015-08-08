#include <iostream>
using namespace std;

/*
从键盘输入一个任意的三位整数，要求正确地分离出它的百位、
十位和个位数，并分别在屏幕上输出，输出采用每行输出一个
数的方式，不带其它符号。
*/
int main() {
	int n;
	cin >> n;
	
	int g, s, b;
	
	g = n % 10;
	n /= 10;
	s = n % 10;
	b = n / 10;
	
	cout << b << endl;
	cout << s << endl;
	cout << g << endl;
	
	return 0;
}
