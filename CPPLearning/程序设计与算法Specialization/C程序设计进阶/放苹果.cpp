#include <iostream>
using namespace std;

/*
��M��ͬ����ƻ������N��ͬ��������������е����ӿ��Ų��ţ�
�ʹ��ж����ֲ�ͬ�ķַ�������K��ʾ��
5��1��1��1��5��1 ��ͬһ�ַַ���
*/

int placeApple(int n, int m){ // n Apples and m Plates
	if(n<=1 || m<=0){
		return 1;
	}else{
		if(m > n){
			return placeApple(n, n);
		}else{
			return (placeApple(n, m-1) + placeApple(n-m, m));
		}
	}
}
int main() {
	int n, m;
	cin >> n >> m;
	cout << placeApple(n, m) << endl;
	return 0;
}