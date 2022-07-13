/*
 알고리즘 문제 : 백준 15649 - N과 M (5)
 실습 날짜 : 2022-07-13
 문제 : https://www.acmicpc.net/problem/15651
 */

#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
#include <sstream>

using namespace std;

void backTracking(int N, int M, int *arr, vector<int> v, int count)
{
    if (count == M)
    {
        // Check duplication
        for (int i = 0; i < M; i++)
        {
            for (int j = i+1; j < M; j++)
            {
                if (arr[i] == arr[j])
                    return;
            }
        }
        
        // print
        for(int i = 0; i < M; i++)
            cout << arr[i] << ' ';
        cout << '\n';
        return;
    }
    
    for (int i = 0; i < N; i++)
    {
        arr[count] = v.at(i);
        backTracking(N, M, arr, v, count+1);
    }
}

int main(void)
{
    int N, M;
    string str;
    vector<int> v;
    int *arr = new int[M];

    // 1. input N, M, v
    cin >> N >> M;
    cin.ignore();
    getline(cin, str);

    stringstream ss(str);
    string token;

    while (getline(ss, token, ' '))
    {
        if (token != "")
            v.push_back(stoi(token));
    }
    sort(v.begin(), v.end());

    // 2. backtracking
    backTracking(N, M, arr, v, 0);

    return 0;
}