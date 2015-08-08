#include <iostream>
#include <cmath>
#include <cstdio>
using namespace std;

/*
描述
给定一组点(x,y)，求距离最远的两个点之间的距离。

输入
第一行是点数n（n大于等于2）
接着每一行代表一个点，由两个浮点数x y组成。

输出
输出一行是最远两点之间的距离。
*/
int main() {
	int n;
	cin >> n;
	double x[n], y[n];
	for(int i=0; i<n; i++){
	    cin >> x[i] >> y[i];
	}
	
	double dist = 0;
	for(int i=0; i<n-1;i++){
	    for(int j=i+1;j<n;j++){
	        double d = sqrt((x[j]-x[i])*(x[j]-x[i]) + (y[j]-y[i])*(y[j]-y[i]));
	        if(d > dist){
	            dist = d;
	        }
	    }
	}
	
	printf("%.4f\n", dist);
	
	return 0;
}
