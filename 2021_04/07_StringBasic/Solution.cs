/*
 알고리즘 문제 : 프로그래머스 코딩테스트 연습 - 문자열 다루기 기본
 실습 날짜 : 2021-04-07
 문제 : 문자열 s의 길이가 4 혹은 6이고, 숫자로만 구성돼있는지 확인해주는 함수, 
        solution을 완성하세요. 예를 들어 s가 "a234"이면 False를 리턴하고 "1234"라면 
        True를 리턴하면 됩니다.
 */

using System;

namespace _07_StringBasic
{
    class Solution
    {
        static public bool solution(string s)
        {
            bool answer = true;

            // 1. 문자열 길이는 4 or 6
            if (s.Length != 4 && s.Length != 6)
                answer = false;
            else
            {
                // 2. 문자열 하나하나 반복 비교
                foreach (char c in s)
                {
                    if (!(c >= 48 && c <= 57)) // 숫자가 아닐경우 false
                        answer = false;
                }
            }    

            return answer;
        }
        static void Main(string[] args)
        {
            string input = Console.ReadLine();

            if (solution(input))
                Console.WriteLine("True");
            else
                Console.WriteLine("False");
        }
    }
}
