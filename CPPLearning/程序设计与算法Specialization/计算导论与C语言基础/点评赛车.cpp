#include <iostream>
using namespace std;

/*
����
4��ר�Ҷ�4��������������
1��A˵��2����������õģ�
2��B˵��4����������õģ�
3��C˵��3������������õģ�
4��D˵�� B˵���ˡ�
��ʵ��ֻ��1��������ѣ���ֻ��1��ר��˵���ˣ�����3�˶�˵���ˡ�
���������ѳ��ĳ��ţ��Լ�˵�Ե�ר�ҡ�

����
�����롣

���
������С���һ�������ѳ��ĳ��ţ�1-4�е�ĳ�����֣���
�ڶ������˵�Ե�ר�ң�A-D�е�ĳ����ĸ����
*/
int main() {
	int best;
	bool a, b, c, d;
	for(best=1; best < 5; best++){
		a = (best == 2);
		b = (best == 4);
		c = (best != 3);
		d = !b;
		if(a+b+c+d != 1){
			continue;
		}
		cout << best << endl;
		if(a == 1){
			cout << "A" << endl;
		}else if(b == 1){
			cout << "B" << endl;
		}else if(c == 1){
			cout << "C" << endl;
		}else if(d == 1){
			cout << "D" << endl;
		}
	}
	return 0;
}
