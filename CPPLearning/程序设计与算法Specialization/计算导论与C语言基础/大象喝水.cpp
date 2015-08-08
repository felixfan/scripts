#include <iostream>
using namespace std;

/*
一只大象口渴了，要喝20升水才能解渴，但现在只有一个深h厘米，
底面半径为r厘米的小圆桶(h和r都是整数)。问大象至少要喝多少
桶水才会解渴。
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
