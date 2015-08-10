#include <iostream>
using namespace std;

/*
描述
有一种细菌分为A、B两个亚种，它们的外在特征几乎完全相同，仅仅在繁殖能力上有显著差别，A亚种繁殖能力非常强，B亚种的繁殖能力很弱。
在一次为时一个 小时的细菌繁殖实验中，实验员由于疏忽把细菌培养皿搞乱了，请你编写一个程序，根据实验结果，把两个亚种的培养皿重新分成两组。

输入
输入有多行，第一行为整数n（n≤100），表示有n个培养皿。
其余n行，每行有三个整数，分别代表培养皿编号，试验前细菌数量，试验后细菌数量。

输出
输出有多行：
第一行输出A亚种培养皿的数量，其后每行输出A亚种培养皿的编号，按繁殖率升序排列。
然后一行输出B亚种培养皿的数量，其后每行输出B亚种培养皿的编号，也按繁殖率升序排列。
*/
int main() {
	int n;
	double rate[100];
	int id[100];
	
	cin >> n;
	
	for(int i=0; i< n; i++){
		int a, b, c;
		cin >> a >> b >> c;
		id[i] = a;
		rate[i] = (double) c / b;
	}
	
	for(int i=0; i< n-1; i++){
		for(int j = i+1; j<n; j++){
			if(rate[j]< rate[i]){
				double tmp = rate[i];
				rate[i] = rate[j];
				rate[j] = tmp;
				
				int temp = id[i];
				id[i] = id[j];
				id[j] = temp;
			}
		}
	}
	
	double maxDiff = 0;
	int maxDiffID = 0;
	
	for(int i=0; i<n-1; i++){
		if(rate[i+1] - rate[i] > maxDiff){
			maxDiff = rate[i+1] - rate[i];
			maxDiffID = i;
		}
	}
	
	cout << n-1-maxDiffID << endl;
	for(int i = maxDiffID + 1; i < n; i++){
		cout << id[i] << endl;
	}
	
	cout << maxDiffID + 1 << endl;
	for(int i = 0; i <= maxDiffID; i++){
		cout << id[i] << endl;
	}
	
	return 0;
}
