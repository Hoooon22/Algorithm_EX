#include <string>
#include <vector>
#include <algorithm>

using namespace std;

string solution(vector<string> participant, vector<string> completion) {
    string answer = "";
    // sort
    sort(participant.begin(), participant.end());
    sort(completion.begin(), completion.end());
    
		// for
    for(vector<int>::size_type i = 0; i < completion.size(); i++)
     {
         if (participant.at(i).compare(completion.at(i)) != 0)
         {
             answer.assign(participant.at(i));
             break;
         }
     }
    if (answer.compare("") == 0)
    {
        answer.assign(participant.at(participant.size()-1));
    }
    
    return answer;
}