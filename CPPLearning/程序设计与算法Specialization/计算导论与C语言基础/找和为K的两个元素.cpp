#include <iostream>
using namespace std;

int main() {
	int n, k;
	cin >> n >> k;
	int a[n];
	for(int i=0;i<n;i++){
		cin >> a[i];
	}
	
	bool flag = false;
	for(int i=0;i<n-1;i++){
		for(int j = i+1; j<n;j++){
			if(a[i] + a[j] == k){
				flag=true;
				break;
			}
		}
	}
	
	if(flag == true){
		cout << "yes" << endl;
	}else{
		cout << "no" << endl;
	}
	
	return 0;
}

