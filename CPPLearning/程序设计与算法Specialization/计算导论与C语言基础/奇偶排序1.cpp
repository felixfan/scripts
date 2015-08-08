#include <iostream>
using namespace std;

int main() {
	int a[10];
	for(int i=0; i<10; i++){
		cin >> a[i];
	}
	
	int odd[10], even[10];
	int lj=0, lo=0;
	for(int i=0; i<10; i++){
		if(a[i] % 2 != 0){
			odd[lj++] = a[i];
		}else{
			even[lo++] = a[i];
		}
	}
	
	if(lj > 1){
		for(int i=0; i< lj -1; i++){
			for(int j=i+1; j < lj; j++){
				if(odd[j] < odd[i]){
					int temp = odd[j];
					odd[j] = odd[i];
					odd[i] = temp;
				}
			}
		}
	}
	
	if(lo > 1){
		for(int i=0; i< lo -1; i++){
			for(int j=i+1; j < lo; j++){
				if(even[j] < even[i]){
					int temp = even[j];
					even[j] = even[i];
					even[i] = temp;
				}
			}
		}
	}
	
	if(lj > 0){
		for(int i=0; i< lj; i++){
			cout << odd[i] << " ";
		}
	}
	
	if(lo > 0){
		for(int i=0; i< lo; i++){
			cout << even[i] << " ";
		}
	}
	return 0;
}