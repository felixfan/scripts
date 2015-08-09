#include <iostream>
using namespace std;

void move(int n, char x, char y, char z){
	if(n == 1){
		cout << "move one plate from " << x << " to " << z << endl; 
	}else{
		move(n-1, x, z, y);
		cout << "move one plate from " << x << " to " << z << endl;
		move(n-1, y, x, z);
	}
}
int main() {
	int n;
	cin >> n;
	move(n, 'A', 'B', 'C');
	return 0;
}