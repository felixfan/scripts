#include <iostream>
using namespace std;

/*
һֻ����ڿ��ˣ�Ҫ��20��ˮ���ܽ�ʣ�������ֻ��һ����h���ף�
����뾶Ϊr���׵�СԲͰ(h��r��������)���ʴ�������Ҫ�ȶ���
Ͱˮ�Ż��ʡ�
*/
int main() {
	int h, r;
	cin >> h >> r;
	int ans = 0;
	double v = 3.14159 * r * r * h / 1000;

	ans = (int) (20 / v) + 1;
	
	cout << ans << endl;
	
	return 0;
}
