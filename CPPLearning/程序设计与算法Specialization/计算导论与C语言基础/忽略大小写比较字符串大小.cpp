#include <iostream>
#include <string>
using namespace std;

int main() {
	string str1, str2;
	getline(cin, str1);
	getline(cin, str2);
	for(int i=0; i<str1.size(); i++){
		str1[i]=tolower(str1[i]);
	}
	for(int i=0; i<str2.size();i++){
		str2[i]=tolower(str2[i]);
	}
	
	int minSize = str1.size() < str2.size() ? str1.size() : str2.size();
	bool flag = 0;
	for(int i=0; i<minSize; i++){
		if(str1[i] > str2[i]){
			cout << ">" << endl;
			flag = 1;
			break;
		}else if(str1[i] < str2[i]){
			cout << "<" << endl;
			flag = 1;
			break;
		}
	}
	if(flag == 0){
		if(str1.size() == str2.size()){
			cout << "=" << endl;
		}else if(str1.size() < str2.size()){
			cout << "<" << endl;
		}else if(str1.size() > str2.size()){
			cout << ">" << endl;
		}
	}
	return 0;
}
