#include <iostream>
#include <cmath>
#include <cstdio>
using namespace std;

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
