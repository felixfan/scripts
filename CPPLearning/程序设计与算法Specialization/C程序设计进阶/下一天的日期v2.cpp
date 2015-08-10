#include <iostream>

using namespace std;


bool leapYear(int n){
	if(n % 4 == 0 && n % 100 != 0 || n % 400 == 0 ){
		return true;
	}else{
		return false;
	}
}

bool bigMonth(int n){
	if(n==1 || n==3 || n==5 || n==7 || n==8 || n==10 || n==12){
		return true;
	}else{
		return false;
	}
}

int getDay(int day, int month, bool isLeapYear){
	bool isBigMonth = bigMonth(month);
	if(isBigMonth){
		if(day < 31){
			return (day + 1);
		}else{
			return 1;
		}
	}else if(month == 2){
		if(isLeapYear){
			if(day < 29){
				return (day + 1);
			}else{
				return 1;
			}
		}else{
			if(day < 28){
				return (day + 1);
			}else{
				return 1;
			}
		}
	}else{
		if(day < 30){
			return (day + 1);
		}else{
			return 1;
		}
	}
}

int main() {
	int year, month, day;
	char c[10];
	cin >> c;
	
	year = (c[0]-'0') * 1000 + (c[1] - '0')*100 + (c[2] - '0')*10 + (c[3] - '0');
	month =  (c[5] - '0') * 10 + (c[6] - '0');
	day = (c[8] - '0') * 10 + (c[9] - '0');
	
	bool isLeapYear = leapYear(year);
	int newDay = getDay(day,month, isLeapYear);
	
	int newMonth = month;
	int newYear = year;
	
	bool isAddYear = false;
	if(newDay == 1){
		if(month < 12){
			newMonth = month + 1;
		}else{
			newMonth = 1;
			isAddYear = true;
		}
	}
	
	if(isAddYear){
		newYear = year + 1;
	}
	
	cout << newYear << "-";
	if(newMonth < 10){
		cout << "0";
	}
	cout << newMonth << "-";
	if(newDay <10){
		cout << "0";
	}
	cout << newDay << endl;
	return 0;
}
