/* 
 * File:   main.cpp
 * Author: alice
 *
 * Created on May 30, 2014, 6:09 PM
 */

#include <cstdlib>

#include <iostream>

using namespace std;

class EthicalCompetition
{
private:
    class Connection;
public:
    void HardWork();
};

class EthicalCompetition::Connection // Only the outer class can access most of its members.
{
protected:
    friend class EthicalCompetition;
    void Connect();
        /*
        Even if the constructor and destructor don¡¯t do anything,
        by making them private or protected you prevent others from creating an
        instance of the class, except any friends to the class.
        */
    Connection() {}
    ~Connection() {}
};

void EthicalCompetition::HardWork()
{
    Connection c;
    c.Connect();
    cout << "Connected" << endl;
}

void EthicalCompetition::Connection::Connect()
{
cout << "Connecting..." << endl;
}

int main(int argc, char *argv[])
{
    EthicalCompetition comp;
    comp.HardWork();
    return 0;
}
