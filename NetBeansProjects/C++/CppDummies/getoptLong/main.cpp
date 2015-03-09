/* 
 * File:   main.cpp
 * Author: alice
 *
 * Created on May 20, 2014, 9:49 PM
 */

#include <cstdlib>

#include <getopt.h>
#include <stdio.h>
#include <string>
#include <sstream>
#include <iostream>
using namespace std;

string VERSION;
string DATE;

/*
getopt_long() 的选项
struct option {
    char *name;
    int has_arg;
    int *flag;
    int val;
};
name 成员是指向长选项名称（带两个短横线）的指针。
has_arg 成员设置为 no_argument、optional_argument, 或 required_argument（均在 getopt.h 中定义）之一，以指示选项是否具有参数。
如果 flag 成员未设置为 NULL，在处理期间遇到此选项时，会使用 val 成员的值填充它所指向的 int 值。
如果 flag 成员为 NULL，在 getopt_long() 遇到此选项时，将返回 val 中的值；
通过将 val 设置为选项的 short 参数，可以在不添加任何其他代码的情况下使用 getopt_long()——处理 while loop 和 switch 的现有 getopt() 将自动处理此选项。
*/

void usage(){
    printf("usage:\n \
           getoptLong -n name -p place -a age\n \
              -n [--n,--name]:           name \n \
              -p [--p,--place]:          place \n \
              -a [--a,--age]:            age \n \
              -h [--h,--help]:           help\n \
              -v [--v,--version]:        version\n");
}

bool anydigit(string str){
    for(unsigned int i=0; i<str.size();i++){
        if(!isdigit(str[i])){
            return false;
        }
    }
    return true;
}

int main(int argc, char * argv[]){
    VERSION="1.0";
    DATE="May 2014";
    printf("\n"
	     "@-------------------------------------------------------------@\n"
	     "|       getoptLong       |      v 1.0      |    May 2014      |\n"
	     "|-------------------------------------------------------------|\n"
	     "|  (C) 2014 Felix Yanhui Fan, GNU General Public License, v2  |\n"
	     "|-------------------------------------------------------------|\n"
	     "|    For documentation, citation & bug-report instructions:   |\n"
             "|        http://felixfan.github.io                            |\n"
             "@-------------------------------------------------------------@\n"
	     "\n");

    
    const struct option long_options[] ={
        {"version",   no_argument,        0, 'v'},
        {"help",      no_argument,        0, 'h'},
        {"name",      required_argument,  0, 'n'},
        {"place",     required_argument,  0, 'p'},
        {"age",       required_argument,  0, 'a'},
        {0,0,0,0}
        };
    //turn off getopt error message
    opterr=0;

    string name, place, age;
    int fn=0;
    int fp=0;
    int fa=0;

    int opts;
    while((opts=getopt_long(argc, argv, ":vhn:p:a:", long_options, NULL))!=-1){
        switch(opts){
        case 'v':
            cout << "version " << VERSION << endl;
            return -1;
        case 'h':
            usage();
            return -1;
        case 'n':
            name = optarg;
            fn=1;
            if(name.find_first_of('-') ==0){
                    cout << "argument is missing: -n" << endl;
                    usage();
                    return -1;
            }
            break;
        case 'p':
            place=optarg;
            fp=1;
            if(place.find_first_of('-') ==0){
                    cout << "argument is missing: -p" << endl;
                    usage();
                    return -1;
            }
            break;
        case 'a':
            age = optarg;
            fa=1;
            if(age.find_first_of('-') ==0){
                cout << "argument is missing: -a" << endl;
                usage();
                return -1;
            }else if (!anydigit(age)){
                cout << "argument of -a should be numeric" << endl;
                return -1;
            }
            break;
        case '?':
            cout << "unknown option: " << argv[--optind] << endl;
            usage();
            return -1;
        case ':':
            cout << "The option takes an argument which is missing" << endl;
            usage();
            return -1;
        }
    }

    if(fn==0){
            cout << "option -n is missing" << endl;
            usage();
            return -1;
    }

    if(fp==0){
            cout << "option -p is missing" << endl;
            usage();
            return -1;
    }

    if(fa==0){
            cout << "option -a is missing" << endl;
            usage();
            return -1;
    }

    int myage;
    istringstream converter(age);
    converter >> myage;

    cout << "Hello " << name << endl;
    cout << "You are from " << place << endl;
    cout << "You are " << age << " years old!" <<endl;

    if(myage < 35){
        cout << "You are quite young!" << endl;
    }else{
        cout << "Do not worry, you are not too old!" << endl;
    }

    return 0;
}

