#include <iostream>
using namespace std;

int main() {
	int n, id[100];
	double rate[100];
	
	cin >> n;
	
	for(int i=0;i<n;i++){
		int start, end;
		cin >> id[i] >> start >> end;
		rate[i] = (double) end / start;
	}
	
	for(int i=0; i<n-1;i++){
		for(int j=i+1;j<n;j++){
			if(rate[j] < rate[i]){
				int temp = id[i];
				id[i] = id[j];
				id[j] = temp;
				double r = rate[i];
				rate[i] = rate[j];
				rate[j] = r;
			}
		}
	}
	
	double maxDiff = 0;
	int maxDiffIndex = 0;
	
	for(int i=0; i<n-1; i++){
		if(rate[i+1]-rate[i] > maxDiff){
			maxDiff = rate[i+1]-rate[i];
			maxDiffIndex = i;
		}
	}
	
	cout << n - maxDiffIndex -1 << endl;
	for(int i=maxDiffIndex+1; i<n;i++){
		cout << id[i] << endl;
	}
	
	cout << maxDiffIndex + 1 << endl;
	for(int i=0; i<=maxDiffIndex; i++){
		cout << id[i] << endl;
	}
	
	return 0;
}
