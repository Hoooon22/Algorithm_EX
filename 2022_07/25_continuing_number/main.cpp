/*
 알고리즘 문제 : 백준 2635 - 수 이어가기
 실습 날짜 : 2022-07-26
 문제 : https://www.acmicpc.net/problem/2635
 */

#include <iostream>
#include <string>
#include <vector>

using namespace std;

int first;
vector<int> max_v;

void bruteforce(int second)
{
	vector<int> bf_v;
	int sum;
	int count = 2;

	bf_v.push_back(first);
	bf_v.push_back(second);
	while (true)
	{
		sum = bf_v.at(count-2) - bf_v.at(count-1);
		if (sum >= 0)
			bf_v.push_back(sum);
		else
			break;
		count++;
	}

	if (bf_v.size() > max_v.size())
		max_v = bf_v;
}

int main(void) 
{
	// 1. first number
	cin >> first;

	// 2. pick second number & 3. minus
	for (int i = first; i > 0; i--)
	{
		bruteforce(i);
	}
	
	cout << max_v.size() << endl;
	for (int i = 0; i < max_v.size(); i++)
		cout << max_v.at(i) << " ";
	
	return 0;
}