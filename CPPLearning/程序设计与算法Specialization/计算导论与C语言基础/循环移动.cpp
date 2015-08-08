#include <iostream>
using namespace std;

int main() {
	int n, m;
	cin >> n >> m;
	int a[n];
	for(int i=0; i<n; i++){
		cin >> a[i];
	}
	for(int i=0; i<n-m;i++){
		int tmp = a[0];
		for(int j=0; j<n-1; j++){
			a[j] = a[j+1];
		}
		a[n-1] = tmp;
	}
	
	for(int i=0; i<n; i++){
		cout << a[i] << " ";
	}
	return 0;
}
