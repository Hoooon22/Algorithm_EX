#include <string>
#include <vector>
#include <queue>

using namespace std;

vector<int> solution(vector<int> progresses, vector<int> speeds) {
    vector<int> answer;
    queue< pair<int, int> > q;
    int day = 0;
    
    // insert to queue
    for (int i = 0; i < progresses.size(); i++)
    {
        q.push(make_pair(progresses.at(i), speeds.at(i)));
    }
    
    int dist = 0; // 배포
    while (!q.empty())
    {
        if (q.front().first + q.front().second*day < 100)
        {
            day++;
            dist = 0;
        }
        else
        {
            while (!q.empty())
            {
                if (q.front().first + q.front().second*day < 100)
                    break;
                else 
                {
                    dist++;
                    q.pop();
                }
            }
            answer.push_back(dist);
        }
    }
    
    return answer;
}