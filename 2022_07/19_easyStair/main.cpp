/*
 알고리즘 문제 : 백준 10844 - 쉬운 계단 수
 실습 날짜 : 2022-07-19
 문제 : https://www.acmicpc.net/problem/10844
 */

#include <iostream>
#include <string>
#include <cstring>

using namespace std;

int cache[10][101]; // 1: digit, 2: length

int CountStair(int digit, int length)
{
    if (digit < 0 || digit > 9) // 1자리 일 경우
        return 0;
    int &result = cache[digit][length];
    if (result != -1)
        return result;
    
    return result = (CountStair(digit-1, length-1) + CountStair(digit+1, length-1) % 1000000000);
}

int main()
{
    int N;
    int sum=0;
    cin >> N;

    memset(cache, -1, sizeof(cache));
    for (int i = 0; i < 10; i++)
        cache[i][1] = 1;
    for (int i = 1; i < 10; i++)
    {
        sum += CountStair(i, N);
        sum %= 1000000000;
    }
    
    cout << sum << endl;

    return 0;
}