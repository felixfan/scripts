#include <iostream>
#include <iomanip>
using namespace std;

/*
描述
有一个小型的报账系统，它有如下功能：
（1）统计每个人所报发票的总钱数
（2）统计每类发票的总钱数
将此系统简化为如下：假设发票类别共有A、B、C三种;
一共有三个人，ID分别为1、2、3。

输入
系统输入包含三行，每行第一个数为人员ID（整型，1或2或3），
第二个数为发票总张数(张数不超过100)，之后是多个发票类别
（字符型，A或B或C）和相应发票金额（单进度浮点型,不超过1000.0）。

输出
输出包含六行，前三行为每人（按ID由小到大输出）所报发票总钱数
（保留两位小数），后三行为每类发票的总钱数（保留两位小数）。
*/
int main() {
    int n = 3;
    double tot[7] = {0};
    while(n--){
        int id, num;
        cin >> id >> num;
        for(int i=0;i<num;i++){
            char c;
            double m;
            cin >> c >> m;
            tot[id] += m;
            if(c == 'A'){
                tot[4] += m;
            }else if(c == 'B'){
                tot[5] += m;
            }else if(c == 'C'){
                tot[6] += m;
            }
        }
    }
    cout << 1 << " " << setprecision(2) << fixed << tot[1] << endl;
    cout << 2 << " " << setprecision(2) << fixed << tot[2] << endl;
    cout << 3 << " " << setprecision(2) << fixed << tot[3] << endl;
    cout << 'A' << " " << setprecision(2) << fixed << tot[4] << endl;
    cout << 'B' << " " << setprecision(2) << fixed << tot[5] << endl;
    cout << 'C' << " " << setprecision(2) << fixed << tot[6] << endl;
    return 0;
}