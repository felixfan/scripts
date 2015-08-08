#include <iostream>
using namespace std;

int main() {
	double n, k;
	while(cin >> n >> k){
		bool flag = false;
		double price = 200;
		double salary = n;
		for(int i=1; i<21;i++){
			if(salary > price){
				cout << i << endl;
				flag = true;
				break;
			}
			salary += n;
			price += (price * k / 100);
		}
		if(flag==false){
			cout << "Impossible" << endl;
		}
	}
	return 0;
}
