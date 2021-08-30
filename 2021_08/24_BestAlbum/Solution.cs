/*
 알고리즘 문제 : 프로그래머스 코딩테스트 연습 - 베스트앨범
 실습 날짜 : 2021-08-24 
 문제 : https://programmers.co.kr/learn/courses/30/lessons/42579?language=csharp
 */
using System;

namespace _24_BestAlbum
{
    class Solution
    {
        static void Main(string[] args)
        {

        }

        public int[] solution(string[] genres, int[] plays)
        {
            int[] answer = new int[] { };
            string[] genre_list = new string[100];
            int[] play_list = new int[100];

            // add genre, play list
            int i = 0, j = 0;
            while (i < genres.Length)
            {
                if (Array.IndexOf(genre_list, genres[i]) <= -1) // Not Found
                {
                    genre_list[j] = genre_list[i];
                    play_list[j] = plays[i];
                    j++;
                }
                else // Found
                {
                    for (int k = 0; k < j; k++)
                    {
                        if (genre_list[k] == genres[i])
                        {
                            play_list[k] = plays[i];
                        }
                    }
                }
                i++;
            }

            // 

            return answer;
        }
    }
}
