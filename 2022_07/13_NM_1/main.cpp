/*
 알고리즘 문제 : 프로그래머스 코딩테스트 연습 - 타겟 넘버
 실습 날짜 : 2021-10-25
 문제 : https://programmers.co.kr/learn/courses/30/lessons/43165?language=csharp
 */

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

void backTracking(int N, int M, int *arr, int count)
{
    if(count == M)
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
    
    for(int i = 1; i <= N; i++)
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