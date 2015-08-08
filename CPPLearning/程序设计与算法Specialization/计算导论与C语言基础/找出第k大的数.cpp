#include <iostream>
using namespace std;

int numLarger(int a[], int b, int n){
	int num = 0;
	for(int i=0; i<n; i++){
		if(a[i] > b){
			num++;
		}
	}
	return num;
}


int main() {
	int n, k;
	cin >> n >> k;
	int a[n];
	for(int i=0;i<n;i++){
		cin >> a[i];
	}
	
	for(int i=0;i<n;i++){
		if(numLarger(a, a[i], n)==k-1){
			cout << a[i] << endl;
			break;
		}
	}
	return 0;
}
