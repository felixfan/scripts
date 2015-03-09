/* 
 * File:   vectorDemo.h
 * Author: alice
 *
 * Created on June 2, 2014, 3:30 PM
 */

#ifndef VECTORDEMO_H
#define	VECTORDEMO_H

using namespace std;

class vectorDemo {
public:
    vectorDemo();
    vectorDemo(const vectorDemo& orig);
    virtual ~vectorDemo();
    void vectorExample();
private:

};

class Employee
{
public:
    string Name;
    string FireDate;
    int GoofoffDays;
    Employee(string aname, string afiredate, int agoofdays){
         Name=aname;
         FireDate=afiredate;
         GoofoffDays=agoofdays;
    }
};

#endif	/* VECTORDEMO_H */

