#include <iostream>
using namespace std;

int main() {
	int n, a[1000];
	
	cin >> n;
	for(int i = 0; i < n; i++){
		cin >> a[i];
	}
	
	for(int i=0; i< n -1; i++){
		for(int j=i+1; j < n; j++){
			if(a[j] < a[i]){
				int temp = a[j];
				a[j] = a[i];
				a[i] = temp;
			}
		}
	}
	
	for(int i = 0; i < n; i++){
		cout << a[i] << endl;
	}
	
	return 0;
}