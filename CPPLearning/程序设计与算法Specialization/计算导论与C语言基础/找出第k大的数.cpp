#include <iostream>
using namespace std;

/*
描述
用户输入N和K，然后接着输入N个正整数（无序的），
程序在不对N个整数排序的情况下，找出第K大的数。
注意，第K大的数意味着从大到小排在第K位的数。
并且，要求大家编写这个程序要用到自定义的函数。

输入
N
K
a1 a2 a3 a4 ..... aN

输出
b
*/
int numLarger(int a[], int b, int n){
	int num = 0;
	for(int i=0; i<n; i++){
		if(a[i] > b){
			num++;
		}
	}
	return num;
}


int main() {
	int n, k;
	cin >> n >> k;
	int a[n];
	for(int i=0;i<n;i++){
		cin >> a[i];
	}
	
	for(int i=0;i<n;i++){
		if(numLarger(a, a[i], n)==k-1){
			cout << a[i] << endl;
			break;
		}
	}
	return 0;
}
