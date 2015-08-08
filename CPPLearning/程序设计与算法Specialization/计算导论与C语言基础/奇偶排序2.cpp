#include <iostream>
using namespace std;

int main() {
	int a[10];
	for(int i=0; i<10; i++){
		cin >> a[i];
	}
	
	for(int i=0; i< 10-1; i++){
		for(int j=i+1; j < 10; j++){
			if(a[j] < a[i]){
				int temp = a[j];
				a[j] = a[i];
				a[i] = temp;
			}
		}
	}
	
	for(int i=0; i< 10; i++){
		if(a[i] % 2 != 0){
			cout << a[i] << " ";
		}
	}
	
	for(int i=0; i< 10; i++){
		if(a[i] % 2 == 0){
			cout << a[i] << " ";
		}
	}
	return 0;
}