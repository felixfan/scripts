#include <iostream>
#include <string>
using namespace std;

/*
描述
一个以'.'结尾的简单英文句子，单词之间用空格分隔，
没有缩写形式和其它特殊形式

输入
一个以'.'结尾的简单英文句子（长度不超过500），
单词之间用空格分隔，没有缩写形式和其它特殊形式

输出
该句子中最长的单词。如果多于一个，则输出第一个
*/
int main() {
	string str, maxWord, w="";
	int n=0, maxLen = 0;
	bool flag = true;
	getline(cin, str);
	// cout << str << endl;
	for(int i=0; i< str.size(); i++){
		// cout << str[i] << endl;
		if(str[i] ==' '){
			if(flag==true){
				flag = false;
				if(n > maxLen){
					maxLen = n;
					maxWord = w;
				}
				// cout << w << endl;
				n = 0;
				w = "";
			}
		}else if(str[i] == '.'){
			if(n > maxLen){
				maxLen = n;
				maxWord = w;
			}
		}else{
			n++;
			w += str[i];
			flag = true;
		}
	}
	cout << maxWord << endl;
	return 0;
}
