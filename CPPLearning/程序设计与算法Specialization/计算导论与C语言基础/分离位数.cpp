#include <iostream>
using namespace std;

/*
�Ӽ�������һ���������λ������Ҫ����ȷ�ط�������İ�λ��
ʮλ�͸�λ�������ֱ�����Ļ��������������ÿ�����һ��
���ķ�ʽ�������������š�
*/
int main() {
	int n;
	cin >> n;
	
	int g, s, b;
	
	g = n % 10;
	n /= 10;
	s = n % 10;
	b = n / 10;
	
	cout << b << endl;
	cout << s << endl;
	cout << g << endl;
	
	return 0;
}
