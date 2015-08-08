#include <iostream>
#include <string>
using namespace std;

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
