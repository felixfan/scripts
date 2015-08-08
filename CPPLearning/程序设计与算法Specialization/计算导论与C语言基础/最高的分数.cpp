#include <iostream>
using namespace std;

/*
孙老师讲授的《计算概论》这门课期中考试刚刚结束，
他想知道考试中取得的最高分数。因为人数比较多，
他觉得这件事情交给计算机来做比较方便。
你能帮孙老师解决这个问题吗？
*/
int main() {
	int n, max=0;
	cin >> n;
	for(int i=0; i<n;i++){
		int tmp;
		cin >> tmp;
		if(tmp > max){
			max = tmp;
		}
	}
	
	cout << max << endl;
	
	return 0;
}
