#include <iostream>
using namespace std;

int main() {
	int n, m;
	cin >> n;
	

	for(int i = 0; i < n; i++ ){
		cin >> m;
		int one = 0;
		while(m){
			if(m % 2 != 0){
				one++;
			}
			m /= 2;
		}
		cout << one << endl;
	}
	
	return 0;
}
