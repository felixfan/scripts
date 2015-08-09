#include <iostream>
#include <string>
using namespace std;

/*
����
�׿ǳ�ġ�A day in the life���͡�Tomorrow never knows�������˿ڣ�
���������a day in the life,��Ļ���tomorrow never knows?
����ѧ�˼Ƹ�֮��������������⣬���ھ���ʵ�ְɡ�

����һ����ʽΪyyyy-mm-dd�����ڣ����꣭�£��գ���������������һ������ڡ�
���Լٶ���������ڲ�����1600-01-01��Ҳ������2999-12-30��

����
�����һ�У���ʽΪyyyy-mm-dd�����ڡ�

���
���Ҳ��һ�У���ʽΪyyyy-mm-dd������
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
