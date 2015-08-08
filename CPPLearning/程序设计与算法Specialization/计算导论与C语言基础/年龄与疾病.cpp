#include <iostream>
#include <cstdio>
using namespace std;

/*
描述
某医院想统计一下某项疾病的获得与否与年龄是否有关，
需要对以前的诊断记录进行整理。

输入
共2行，第一行为过往病人的数目n（0 < n <= 100)，
第二行为每个病人患病时的年龄。

输出
每个年龄段（分四段：18以下，19-35，36-60，60-注意看样例输出的格式）
的患病人数占总患病人数的比例，以百分比的形式输出，
精确到小数点后两位（double）。
*/
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
