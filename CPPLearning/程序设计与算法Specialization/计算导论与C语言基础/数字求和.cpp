#include <iostream>
using namespace std;

int main() {
    int a, b, n=5;
    cin >> a;
    int sum = 0;
    
    while(n--){
        cin >> b;
        if(b < a){
            sum += b;
        }
    }
    
    cout << sum << endl;
    return 0;
}