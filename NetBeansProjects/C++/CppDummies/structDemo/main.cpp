/* 
 * File:   main.cpp
 * Author: alice
 *
 * Created on May 22, 2014, 11:05 PM
 */

#include <cstdlib>

#include <iostream>

using namespace std;

struct Date{
	int month;
	int day;
	int year;
};

struct Student{
	int num;
	char name[20];
	char sex;
	Date birthday;
	float score;
};

struct Name{
	int num;
	float score;
	Name *next;
};

Student student1;
Student student2 = {10002, "Wang Li", 'f', 5, 23, 1982, 89.5};

int main(){
	student1 = student2;
	cout << student1.num << endl;
	cout << student1.name << endl;
	cout << student1.sex << endl;
	cout << student1.birthday.month << '/' << student1.birthday.day << '/' << student1.birthday.year << endl;
	cout << student1.score << endl;
	cout << endl;

	// structure array
	Student stu[3] = { { 10101, "Li Lin", 'M', 2, 24, 1983, 87.5 }, 
	{ 10102, "Zhang Wang", 'F', 3, 25, 1984, 90 }, 
	{10103,"Zhang Yun",'M',4,26,1983,99} 
	};
	
	for (int i = 0; i < 3; i++){
		cout << "Score of individual " << i << ": " << stu[i].score << endl;
	}
	cout << endl;

	// pointer
	Student *pstu = &student1;
	cout << "student1.name:\t" << student1.name << endl;
	cout << "pstu->name:\t" << pstu->name << endl;
	cout << "(*pstu).name:\t" << (*pstu).name << endl;
	cout << endl;

	//
	Name a, b, c, *head, *p;
	a.num = 1001;
	b.num = 1002;
	c.num = 1003;
	a.score = 90;
	b.score = 95;
	c.score = 89;

	head = &a;
	a.next = &b;
	b.next = &c;
	c.next = NULL;

	p = head;
	do{
		cout << p->num << "\t" << p->score << endl;
		p = p->next;
	} while (p != NULL);
	cout << endl;


	return 0;
}


