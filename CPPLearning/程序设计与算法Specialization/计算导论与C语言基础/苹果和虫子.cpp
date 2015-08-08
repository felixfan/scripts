#include <iostream>
using namespace std;
/*
你买了一箱n个苹果，很不幸的是买完时箱子里混进了一条虫子。
虫子每x小时能吃掉一个苹果，假设虫子在吃完一个苹果之前不会
吃另一个，那么经过y小时你还有多少个完整的苹果？
*/
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