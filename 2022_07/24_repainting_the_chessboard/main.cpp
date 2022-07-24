/*
 알고리즘 문제 : 백준 1018 - 체스판 다시 칠하기
 실습 날짜 : 2022-07-24
 문제 : https://www.acmicpc.net/problem/1018
 */

#include <iostream>
#include <string>

using namespace std;

int main(void)
{
    int M, N;
    char board[M][N];
    string str;

    // input
    cin >> M >> N;
    cin.ignore();
    for (int i = 0; i < M; i++)
    {
        getline(cin,str);
        strcpy(board[i], str.c_str());
    }
    

    return 0;
}