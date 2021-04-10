/*
 알고리즘 문제 : 프로그래머스 코딩테스트 연습 - 조이스틱
 실습 날짜 : 2021-04-10
 문제 : https://programmers.co.kr/learn/courses/30/lessons/42860
 */

using System;

namespace _10_Joystick
{
    class Solution
    {
        static public int solution(string name)
        {
            int answer = 0;
            int[] visit = new int[name.Length];
            int left_index, right_index;

            // name의 Length에 따른 다른 방식 적용
            if (name.Length < 3)
            {
                foreach (char c in name)
                {
                    if (c <= 'N')
                        answer += c - 'A'; // A에서 밑으로
                    else
                        answer += 'Z' - c + 1; // A에서 위로
                }
            }
            else
            {
                left_index = name.Length - 1; // 마지막 인덱스
                right_index = 1;
            }

            return answer;
        }

        static void Main(string[] args)
        {
            string Nickname = "ABC";
            Console.WriteLine($"{Nickname}의 최소 이동 횟수는 {solution(Nickname)}회 입니다.");
        }
    }
}
