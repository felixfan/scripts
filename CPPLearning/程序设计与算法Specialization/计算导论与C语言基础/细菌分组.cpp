#include <iostream>
using namespace std;

/*
有一种细菌分为A、B两个亚种，它们的外在特征几乎完全相同，
仅仅在繁殖能力上有显著差别，A亚种繁殖能力非常强，
B亚种的繁殖能力很弱。在一次为时一个 小时的细菌繁殖实验中，
实验员由于疏忽把细菌培养皿搞乱了，请你编写一个程序，
根据实验结果，把两个亚种的培养皿重新分成两组。
*/
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
