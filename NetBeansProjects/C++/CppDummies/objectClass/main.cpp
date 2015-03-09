/* 
 * File:   main.cpp
 * Author: alice
 *
 * Created on June 1, 2014, 11:21 PM
 */

#include <cstdlib>

#include <iostream>

#include "Pen.h"
#include "Oven.h"

using namespace std;

//C++ All-In-One for Dummies, 2nd Edition
//Book I: Introducing C++
//Chapter 7: Working with Classes


void Inspect(const Pen *Checkitout)
{
    cout << Checkitout->Brand << endl;
}

int main()
{
    Pen FavoritePen;

    FavoritePen.InkColor = blue;
    FavoritePen.ShellColor = clear;
    FavoritePen.CapColor = black;
    FavoritePen.Style = ballpoint;
    FavoritePen.Length = 6.0;
    FavoritePen.Brand = "Pilot";
    FavoritePen.InkLevelPercent = 90;

    Pen WorstPen;

    WorstPen.InkColor = blue;
    WorstPen.ShellColor = red;
    WorstPen.CapColor = black;
    WorstPen.Style = felt_tip;
    WorstPen.Length = 3.5;
    WorstPen.Brand = "Acme Special";
    WorstPen.InkLevelPercent = 100;

    cout << "This is my favorite pen" << endl;
    cout << "Color: " << FavoritePen.InkColor << endl;
    cout << "Brand: " << FavoritePen.Brand << endl;
    cout << "Ink Level: " << FavoritePen.InkLevelPercent << "%" << endl;
    FavoritePen.write_on_paper("Hello I am a pen");
    cout << "Ink Level: " << FavoritePen.InkLevelPercent << "%" << endl;

    //Using the Public and Private Words to Hide Parts of Your Class
    cout << "==========================" << endl;
    Oven fred;
    fred.Bake(875);

    //Managing an Object¡¯s Life
    cout << "==========================" << endl;
    Pen *MyPen; //Declares the pointer
    MyPen = new Pen; //Calls new to create the object // or just, Pen *MyPen = new Pen();

    MyPen->InkColor = red; //Accesses the members of the object through the pointer
    cout << MyPen->InkColor << endl;

    delete MyPen; //Deletes the object
    MyPen = 0;  //Clears the pointer //remember to set it to 0

    //If you insert const before the type in the parameter list, the compiler does not let the function code modify the object.
    //MyPen->Brand = "Spy Plus Camera";
    //Inspect(MyPen);

    return 0;
}
