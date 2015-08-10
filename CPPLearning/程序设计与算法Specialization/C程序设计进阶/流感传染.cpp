#include <iostream>
using namespace std;

/*
有一批易感人群住在网格状的宿舍区内，宿舍区为n*n的矩阵，每个格点为一个房间，房间里可能住人，也可能空着。
在第一天，有些房间里的人得了流感，以后每天，得流感的人会使其邻居传染上流感，（已经得病的不变），空房间不会传染。
请输出第m天得流感的人数。

输入
第一行一个数字n，n不超过100，表示有n*n的宿舍房间。
接下来的n行，每行n个字符，’.’表示第一天该房间住着健康的人，’#’表示该房间空着，’@’表示第一天该房间住着得流感的人。
接下来的一行是一个整数m，m不超过100.

输出
输出第m天，得流感的人数
*/
void update(int health[][100], bool status[][100], int n){
	for(int i=0; i<n; i++){
		for(int j=0; j <n; j++){
			if(status[i][j] == true && health[i][j]==2){
				if(i-1 >=0 && health[i-1][j]==1){
					status[i-1][j]=true;
				}
				if(i+1 <=n && health[i+1][j]==1){
					status[i+1][j]=true;
				}
				if(j-1 >=0 && health[i][j-1]==1){
					status[i][j-1]=true;
				}
				if(j+1 <=n && health[i][j+1]==1){
					status[i][j+1]=true;
				}
			}
		}
	}
	
	for(int i=0; i<n; i++){
		for(int j=0; j <n; j++){
			if(status[i][j] == true){
				health[i][j] = 2;
			}
		}
	}
}


int main() {
	int health[100][100];
	bool status[100][100];
	int n;
	char c[100];
	cin >> n;
	
	for(int i=0; i<n; i++){
		cin >> c;
		for(int j=0; j<n;j++){
			if(c[j] == '.'){
				health[i][j] = 1; // health
				status[i][j] = false;
			}else if(c[j] == '#'){
				health[i][j] = 0; // no
				status[i][j] = false;
			}else if(c[j] == '@'){
				health[i][j] = 2; // disease
				status[i][j] = true;
			}
		}
	}
	
	int m;
	cin >> m;
	for(int i=0; i<m-1; i++){
		update(health,status,n);
	}
	
	int p = 0;
	
	for(int i=0; i<n; i++){
		for(int j=0; j <n; j++){
			if(health[i][j] == 2){
				p++;
			}
		}
	}
	
	cout << p << endl;
	
	return 0;
}
