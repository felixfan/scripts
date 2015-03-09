/* 
 * File:   mapDemo.h
 * Author: alice
 *
 * Created on June 2, 2014, 3:59 PM
 */

#ifndef MAPDEMO_H
#define	MAPDEMO_H

#include <iostream>
#include <string>

using namespace std;

class mapDemo {
public:
    mapDemo();
    mapDemo(const mapDemo& orig);
    virtual ~mapDemo();
    void mapExample();
private:

};

class EmployeeMap
{
public:
    string Nickname;
    string SocialSecurityNumber;
    
    EmployeeMap(string anickname, string asocial){
        Nickname=anickname;
        SocialSecurityNumber=asocial;
    }
  
    EmployeeMap(){
         Nickname="";
         SocialSecurityNumber="";
    }
};

class Salary
{
public:
    int AnnualRipoff;
    int IRSDeductionsCheat;
    Salary(int aannual, int adeductions){
        AnnualRipoff=aannual;
        IRSDeductionsCheat=adeductions;
    }

    Salary(){
        AnnualRipoff=0;
        IRSDeductionsCheat=0;
    }
};



#endif	/* MAPDEMO_H */

