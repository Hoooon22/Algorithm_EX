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
                char[] c = name.ToCharArray();

                int index = 0;
                int left_index = name.Length - 1; // 마지막 인덱스
                int right_index = 1;

                // c[0] 알파벳 맞추기
                if (c[index] <= 'N')
                    answer += c[index] - 'A'; // A에서 밑으로
                else
                    answer += 'Z' - c[index] + 1; // A에서 위로

                // 1. 모든 문자열을 돌때까지 반복
                while (left_index >= right_index)
                {
                    if (Math.Abs(c[right_index] - 'N') > Math.Abs(c[left_index] - 'N')) // right_index로 가는 경우가 효율적일 경우
                    {
                        answer++; // right로 한 칸 이동
                        index = right_index; 
                        right_index++;
                    }
                    else // left_index로 가는 경우가 효율적일 경우
                    {
                        answer++; // left로 한 칸 이동
                        index = left_index; 
                        left_index--;
                    }

                    // 2. 알파벳 맞추기
                    if (c[index] <= 'N')
                        answer += c[index] - 'A'; // A에서 밑으로
                    else
                        answer += 'Z' - c[index] + 1; // A에서 위로
                }
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
