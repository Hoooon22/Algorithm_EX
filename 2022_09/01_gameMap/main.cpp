/*
 알고리즘 문제 : 프로그래머스 - 게임 맵 최단거리
 실습 날짜 : 2022-09-01
 문제 : https://school.programmers.co.kr/learn/courses/30/lessons/1844
 */

#include <iostream>
#include <queue>
#include <algorithm>
#include <vector>

using namespace std;

int bfs(vector<vector<int> > maps, bool visited[][100])
{
    queue<pair<int, int>> q;
    q.push(make_pair(0,0));
    int dist[100][100];
    
    dist[0][0] = 1;

    // until queue is empty
    while (!q.empty())
    {
        pair<int,int> x = make_pair(q.front().first, q.front().second);
        q.pop();

        // add no visited element in 4 way
        // up
        if (x.first - 1 >= 0)
        {
            if (maps[x.first-1][x.second] == 1 && !visited[x.first-1][x.second])
            {
                q.push(make_pair(x.first-1, x.second));
                visited[x.first-1][x.second] = true;
                dist[x.first-1][x.second] = dist[x.first][x.second] + 1;
            }
        }
        // down
        if (x.first + 1 < maps.size())
        {
            if (maps[x.first+1][x.second] == 1 && !visited[x.first+1][x.second])
            {
                q.push(make_pair(x.first+1, x.second));
                visited[x.first+1][x.second] = true;
                dist[x.first+1][x.second] = dist[x.first][x.second] + 1;
            }
        }
        // left
        if (x.second - 1 >= 0)
        {
            if (maps[x.first][x.second-1] == 1 && !visited[x.first][x.second-1])
            {
                q.push(make_pair(x.first, x.second-1));
                visited[x.first][x.second-1] = true;
                dist[x.first][x.second-1] = dist[x.first][x.second] + 1;
            }
        }
        // right
        if (x.second + 1 < maps[0].size())
        {
            if (maps[x.first][x.second+1] == 1 && !visited[x.first][x.second+1])
            {
                q.push(make_pair(x.first, x.second+1));
                visited[x.first][x.second+1] = true;
                dist[x.first][x.second+1] = dist[x.first][x.second] + 1;
            }   
        }
    }

    if (dist[maps.size()-1][maps[0].size()-1] == 0)
        dist[maps.size()-1][maps[0].size()-1] = -1;

    return dist[maps.size()-1][maps[0].size()-1];
}

int solution(vector<vector<int> > maps)
{
    int answer = 0;
    bool visited[100][100]; // max size : 100x100
    for (int i = 0; i < 100; i++)
    {
        for (int j = 0; j < 100; j++)
        {
            visited[i][j]= false;
        }
    }
    
    visited[0][0] = true; // first node

    answer = bfs(maps, visited);

    return answer;
}

int main()
{
    vector<vector<int> > maps(5,vector <int>(5,1));
    
    cout << solution(maps);
}