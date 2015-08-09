#include <iostream>
using namespace std;

/*
十进制转二进制
*/
void convert(int n){
	if(n/2 != 0){
		convert(n/2);
		cout << n%2;
	}else{
		cout << n%2;
	}
}
int main() {
	int n;
	cin >> n;
	convert(n);
	return 0;
}