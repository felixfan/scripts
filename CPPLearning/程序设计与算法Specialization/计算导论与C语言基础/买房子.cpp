#include <iostream>
using namespace std;

/*
����

ĳ����Ա��ʼ��������нN����ϣ�����йش幫����һ��60ƽ�׵ķ��ӣ�
���ڼ۸���200�򣬼��跿�Ӽ۸���ÿ��ٷ�֮K���������Ҹó���Աδ
����н���䣬�Ҳ��Բ��ȣ����ý�˰��ÿ������N��ȫ������������
�ʵڼ����ܹ��������׷��ӣ���һ�귿��200������N��

����
�ж��У�ÿ����������N��10 <= N <= 50��, K��1 <= K <= 20��

���
���ÿ�����ݣ�����ڵ�20�����֮ǰ�����������׷��ӣ�
�����һ������M����ʾ������Ҫ�ڵ�M�������£�
�������Impossible�������Ҫ����
*/
int main() {
	double n, k;
	while(cin >> n >> k){
		bool flag = false;
		double price = 200;
		double salary = n;
		for(int i=1; i<21;i++){
			if(salary > price){
				cout << i << endl;
				flag = true;
				break;
			}
			salary += n;
			price += (price * k / 100);
		}
		if(flag==false){
			cout << "Impossible" << endl;
		}
	}
	return 0;
}
