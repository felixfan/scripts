#include <iostream>
#include <limits> 
#include <cmath>
using namespace std;

int main() {
	int n;
	cin >> n;
	while(n--){
		double s;
		cin >> s;
		double wt = s / 1.2;
		double bt = s/ 3.0 + 50;
		if(abs(wt - bt) < 0.0001){// compare two double
			cout << "All" << endl;
		}else if(wt < bt){
			cout << "Walk" << endl;
		}else if(wt > bt){
			cout << "Bike" << endl;
		}
	}
	return 0;
}
