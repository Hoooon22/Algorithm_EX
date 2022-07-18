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

int main()
{
    int N;
    vector<int> A;
    vector<int> B;
    string tmp;
    string word;
    
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
    

    return 0;
}