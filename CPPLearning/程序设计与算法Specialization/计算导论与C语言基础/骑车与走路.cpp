#include <iostream>
#include <limits> 
#include <cmath>
using namespace std;
/*
����
�ڱ���У԰��,û�����г�,�Ͽΰ��»�ܲ�����.
��ʵ����,����ȥ���κ����鶼���ﳵ��,��Ϊ�ﳵ
��Ҫ�ҳ���������ͣ����������,��Ҫ����һЩʱ��.
�����ҵ����г�,�������������г���ʱ��Ϊ27��;
ͣ��������ʱ��Ϊ23��;����ÿ������1.2��,
�ﳵÿ������3.0��.���ж��߲�ͬ�ľ���ȥ����,
���ﳵ�컹����·��.

����
��һ��Ϊ����������ݵ�����n
���ÿһ������Ϊһ�ΰ���Ҫ���ߵľ���,��λΪ��.

���
��Ӧÿ������,����ﳵ��,���һ��"Bike";
�����·��,���һ��"Walk";���һ����,���һ��"All".
*/
int main() {
	int n;
	cin >> n;
	while(n--){
		double s;
		cin >> s;
		double wt = s / 1.2;
		double bt = s/ 3.0 + 50;
		if(abs(wt - bt) < 0.0001){// compare two double
			cout << "All" << endl;
		}else if(wt < bt){
			cout << "Walk" << endl;
		}else if(wt > bt){
			cout << "Bike" << endl;
		}
	}
	return 0;
}
