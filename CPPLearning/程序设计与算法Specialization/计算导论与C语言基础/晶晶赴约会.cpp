#include <iostream>
using namespace std;
/*
���������ѱ���Լ��������һ��ȥ��չ����
������ÿ�ܵ�1��3��5�пα����ϿΣ�
��ﾧ���ж����ܷ���ܱ��������룬
��������YES��������������NO��
*/
int main() {
	int n;
	cin >> n;
	if(n==1 || n==3 || n==5){
		cout << "NO" << endl;
	}else{
		cout << "YES" << endl;
	}
	return 0;
}
