#include <iostream>
using namespace std;

/*
将一个数组中的值按逆序重新存放。
例如，原来的顺序为8,6,5,4,1。要求改为1,4,5,6,8。
*/
int main() {
    int n, a[100];
    cin >> n;
    
    for(int i = 0; i < n; i++ ){
        cin >> a[i];
    }
    
    for(int i=n-1; i>=0; i--){
        cout << a[i] << " ";
    }
    
    return 0;
}