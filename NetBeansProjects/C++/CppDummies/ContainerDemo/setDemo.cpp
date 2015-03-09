/* 
 * Associating and storing with a set
 * In the Standard Library, set has an order to it. However, like a math set, 
 * set does not allow duplicates. If you try to put an item in set that’s 
 * already there, set will ignore your attempt to do so.
 * 
 * we included an Employee class, along with a less-than function. The less-than
 * function compares the SocialSecurityNumber member of two Employee instances.
 *  
 * This results in two things:
 * 
 * Ordering: The items in set will be ordered according to social security number. 
 * This is not true with all containers, but it is the way a set works.
 * 
 * Duplicates: If we try to add two employees with matching SocialSecurityNumber 
 * members (but the other members can be different), the second addition won’t take. 
 * The set will ignore it.
 * 
 * Finding an item in set is interesting. Look at how we did it: We created an 
 * instance of Employee, and we filled in only the SocialSecurityNumber member, 
 * because that’s the only member that the less-than function looks at. Then we called find.
 * the find function returns an iterator. because the iterator type is really a 
 * typedef for a pointer to an item inside set.
 */

#include <set>
#include <string>
#include <iostream>
#include <algorithm>

#include "setDemo.h"
#include "mapDemo.h"

using namespace std;

setDemo::setDemo() {
}

setDemo::setDemo(const setDemo& orig) {
}

setDemo::~setDemo() {
}

// defined in mapDemo.cpp
bool operator < (const EmployeeMap &first, const EmployeeMap &second);

/*
 * We created a function that lets us use our EmployeeMap instance with cout. 
 * We did this by overloading the insertion function. The first parameter represents cout, 
 * and the second is the item we’re couting.
 */
ostream &operator << (ostream &out, const EmployeeMap &emp)
{
    cout << "(" << emp.Nickname;
    cout << "," << emp.SocialSecurityNumber;
    cout << ")";
    return out;
}

void PrintSet(set<string> *myset)
{
    set<string>::iterator iter = myset->begin();
    while (iter != myset->end())
    {
        cout << *iter << endl;
        iter++;
    }
}

void setDemo::setExample(){
    set<EmployeeMap> employees;
    
    EmployeeMap emp1("sparky", "123-22-8572");
    employees.insert(emp1);
    EmployeeMap emp2("buzz", "234-33-5784");
    employees.insert(emp2);
    // emp3 and emp1 has same SocialSecurityNumber, set ignored the emp3
    EmployeeMap emp3("coollie", "123-22-8572"); 
    employees.insert(emp3);
    EmployeeMap emp4("sputz", "199-19-0000");
    employees.insert(emp4);
    
    // List the items
    set<EmployeeMap>::iterator iter = employees.begin();
    while (iter != employees.end())
    {
        cout << *iter << endl;
        iter++;
    }
    
    // Find an item
    cout << "Finding..." << endl;
    EmployeeMap findemp("", "123-22-8572");
    iter = employees.find(findemp);
    cout << *iter << endl;
    
/*how you can combine two sets to get the union, or you can find the common 
 * elements to get the intersection.
 */
    
    set<string> EnglishClass;
    set<string> HistoryClass;
    
    EnglishClass.insert("Zeus");
    EnglishClass.insert("Magellan");
    EnglishClass.insert("Vulcan");
    EnglishClass.insert("Ulysses");
    EnglishClass.insert("Columbus");
    
    cout << "===EnglishClass===" << endl;
    PrintSet(&EnglishClass);
    
    HistoryClass.insert("Vulcan");
    HistoryClass.insert("Ulysses");
    HistoryClass.insert("Ra");
    HistoryClass.insert("Odin");
    
    cout << "===HistoryClass===" << endl;
    PrintSet(&HistoryClass);
    
    set<string> Union;
    set<string> Intersection;
    
    /*To use the set_intersection and set_union functions, you need to
     * #include <algorithm>. This is one of the header files in the Standard C++ Library.
     */
    
    set_intersection(EnglishClass.begin(), EnglishClass.end(), 
            HistoryClass.begin(), HistoryClass.end(),
            inserter(Intersection, Intersection.begin()));
    
    cout << "===Intersection===" << endl;
    PrintSet(&Intersection);
    
    set_union(EnglishClass.begin(),EnglishClass.end(),
            HistoryClass.begin(), HistoryClass.end(),
            inserter(Union, Union.begin()));
    
    cout << endl << "===Union===" << endl;
    PrintSet(&Union);
}

