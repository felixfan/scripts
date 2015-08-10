#include <iostream>
using namespace std;

/*
逆波兰表达式是一种把运算符前置的算术表达式
如2+3的逆波兰表示法为+ 2 3 
如（2+3）*4的逆波兰表示法为x + 2 3 4 
编写程序求解任一仅包含 + - * /
四个运算符的逆波兰表达式的值
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