#include <iostream>
#include <cmath>
#include <cstdio>
using namespace std;

/*
����
һ����򵥵ļ�������֧��+, -, *, / �������㡣
���迼���������Ϊ�����������
���ݺ����������ᳬ��int��ʾ�ķ�Χ��

����
����ֻ��һ�У������������������е�1��2������Ϊ������
��3������Ϊ��������+,-,*,/����

���
���ֻ��һ�У�һ��������Ϊ��������Ȼ����
1. ������ֳ���Ϊ0��������������Divided by zero!
2. ���������Ч�Ĳ�����(����Ϊ +, -, *, / ֮һ����
�������Invalid operator!
*/
int main() {
	int a, b;
	char c;
	cin >> a >> b >> c;
	if(c == '+'){
	    cout << a+b << endl;
	}else if(c == '-'){
	    cout << a-b << endl;
	}else if(c == '*'){
	    cout << a*b << endl;
	}else if(c == '/'){
	    if(b == 0){
	        cout << "Divided by zero!" << endl;
	    }else{
	        cout << a/b << endl;
	    }
	}else{
	    cout << "Invalid operator!" << endl;
	}
	
	return 0;
}
