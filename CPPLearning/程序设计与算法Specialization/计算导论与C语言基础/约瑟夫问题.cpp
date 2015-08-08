#include <iostream>
using namespace std;

int main() {
	while(1){
		int n, m;
		cin >> n >> m;
		if(n==0 && m==0){
			break;
		}
		int a[n];
		for(int i=0;i<n;i++){
			a[i]=i+1;
		}
		
		int j = 0;
		int count = 0;
		int rm = 0;
		while(1){
			if(a[j % n] !=0){
				count++;
			}
			if(count == m){
				a[j % n] = 0;
				count = 0;
				rm++;
			}
			if(rm==n-1){
				break;
			}
			j++;
		}
		
		for(int i=0;i<n;i++){
			if(a[i] != 0){
				cout << a[i] << endl;
				break;
			}
		}
	}
	return 0;
}
