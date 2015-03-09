/* 
 * File:   Pen.h
 * Author: alice
 *
 * Created on June 1, 2014, 11:24 PM
 */

#ifndef PEN_H
#define	PEN_H

using namespace std;

enum Color
{
    blue,
    red,
    black,
    clear
};

enum PenStyle
{
    ballpoint,
    felt_tip,
    fountain_pen
};

class Pen {
public:
    Pen();
    Pen(const Pen& orig);
    virtual ~Pen();
    Color InkColor;
    Color ShellColor;
    Color CapColor;
    PenStyle Style;
    float Length;
    string Brand;
    int InkLevelPercent;
    
    void write_on_paper(string words);
    void break_in_half();
    void run_out_of_ink();
private:

};

#endif	/* PEN_H */

