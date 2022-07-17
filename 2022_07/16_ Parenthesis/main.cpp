/*
 알고리즘 문제 : 백준 9012 - 괄호
 실습 날짜 : 2022-07-16
 문제 : https://www.acmicpc.net/problem/9012
 */

#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
#include <sstream>
#include <stack>

using namespace std;

void Is_VPS(string str)
{
    stack<string> s;
    
    for (int i = 0; i < str.size(); i++)
    {
        if (str[i] == '(')
            s.push("(");
        else if (str[i] == ')')
        {
            if (s.empty())
            {
                cout << "NO" << endl;
                return;
            }
            else
                s.pop();
        }
    }
    if (s.empty())
        cout << "YES" << endl;
    else
        cout << "NO" << endl;
}

int main()
{
    int T;
    vector<string> v;
    string tmp;

    // input
    cin >> T;

    for (int i = 0; i < T; i++)
    {
        cin.ignore(256,'\n');
        cin >> tmp;
        v.push_back(tmp);
    }

    // VPS
    for (int i = 0; i < T; i++)
        Is_VPS(v.at(i));

    return 0;
}