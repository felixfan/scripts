#include <iostream>

#include "Pen.h"

using namespace std;

void Pen::write_on_paper(string words)
{
    if (InkLevelPercent <= 0)
    {
        cout << "Oops! Out of ink!" << endl;
    }
    else
    {
        cout << words << endl;
        InkLevelPercent = InkLevelPercent - words.length();
    }
}

void Pen::break_in_half()
{
    InkLevelPercent = InkLevelPercent / 2;
    Length = Length / 2.0;
}

void Pen::run_out_of_ink()
{
    InkLevelPercent = 0;
}


Pen::Pen() {
}

Pen::Pen(const Pen& orig) {
}

Pen::~Pen() {
}

