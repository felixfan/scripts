#include <iostream>
using namespace std;

/*
�沨�����ʽ��һ�ְ������ǰ�õ��������ʽ
��2+3���沨����ʾ��Ϊ+ 2 3 
�磨2+3��*4���沨����ʾ��Ϊx + 2 3 4 
��д���������һ������ + - * /
�ĸ���������沨�����ʽ��ֵ
*/
double notation(){
	char str[20];
	cin >> str;
	switch(str[0]){
		case '+': return notation() + notation();
		case '-': return notation() - notation();
		case '*': return notation() * notation();
		case '/': return notation() / notation();
		default: return atof(str);
	}
}
int main() {
	cout << notation();
	return 0;
}