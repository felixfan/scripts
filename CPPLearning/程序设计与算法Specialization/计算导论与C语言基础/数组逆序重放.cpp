#include <iostream>
using namespace std;

/*
��һ�������е�ֵ���������´�š�
���磬ԭ����˳��Ϊ8,6,5,4,1��Ҫ���Ϊ1,4,5,6,8��
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