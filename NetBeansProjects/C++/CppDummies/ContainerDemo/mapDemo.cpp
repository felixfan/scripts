/*
 * map works much like vector, except for one main difference: Whereas you 
 * look up items in vector by putting a number inside brackets as in 
 * this names[0],with map, you can use any class or type you want for the index, 
 * not just numbers. This feature lets you associate objects. 
 * 
 * First, you can see that to use map, we declare a variable of class map, 
 * supplying to the template the types of first the keys and then the values
 * 
 * Then we store something in map by putting a key inside brackets and 
 * setting it equal to a value
 * 
 * And to retrieve that particular item, we grab it based on the key.
 */

#include <iostream>
#include <map>
#include <string>

#include "mapDemo.h"

using namespace std;

mapDemo::mapDemo() {
}

mapDemo::mapDemo(const mapDemo& orig) {
}

mapDemo::~mapDemo() {
}

/*the map code uses our less-than function that we provided. 
 * And in that function, we compared only the SocialSecurityNumber members, 
 * not the Nickname member. 
 */

// this part is necessary!!!!!
bool operator < (const EmployeeMap &first, const EmployeeMap &second){
    return first.SocialSecurityNumber < second.SocialSecurityNumber;
}

void mapDemo::mapExample(){
    cout << "===map demo ===" << endl;
    
    map<string, string> marriages;
    marriages["Tom"] = "Susan";
    marriages["Harry"] = "Harriet";
    cout << marriages["Tom"] << endl;
    cout << marriages["Harry"] << endl;
    
    //
    map<EmployeeMap, Salary> employees;
    EmployeeMap emp1("sparky", "123-22-8572");
    Salary sal1(135000, 18);
    employees[emp1] = sal1;
    
    EmployeeMap emp2("buzz", "234-33-5784");
    Salary sal2(150000, 23);
    employees[emp2] = sal2;
    
    EmployeeMap emptest("", "234-33-5784");
    cout << employees[emptest].AnnualRipoff << endl;
    
    cout << employees[emp1].AnnualRipoff << endl;
    cout << employees[emp2].IRSDeductionsCheat << endl;
}