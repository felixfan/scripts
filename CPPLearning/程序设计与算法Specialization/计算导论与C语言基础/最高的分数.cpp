#include <iostream>
using namespace std;

int main() {
	int n, max=0;
	cin >> n;
	for(int i=0; i<n;i++){
		int tmp;
		cin >> tmp;
		if(tmp > max){
			max = tmp;
		}
	}
	
	cout << max << endl;
	
	return 0;
}
