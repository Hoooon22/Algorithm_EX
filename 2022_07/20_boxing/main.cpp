/*
 알고리즘 문제 : 백준 1965 - 상자넣기
 실습 날짜 : 2022-07-20
 문제 : https://www.acmicpc.net/problem/1965
 */

#include <cstdio>
#include <algorithm>
using namespace std;

int main() {

    int N;
    int result = 0;
    scanf("%d", &N);

    int arr[N];
    int dp[N];

    for (int i = 0; i < N; i++) 
    {
        scanf("%d", &arr[i]);
        dp[i] = 0;
    }

    dp[0] = 1;
    for (int i = 1; i < N; i++) 
    {
        for (int j = 0; j < i; j++) 
        {
            if (arr[i] > arr[j]) // 이전 dp 값 중 더 큰 쪽 선택
                dp[i] = max(dp[i], dp[j]);
        }
        dp[i]++; // i번째 상자 담기
        result = max(result, dp[i]);
    }

    printf("%d\n", result);

    return 0;
}