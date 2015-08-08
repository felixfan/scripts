#include <iostream>
#include <cstdio>
using namespace std;

int main() {
	int n, m;
	cin >> n;
	int g1=0, g2=0, g3=0, g4=0;
	int total = n;
	while(total--){
		cin >> m;
		if(m <= 18){
			g1++;
		}else if(m <=35){
			g2++;
		}else if(m<=60){
			g3++;
		}else{
			g4++;
		}
	}
	
	double f1=0, f2=0,f3=0,f4=0;
	f1 = (double) g1 / n * 100;
	f2 = (double) g2 / n * 100;
	f3 = (double) g3 / n * 100;
	f4 = (double) g4 / n * 100;
	
	printf("1-18: %.2f%s\n", f1,"%");
	printf("19-35: %.2f%s\n", f2,"%");
	printf("36-60: %.2f%s\n", f3,"%");
	printf("60-: %.2f%s\n", f4,"%");
	return 0;
}
