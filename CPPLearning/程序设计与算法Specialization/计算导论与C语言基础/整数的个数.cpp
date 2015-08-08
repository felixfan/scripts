#include <iostream>
using namespace std;
/*
给定k（1<k<100）个正整数，其中每个数都是大于等于1，
小于等于10的数。写程序计算给定的k个正整数中，
1，5和10出现的次数。
*/
int main() {
	int n, a[100];
	cin >> n;

	for(int i = 0; i < n; i++ ){
		cin >> a[i];
	}
	
	int one=0, five=0, ten=0;
	
	for(int i = 0; i < n; i++ ){
		if(a[i]==1){
			one++;
		}else if(a[i]==5){
			five++;
		}else if(a[i]==10){
			ten++;
		}
	}
	
	cout << one << endl;
	cout << five << endl;
	cout << ten << endl;
	return 0;
}
