#include <iostream>
#include <string>
using namespace std;
/*
����
�������ַ���str��substr��str���ַ�����������10��
substr���ַ�����Ϊ3�����ַ������������ַ�����β����'\0'����
��substr���뵽str��ASCII�������Ǹ��ַ����棬
���ж�������ֻ���ǵ�һ����

����
������������У�ÿһ��Ϊһ��������ݣ���ʽΪ
str substr

���
����ÿһ��������ݣ��������֮����ַ�����
*/
int main() {
    string str, substr;
    while(cin >> str >> substr){
        char max = str[0];
        int maxIndex = 0;
        for(int i=0; i<str.size();i++){
            if(str[i] > max){
                max = str[i];
                maxIndex = i;
            }
        }
        str.insert(maxIndex+1, substr);
        cout << str << endl;
    }
	
	return 0;
}
