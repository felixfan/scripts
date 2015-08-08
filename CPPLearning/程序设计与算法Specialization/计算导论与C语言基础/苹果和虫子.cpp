#include <iostream>
using namespace std;

int main() {
    int n, x, y;
    cin >> n >> x >> y;
    int ans = 0;
    if(y % x == 0){
        ans = n - y / x;
    }else{
        ans = n - y / x - 1;
    }
    
    if(ans < 0){
    	ans = 0;
    }
    cout << ans << endl;
    
    return 0;
}