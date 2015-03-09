/* 
To copy a container, you either set one equal to the other or pass the first container
into the constructor of the second (which copies the first into the second).
 */

#include "copyingContainer.h"

#include <iostream>
#include <string>
#include <map>

using namespace std;

copyingContainer::copyingContainer() {
}

copyingContainer::copyingContainer(const copyingContainer& orig) {
}

copyingContainer::~copyingContainer() {
}

class Scrumptious
{
public:
    string Dessert;
};

bool operator < (const Scrumptious &first, const Scrumptious &second)
{
    return first.Dessert < second.Dessert;
}
class Nutrition
{
public:
    int VitaminC;
    int Potassium;
};

void copyingContainer::copyingContainerExample(){
    map<Scrumptious, Nutrition> ItsGoodForMe;
    
    Scrumptious ap = {"Apple Pie"}; // Braces notation!
    Nutrition apn = {7249, 9722};
    
    Scrumptious ic = {"Ice Cream"};
    Nutrition icn = {2459, 19754};
    
    Scrumptious cc = {"Chocolate Cake"};
    Nutrition ccn = {9653, 24905};
    
    Scrumptious ms = {"Milk Shake"};
    Nutrition msn = {46022, 5425};
    
    ItsGoodForMe[ap] = apn;
    ItsGoodForMe[ic] = icn;
    ItsGoodForMe[cc] = ccn;
    ItsGoodForMe[ms] = msn;
    
    // copy: method 1
    map<Scrumptious,Nutrition> Duplicate = ItsGoodForMe;
    
    // copy: method 2
    map<Scrumptious,Nutrition> AnotherDuplicate(ItsGoodForMe);
    
    ItsGoodForMe[ap].Potassium = 20;
    
    cout << "===copying container===" << endl;
    
    cout << ItsGoodForMe[ap].Potassium << endl;
    cout << Duplicate[ap].Potassium << endl;
    cout << AnotherDuplicate[ap].Potassium << endl;
}