#include <iostream>
using namespace std;

/*
����ʦ���ڵġ�������ۡ����ſ����п��Ըոս�����
����֪��������ȡ�õ���߷�������Ϊ�����Ƚ϶࣬
������������齻������������ȽϷ��㡣
���ܰ�����ʦ������������
*/
int main() {
	int n, max=0;
	cin >> n;
	for(int i=0; i<n;i++){
		int tmp;
		cin >> tmp;
		if(tmp > max){
			max = tmp;
		}
	}
	
	cout << max << endl;
	
	return 0;
}
