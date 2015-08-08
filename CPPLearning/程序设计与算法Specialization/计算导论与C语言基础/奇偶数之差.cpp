#include <iostream>
using namespace std;
/*
输入6个正整数，且这6个正整数中至少存在一个奇数和一个偶数。
设这6个正整数中最大的奇数为a，最小的偶数为b，求出|a-b|的值
*/
int main() {
	int n=6;
	int maxOdd=0, minEven=0;
	for(int i=0; i<n;i++){
		int tmp;
		cin >> tmp;
		if(tmp % 2 == 0){
			if(minEven==0){
				minEven = tmp;
			}else{
				if(tmp < minEven){
					minEven = tmp;
				}
			}
		}else{
			if(maxOdd==0){
				maxOdd = tmp;
			}else{
				if(tmp > maxOdd){
					maxOdd = tmp;
				}
			}
		}
	}
	
	int ans = maxOdd - minEven;
	if(ans < 0){
		ans = - ans;
	}
	cout << ans << endl;
	
	return 0;
}
