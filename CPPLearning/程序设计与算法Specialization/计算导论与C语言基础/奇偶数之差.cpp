#include <iostream>
using namespace std;

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
