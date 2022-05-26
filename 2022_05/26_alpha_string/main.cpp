#include <iostream>
#include <string>
#include <vector>

using namespace std;

int solution(string s) {
    int answer = 0;
    vector< pair<string, string> > table_vector;
    string output = s;
    
    table_vector.push_back(make_pair("0", "zero"));
    table_vector.push_back(make_pair("1", "one"));
    table_vector.push_back(make_pair("2", "two"));
    table_vector.push_back(make_pair("3", "three"));
    table_vector.push_back(make_pair("4", "four"));
    table_vector.push_back(make_pair("5", "five"));
    table_vector.push_back(make_pair("6", "six"));
    table_vector.push_back(make_pair("7", "seven"));
    table_vector.push_back(make_pair("8", "eight"));
    table_vector.push_back(make_pair("9", "nine"));
    
    if (output.find_first_not_of("0123456789") == string::npos)
    {
        answer = atoi(output.c_str());
    }
    else
    {
        int index = 0;
        int comp_len = 5;
        while(true) 
        { 
            comp_len = 5;
            // is not number
            if (output.at(index) < 48 || output.at(index) > 57)
            {
                if (index > output.length() - 5)
                    comp_len = output.length() - index;
                
                for (int i = 0; i < 10; i++)
                {
                    if (output.substr(index, comp_len).find(table_vector.at(i).second) != string::npos)
                    {
                        output.replace(index, table_vector.at(i).second.length(), table_vector.at(i).first);
                        break;
                    }
                }
            }
            
            index++;
            if(output.find_first_not_of("0123456789") == string::npos)
                break;
        }
        answer = atoi(output.c_str());
    }
    return answer;
}

int main()
{
    cout << solution("one4seveneight") << endl;

    return 0;
}