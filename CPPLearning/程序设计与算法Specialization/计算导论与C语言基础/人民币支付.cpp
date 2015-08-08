#include <iostream>
using namespace std;

/*
描述
从键盘输入一指定金额（以元为单位，如345），
然后输出支付该金额的各种面额的人民币数量，
显示100元，50元，20元，10元，5元，1元各多少张，
要求尽量使用大面额的钞票。

输入
一个小于1000的正整数。

输出
输出分行，每行显示一个整数，从上到下分别表示100元，
50元，20元，10元，5元，1元人民币的张数
*/
int main() {
	int n;
	cin >> n;
	cout << n/100 << endl;
	n %= 100;
	cout << n/50 << endl;
	n %= 50;
	cout << n/20 <<endl;
	n %= 20;
	cout << n/10 << endl;
	n %= 10;
	cout << n/5 << endl;
	cout << n%5 << endl;
	return 0;
}
