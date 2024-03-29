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
	int n, m;
	cin >> n >> m;

	char** chess = new char*[n];
	for (int i = 0; i < n; i++) 
		chess[i] = new char[m];

	for (int i = 0; i < n; i++)
		for (int j = 0; j < m; j++)
			cin >> chess[i][j];

	int min = n * m;

	int cnt = 0;
	for (int x = 0; x + 7 < n; x++) 
    {
		for (int y = 0; y + 7 < m; y++) 
        {
			cnt = 0;
			for (int i = x; i < x+8; i++) 
            {
				for (int j = y; j < y+8; j++) 
                {
					if ((i + j) % 2 == 0) 
                    {
						if (chess[i][j] != 'B')
							cnt++;
					}
					else 
                    {
						if (chess[i][j] != 'W') 
							cnt++;
					}
					if (cnt > min) break;
				}
			}
			if (cnt < min) min = cnt;
		}
	}

	for (int x = 0; x + 7 < n; x++) 
    {
		for (int y = 0; y + 7 < m; y++) 
        {
			cnt = 0;
			for (int i = x; i < x+8; i++) 
            {
				for (int j = y; j < y+8; j++) 
                {
					if ((i + j) % 2 == 0) 
                    {
						if (chess[i][j] != 'W') 
							cnt++;
					}
					else 
                    {
						if (chess[i][j] != 'B')
							cnt++;
					}
					if (cnt > min) break;
				}
			}
			if (cnt < min) min = cnt;
		}
	}

	cout << min;

	return 0;
}