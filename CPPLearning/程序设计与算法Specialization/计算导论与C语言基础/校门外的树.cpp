#include <iostream>
using namespace std;

int main() {
	int l, m;
	int trees[10001] = {0};
	
	cin >> l >> m;
	
	for(int i=0; i<=l; i++){
		trees[i]=1;
	}
	
	for(int i=0; i<m; i++){
		int a, b;
		cin >> a >> b;
		for(int j=a; j<=b; j++){
			trees[j]++;
		}
	}
	
	int ntree = 0;
	
	for(int i=0; i<=l; i++){
		if(trees[i]==1){
			ntree++;
		}
	}
	cout << ntree << endl;
	return 0;
}
