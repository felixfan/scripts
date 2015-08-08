#include <iostream>
#include <string>
using namespace std;

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
