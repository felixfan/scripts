#include <iostream>
using namespace std;
/*
����
����һ��0--100�ķ������жϷ�������ʲô�ȼ���
95<=����<=100, ���1
90<=����<95,���2
85<=����<90,���3
80<=����<85,���4
70<=����<80,���5
60<=����<70���6
���� < 60;���7.

����
n

���
m
*/
int main() {
    int n;
    cin >> n;
    if(n < 60){
        cout << 7 << endl;
    }else if(n < 70){
        cout << 6 << endl;
    }else if(n < 80){
        cout << 5 << endl;
    }else if(n < 85){
        cout << 4 << endl;
    }else if(n < 90){
        cout << 3 << endl;
    }else if(n < 95){
        cout << 2 << endl;
    }else if(n <=100){
        cout << 1 << endl;
    }
    return 0;
}
