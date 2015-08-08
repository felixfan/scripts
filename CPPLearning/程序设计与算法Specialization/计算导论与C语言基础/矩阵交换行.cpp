#include <iostream>
#include <iomanip>
using namespace std;

/*
描述
编写一个函数，输入参数是5*5的二维数组，和n，m两个行下标。
功能：判断n，m是否在数组范围内，如果不在，则返回0；
如果在范围内，则将n行和m行交换，并返回1。
在main函数中， 生成一个5*5的矩阵，输入矩阵数据，
并输入n，m的值。调用前面的函数。如果返回值为0，输出error。
如果返回值为1，输出交换n，m后的新矩阵。

输入
5*5矩阵的数据，以及n和m的值。

输出
如果不可交换，则输出error；
如果可交换，则输出新矩阵
*/
int matrixExchangeRow(int a[5][5], int n, int m){
	if(n>=0 && n<5 && m>=0 && m<5){
		if(m != n){
			for(int i=0; i<5; i++){
				int tmp = a[n][i];
				a[n][i] = a[m][i];
				a[m][i] = tmp;
			}
		}
		return 1;
	}else{
		return 0;
	}
}

int main() {
	int a[5][5];
	int n, m;
	for(int i=0; i<5;i++){
		for(int j=0;j<5;j++){
			cin >> a[i][j];
		}
	}
	cin >> n >> m;
	int ans = matrixExchangeRow(a,n,m);
	if(ans==0){
		cout << "error" << endl;
	}else{
		for(int i=0; i<5;i++){
			for(int j=0;j<5;j++){
				cout << setw(4) << a[i][j];
			}
			cout << endl;
		}
	}
	return 0;
}
