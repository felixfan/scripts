#include <iostream>
using namespace std;
/*
计算正整数 m 到 n（包括m 和 n ）之间的所有奇数的和
*/
int main() {
	int m, n;
	cin >> m >> n;
	int sum = 0;
	for(int i = m; i <= n; i++ ){
		if(i % 2 != 0){
			sum += i;
		}
	}
	cout << sum << endl;
	return 0;
}
