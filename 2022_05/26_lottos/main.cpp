#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(vector<int> lottos, vector<int> win_nums) {
    vector<int> answer;
    int high_n = 0, low_n = 0;
    
    for (int ele : lottos)
    {
        if (find(win_nums.begin(), win_nums.end(), ele) != win_nums.end())
            low_n++;
        else if (ele == 0)
            high_n++;
    }
    high_n += low_n;
    
    if (high_n > 1)
        high_n = 7 - high_n;
    else
        high_n = 6;
    if (low_n > 1)
        low_n = 7 - low_n;
    else
        low_n = 6;
    
    answer.push_back(high_n);
    answer.push_back(low_n);
    return answer;
}

int main()
{
    return 0;
}