#include <iostream>
#include <iomanip>
using namespace std;

/*
����
��һ��С�͵ı���ϵͳ���������¹��ܣ�
��1��ͳ��ÿ����������Ʊ����Ǯ��
��2��ͳ��ÿ�෢Ʊ����Ǯ��
����ϵͳ��Ϊ���£����跢Ʊ�����A��B��C����;
һ���������ˣ�ID�ֱ�Ϊ1��2��3��

����
ϵͳ����������У�ÿ�е�һ����Ϊ��ԱID�����ͣ�1��2��3����
�ڶ�����Ϊ��Ʊ������(����������100)��֮���Ƕ����Ʊ���
���ַ��ͣ�A��B��C������Ӧ��Ʊ�������ȸ�����,������1000.0����

���
����������У�ǰ����Ϊÿ�ˣ���ID��С���������������Ʊ��Ǯ��
��������λС������������Ϊÿ�෢Ʊ����Ǯ����������λС������
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