#include <iostream>
using namespace std;
/*
约瑟夫问题：有ｎ只猴子，按顺时针方向围成一圈选大王（编号从１到ｎ），
从第１号开始报数，一直数到ｍ，数到ｍ的猴子退出圈外，剩下的猴子再接着
从1开始报数。就这样，直到圈内只剩下一只猴子时，这个猴子就是猴王，
编程求输入ｎ，ｍ后，输出最后猴王的编号。

输入
每行是用空格分开的两个整数，第一个是 n, 第二个是 m ( 0 < m,n <=300)。
最后一行是：0 0

输出
对于每行输入数据（最后一行除外)，输出数据也是一行，即最后猴王的编号
*/
int main() {
	while(1){
		int n, m;
		cin >> n >> m;
		if(n==0 && m==0){
			break;
		}
		int a[n];
		for(int i=0;i<n;i++){
			a[i]=i+1;
		}
		
		int j = 0;
		int count = 0;
		int rm = 0;
		while(1){
			if(a[j % n] !=0){
				count++;
			}
			if(count == m){
				a[j % n] = 0;
				count = 0;
				rm++;
			}
			if(rm==n-1){
				break;
			}
			j++;
		}
		
		for(int i=0;i<n;i++){
			if(a[i] != 0){
				cout << a[i] << endl;
				break;
			}
		}
	}
	return 0;
}
