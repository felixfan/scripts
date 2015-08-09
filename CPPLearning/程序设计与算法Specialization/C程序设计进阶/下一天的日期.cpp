#include <iostream>
#include <string>
using namespace std;

/*
描述
甲壳虫的《A day in the life》和《Tomorrow never knows》脍炙人口，
如果告诉你a day in the life,真的会是tomorrow never knows?
相信学了计概之后这个不会是难题，现在就来实现吧。

读入一个格式为yyyy-mm-dd的日期（即年－月－日），输出这个日期下一天的日期。
可以假定输入的日期不早于1600-01-01，也不晚于2999-12-30。

输入
输入仅一行，格式为yyyy-mm-dd的日期。

输出
输出也仅一行，格式为yyyy-mm-dd的日期
*/
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
	string str;
	getline(cin, str);
	int year, month, day;
	year = stoi(str.substr(0, 4));
	if(str[5]==0){
		month = stoi(str.substr(6,1));
	}else{
		month = stoi(str.substr(5,2));
	}
	if(str[8]==0){
		day = stoi(str.substr(9,1));
	}else{
		day = stoi(str.substr(8,2));
	}
	
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
