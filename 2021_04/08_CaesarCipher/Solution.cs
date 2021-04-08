/*
 알고리즘 문제 : 프로그래머스 코딩테스트 연습 - 시저 암호
 실습 날짜 : 2021-04-08
 문제 : 어떤 문장의 각 알파벳을 일정한 거리만큼 밀어서 다른 알파벳으로 바꾸는 암호화 방식을 
        시저 암호라고 합니다. 예를 들어 "AB"는 1만큼 밀면 "BC"가 되고, 3만큼 밀면 "DE"가 됩니다. 
        "z"는 1만큼 밀면 "a"가 됩니다. 문자열 s와 거리 n을 입력받아 s를 n만큼 민 암호문을 
        만드는 함수, solution을 완성해 보세요.
 */

using System;

namespace _08_CaesarCipher
{
    class Solution
    {
        static public string solution(string s, int n)
        {
            string answer = "";

            foreach (char c in s)
            {
                if (c == ' ') // 공백은 그대로
                    answer += " ";
                else // 그 외 (알파벳)
                {
                    if (c + n > 122 || (c < 91 && c + n > 90))
                        answer += Convert.ToChar(c + n - 26);
                    else
                        answer += Convert.ToChar(c + n);
                }
            }

            return answer;
        }
        static void Main(string[] args)
        {
            string str = " aBZ";
            Console.WriteLine($"{str} -> {solution(str, 25)}");
        }
    }
}
