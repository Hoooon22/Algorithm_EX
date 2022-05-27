#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

int solution(int n, vector<int> lost, vector<int> reserve) {
    int answer = 0;
    vector<int>::iterator lter_l_begin = lost.begin(); 
    vector<int>::iterator lter_l_end = lost.end();
    vector<int>::iterator lter_r_begin = reserve.begin();
    vector<int>::iterator lter_r_end = reserve.end();
    
    // reserve ++
    answer = n - lost.size();
    
    // reserver missing
    for (int i = 0; i < reserve.size(); i++)
    {
        if (find(lter_l_begin, lter_l_end, reserve.at(i)) != lter_l_end && lost.size() != 0)
        {
            lost.erase(find(lter_l_begin, lter_l_end, reserve.at(i)));
            reserve.erase(find(lter_r_begin, lter_r_end, reserve.at(i)));
            lter_l_end--;
            lter_r_end--;
            answer++;
            i--;
        }
    }
    // lost
    for (int i = 0; i < lost.size(); i++)
    {
        if (find(lter_r_begin, lter_r_end, lost.at(i) - 1) != lter_r_end && lost.at(i) != 1)
        {
            answer++;
            reserve.erase(find(lter_r_begin, lter_r_end, lost.at(i) - 1));
            lter_r_end--;
        }
        else if (find(lter_r_begin, lter_r_end, lost.at(i) + 1) != lter_r_end && lost.at(i) != n)
        {
            answer++;
            reserve.erase(find(lter_r_begin, lter_r_end, lost.at(i) + 1));
            lter_r_end--;
        }
    }
    
    return answer;
}

int main()
{
    int n = 5;

    vector<int> lost;
    lost.push_back(1);
    lost.push_back(2);
    lost.push_back(3);
    lost.push_back(4);
    lost.push_back(5);

    vector<int> reserve;
    reserve.push_back(1);
    reserve.push_back(2);
    reserve.push_back(3);
    reserve.push_back(4);
    reserve.push_back(5);

    cout << solution(n, lost, reserve) << endl;

    return 0;
}