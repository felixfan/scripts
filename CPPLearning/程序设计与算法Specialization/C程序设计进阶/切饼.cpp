#include <iostream>
using namespace std;

/*
n������гɶ��ٿ�
*/
int qieBing(int n){
	if(n==0){
		return 1;
	}else{
		return (qieBing(n-1) + n);
	}
}
int main() {
	int n;
	cin >> n;
	cout << qieBing(n) << endl;
	return 0;
}