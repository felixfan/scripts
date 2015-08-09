#include <iostream>
using namespace std;

/*
把M个同样的苹果放在N个同样的盘子里，允许有的盘子空着不放，
问共有多少种不同的分法？（用K表示）
5，1，1和1，5，1 是同一种分法。
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