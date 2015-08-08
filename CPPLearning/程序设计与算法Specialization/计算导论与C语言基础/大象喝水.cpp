#include <iostream>
using namespace std;

int main() {
	int h, r;
	cin >> h >> r;
	int ans = 0;
	double v = 3.14159 * r * r * h / 1000;

	ans = (int) (20 / v) + 1;
	
	cout << ans << endl;
	
	return 0;
}
