#ifndef PEN_H_INCLUDED
#define PEN_H_INCLUDED

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

class Pen
{
public:
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
};

#endif // PEN_H_INCLUDED
