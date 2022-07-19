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

bool compare(int i, int j)
{
    return j < i;
}

int main()
{
    int N;
    vector<int> A;
    vector<int> B;
    string tmp;
    string word;
    int a, b;
    int sum = 0;
    
    // input
    cin >> N;
    cin.ignore();

    getline(cin, tmp);
    stringstream ss1(tmp);
    while(getline(ss1, word, ' '))
        A.push_back(stoi(word));

    getline(cin, tmp);
    stringstream ss2(tmp);
    while(getline(ss2, word, ' '))
        B.push_back(stoi(word));

    // find S
    for (int i = 0; i < N; i++)
    {
        a = *max_element(A.begin(), A.end());
        b = *min_element(B.begin(), B.end());
        sum += a * b;
        cout << sum << "=" << a << "?" << A.back() << endl;
        cout << sum << "=" << b << "?" << B.back() << endl << endl;
        if (a == (int)A.back())
        {
            A.pop_back();
        }
        else
        {
            remove(A.begin(), A.end(), *max_element(A.begin(), A.end()));
        }
        
        if (b == (int)B.back())
        {
            B.pop_back();
        }
        else
        {
            remove(B.begin(), B.end(), *min_element(B.begin(), B.end()));
        }
    }

    cout << sum << endl;

    return 0;
}