using System;

namespace _12_EstimateSheet
{
    class Solution
    {
        static public int solution(int n, int a, int b)
        {
            int answer = 1;
            int x = a, y = b;

            while (true)
            {
                // 같은 라운드에서 만나는지
                if (Math.Abs(x-y) == 1 && Math.Max(x,y) % 2 ==0)
                {
                    break;
                }

                // 그렇지 않다면, a와 b를 다음 라운드로
                if (x % 2 == 0)
                    x /= 2;
                else
                    x = (x + 1) / 2;

                if (y % 2 == 0)
                    y /= 2;
                else
                    y = (y + 1) / 2;

                answer++;
            }

            return answer;
        }

        static void Main(string[] args)
        {
            int N = 8;
            int a = 4, b = 7;

            Console.WriteLine($"{a}와 {b}가 만나는 라운드는 {solution(N, a, b)}라운드입니다.");
        }
    }
}
