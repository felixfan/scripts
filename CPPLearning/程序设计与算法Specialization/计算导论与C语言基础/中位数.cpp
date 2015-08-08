#include <iostream>
using namespace std;

int main() {
	int n;
	int a[15001]={0};
	
	cin >> n;
	
	while(n!=0){
		for(int i=0; i<n; i++){
			cin >> a[i];
		}
		
		for(int i=0; i<n-1; i++){
			for(int j=i+1; j<n; j++){
				if(a[j] < a[i]){
					int tmp = a[i];
					a[i] = a[j];
					a[j] = tmp;
				}
			}
		}
		
		if(n % 2 != 0){
			cout << a[n/2] << endl;
		}else{
			cout << (a[n/2 - 1] + a[n/2])/2 << endl;
		}
		
		cin >> n;
	}
	return 0;
}
