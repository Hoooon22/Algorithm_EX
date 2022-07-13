/*
 알고리즘 문제 : 백준 15649 - N과 M (1)
 실습 날짜 : 2022-07-13
 문제 : https://www.acmicpc.net/problem/15649
 */

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

void backTracking(int N, int M, int *arr, int count)
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
        for (int i = 0; i < M; i++)
            cout << arr[i] << ' ';
        cout << '\n';
        return;
    }
    
    for (int i = 1; i <= N; i++)
    {
        arr[count] = i;
        backTracking(N, M, arr, count+1);
    }
}

int main(void)
{
    int N, M;
    // 1. input N, M
    cin >> N >> M;

    int *arr = new int[M];
    // 2. backtracking
    backTracking(N, M, arr, 0);

    return 0;
}