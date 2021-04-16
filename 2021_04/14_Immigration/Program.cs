using System;
using System.Linq;

namespace _14_Immigration
{
    class Program
    {
        static public long solution(int n, int[] times)
        {
            long answer = -1;
            int wait = n; // 대기자
            int[] screen = new int[times.Length]; // 심사장
            for (int i = 0; i < screen.Length; i++) // 초기화
            {
                screen[i] = 1;
            }
            bool delay = false;

            if (wait < times.Length)
            {
                Array.Sort(times);
                return times[wait - 1];
            }

            while (wait > 0)
            {
                answer++; // 1분 증가

                // 대기자 넣어주기
                for (int i = 0; i < times.Length; i++)
                {
                    screen[i]--; // 심사 시간 소요

                    if (screen[i] == 0) // 심사 완료
                    {
                        if (wait >= times.Length)
                        {
                            wait--;
                            screen[i] = times[i];
                        }
                        else
                        {
                            for (int j = 0; j < times.Length; j++)
                            {
                                if (times[i] > times[j] + screen[j])
                                {
                                    delay = true;
                                    break;
                                }
                            }
                            if (!delay)
                            {
                                wait--;
                                screen[i] = times[i];
                            }
                            delay = false;
                        }
                    }
                }
            }

            // 남은 심사 진행
            answer += screen.Max();

            return answer;
        }

        static void Main(string[] args)
        {
            int n = 6;
            int[] times = { 7, 10};

            Console.WriteLine($"{n}명이 있을 때, {solution(n, times)}분에 끝납니다");
        }
    }
}
