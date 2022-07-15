/*
 알고리즘 문제 : 백준 15649 - N과 M (11)
 실습 날짜 : 2022-07-13
 문제 : https://www.acmicpc.net/problem/15665
 */

#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
#include <sstream>

using namespace std;

void backTracking(int N, int M, int *arr, vector<int> v, vector<vector<int>> result, int result_count, int count)
{
    if (count == M)
    {
        // insert to result
        for(int i = 0; i < M; i++)
            result[result_count].push_back(arr[i]);
        result_count++;
        return;
    }
    
    for (int i = 0; i < N; i++)
    {
        arr[count] = v.at(i);
        backTracking(N, M, arr, v, result, result_count, count+1);
    }
}

int main(void)
{
    int N, M;
    string str;
    vector<int> v;
    vector<vector<int>> result;
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
    backTracking(N, M, arr, v, result, 0, 0);

    // 3. print
    for (int i = 0; i < result.size(); i++)
    {
        for (int j = 0; j < M; j++)
        {
            cout << result.at(i).at(j);
        }
        cout << endl;
    }
    

    return 0;
}