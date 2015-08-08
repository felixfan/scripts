#include <iostream>
#include <string>
using namespace std;

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
