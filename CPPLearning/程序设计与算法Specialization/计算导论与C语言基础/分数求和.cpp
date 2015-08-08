#include <iostream>
using namespace std;

int main() {
	int n;
	cin >> n;
	
	// 分子分母分别求和
	int sumn = 0, sumd = 1; // sumn / sumd = 0
	while(n--){ // read each one and add to sumn/sumd
		int num, den;
		char slash;
		cin >> num >> slash >> den;
		sumn = sumn * den + sumd * num;
		sumd = sumd * den;
	}
	
	// 最大公约数
	int a = sumd, b = sumn, gcd;
	while(a!=0){
		gcd = a;
		a = b % a;
		b = gcd;
	}
	
	// 约分
	sumd /= gcd;
	sumn /= gcd;
	
	if(sumd != 1){
		cout << sumn << '/' << sumd << endl;
	}else{
		cout << sumn << endl;
	}
	
	return 0;
}
