#include <iostream>
#include <cstdio>
using namespace std;

/*
����
��һ���ַ������ҳ�Ԫ����ĸa,e,i,o,u���ֵĴ�����

����
����һ���ַ������ַ����п����пո�����gets(s)
������һ���ַ������뵽�ַ�����s�У����ַ�������С��80���ַ���

���
���һ�У��������a,e,i,o,u�������ַ����г��ֵĴ���������֮���ÿո�ָ���
*/
int main() {
	char str[80];
	gets(str); // The function is deprecated in C++ (as of 2011 standard, which follows C99+TC3).
	int a[5] = {0};
	for(int i=0; i< 80; i++){
		if(str[i] == 'a'){
			a[0]++;
		}else if(str[i] == 'e'){
			a[1]++;
		}else if(str[i] == 'i'){
			a[2]++;
		}else if(str[i] == 'o'){
			a[3]++;
		}else if(str[i] == 'u'){
			a[4]++;
		}else if(str[i] == '\0'){
			break;
		}
	}
	
	for(int i=0; i<5;i++){
		cout << a[i] << " ";
	}
	return 0;
}
