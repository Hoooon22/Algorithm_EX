#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

void backTracking(int N, int M, int *arr, int count)
{
    if(count == M)
    {
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