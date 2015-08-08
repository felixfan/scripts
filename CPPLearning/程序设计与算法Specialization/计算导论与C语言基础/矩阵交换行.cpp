#include <iostream>
#include <iomanip>
using namespace std;

/*
����
��дһ�����������������5*5�Ķ�ά���飬��n��m�������±ꡣ
���ܣ��ж�n��m�Ƿ������鷶Χ�ڣ�������ڣ��򷵻�0��
����ڷ�Χ�ڣ���n�к�m�н�����������1��
��main�����У� ����һ��5*5�ľ�������������ݣ�
������n��m��ֵ������ǰ��ĺ������������ֵΪ0�����error��
�������ֵΪ1���������n��m����¾���

����
5*5��������ݣ��Լ�n��m��ֵ��

���
������ɽ����������error��
����ɽ�����������¾���
*/
int matrixExchangeRow(int a[5][5], int n, int m){
	if(n>=0 && n<5 && m>=0 && m<5){
		if(m != n){
			for(int i=0; i<5; i++){
				int tmp = a[n][i];
				a[n][i] = a[m][i];
				a[m][i] = tmp;
			}
		}
		return 1;
	}else{
		return 0;
	}
}

int main() {
	int a[5][5];
	int n, m;
	for(int i=0; i<5;i++){
		for(int j=0;j<5;j++){
			cin >> a[i][j];
		}
	}
	cin >> n >> m;
	int ans = matrixExchangeRow(a,n,m);
	if(ans==0){
		cout << "error" << endl;
	}else{
		for(int i=0; i<5;i++){
			for(int j=0;j<5;j++){
				cout << setw(4) << a[i][j];
			}
			cout << endl;
		}
	}
	return 0;
}
