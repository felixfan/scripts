#include <iostream>
using namespace std;

/*
����
�û�����N��K��Ȼ���������N��������������ģ���
�����ڲ���N���������������£��ҳ���K�������
ע�⣬��K�������ζ�ŴӴ�С���ڵ�Kλ������
���ң�Ҫ���ұ�д�������Ҫ�õ��Զ���ĺ�����

����
N
K
a1 a2 a3 a4 ..... aN

���
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
