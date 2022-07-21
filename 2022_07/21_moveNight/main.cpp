/*
 알고리즘 문제 : 백준 7562 - 나이트의 이동
 실습 날짜 : 2022-07-22
 문제 : https://www.acmicpc.net/problem/7562
 */

#include<iostream>
#include<cstring>
#include<queue>

using namespace std;

int l;
bool Visit[300][300]; 
int dx[] = { -1, -2, -2, -1, 1, 2, 2, 1 };
int dy[] = { -2, -1, 1, 2, 2, 1, -1, -2 }; 

pair<int, int> Start, End; 
void Initialize()
{    
    memset(Visit, false, sizeof(Visit));
} 

void Input()
{    
    cin >> l;    
    cin >> Start.first >> Start.second;    
    cin >> End.first >> End.second;
} 

void BFS(int a, int b)
{   
    queue<pair<pair<int, int>, int >> Q;    
    Q.push(make_pair(make_pair(a, b), 0));    
    Visit[a][b] = true;
        
    while (Q.empty() == 0)    
    {        
        int x = Q.front().first.first;        
        int y = Q.front().first.second;        
        int Cnt = Q.front().second;        
        Q.pop();         
        if (x == End.first && y == End.second)        
        {            
            cout << Cnt << endl;            
            return;        
        }         

        for (int i = 0; i < 8; i++)        
        {            
            int nx = x + dx[i];           
            int ny = y + dy[i];   

            if (nx >= 0 && ny >= 0 && nx < l && ny < l)            
            {                
                if (Visit[nx][ny] == false)                
                {                    
                    Visit[nx][ny] = true;                    
                    Q.push(make_pair(make_pair(nx, ny), Cnt + 1));                
                }            
            }        
        }    
    }
}

void Solution()
{   
    BFS(Start.first, Start.second);
}

int main(void)
{
    int tc;    
    cin >> tc;    

    for (int t = 1; t <= tc; t++)    
    {        
        Initialize();        
        Input();        
        Solution();   
    }   

    return 0;
}