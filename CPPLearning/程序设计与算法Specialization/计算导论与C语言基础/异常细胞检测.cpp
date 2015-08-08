#include <iostream>
using namespace std;

int main() {
	int a[100][100];
	int n;
	cin >> n;
	int diff = 0;
	
	for(int i=0; i<n; i++){
		for(int j=0; j<n; j++){
			cin >> a[i][j];
		}
	}
	
	for(int i=1; i<n-1; i++){
		for(int j=1; j<n-1; j++){
			int d1 = a[i-1][j] - a[i][j];
			int d2 = a[i+1][j] - a[i][j];
			int d3 = a[i][j-1] - a[i][j];
			int d4 = a[i][j+1] - a[i][j];
			if(d1>=50 && d2>=50 && d3>=50 && d4>=50){
				diff++;
			}
		}
	}
	cout << diff << endl;
	return 0;
}
