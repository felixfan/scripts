#include <iostream>
using namespace std;

int main() {
	int n, a[100];
	cin >> n;

	for(int i = 0; i < n; i++ ){
		cin >> a[i];
	}
	
	int one=0, five=0, ten=0;
	
	for(int i = 0; i < n; i++ ){
		if(a[i]==1){
			one++;
		}else if(a[i]==5){
			five++;
		}else if(a[i]==10){
			ten++;
		}
	}
	
	cout << one << endl;
	cout << five << endl;
	cout << ten << endl;
	return 0;
}
