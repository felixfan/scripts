#include <iostream>
#include <string>
using namespace std;

/*
描述
在一个字符串中找出元音字母a,e,i,o,u出现的次数。

输入
输入一行字符串（字符串中可能有空格，请用gets(s)
方法把一行字符串输入到字符数组s中），字符串长度小于80个字符。

输出
输出一行，依次输出a,e,i,o,u在输入字符串中出现的次数，整数之间用空格分隔。
*/

int main() {
	string str;
	getline(cin, str);
	int a[5] = {0};
	for(char &c : str){
		if(c == 'a'){
			a[0]++;
		}else if(c == 'e'){
			a[1]++;
		}else if(c == 'i'){
			a[2]++;
		}else if(c == 'o'){
			a[3]++;
		}else if(c == 'u'){
			a[4]++;
		}
	}
	for(int i=0; i<5;i++){
		cout << a[i] << " ";
	}
	return 0;
}
