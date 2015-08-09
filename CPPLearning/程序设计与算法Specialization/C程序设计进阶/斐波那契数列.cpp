#include <iostream>
using namespace std;

int shuLie(int n){
	if(n==1 || n==2){
		return 1;
	}else{
		return (shuLie(n-1) + shuLie(n-2));
	}
}
int main() {
	int n;
	cin >> n;
	cout << shuLie(n) << endl;
	return 0;
}