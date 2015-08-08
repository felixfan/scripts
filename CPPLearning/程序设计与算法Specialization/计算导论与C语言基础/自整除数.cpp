#include <iostream>
using namespace std;

int main() {
	int n;
	cin >> n;
	for(int i=10; i<=n;i++){
		int ten = i / 10;
		int m = ten + i % 10;
		if(i % m == 0){
			cout << i << endl;
		}
	}
	return 0;
}
