/*
 알고리즘 문제 : 프로그래머스 코딩테스트 연습 - 스킬트리
 실습 날짜 : 2021-04-09
 문제 : 선행 스킬이란 어떤 스킬을 배우기 전에 먼저 배워야 하는 스킬을 뜻합니다.

        예를 들어 선행 스킬 순서가 스파크 → 라이트닝 볼트 → 썬더일때, 썬더를 배우려면 먼저 라이트닝 볼트를 배워야 하고, 
        라이트닝 볼트를 배우려면 먼저 스파크를 배워야 합니다.

        위 순서에 없는 다른 스킬(힐링 등)은 순서에 상관없이 배울 수 있습니다. 
        따라서 스파크 → 힐링 → 라이트닝 볼트 → 썬더와 같은 스킬트리는 가능하지만, 썬더 → 스파크나 
        라이트닝 볼트 → 스파크 → 힐링 → 썬더와 같은 스킬트리는 불가능합니다.

        선행 스킬 순서 skill과 유저들이 만든 스킬트리1를 담은 배열 skill_trees가 매개변수로 주어질 때, 
        가능한 스킬트리 개수를 return 하는 solution 함수를 작성해주세요.
 */

using System;

namespace _09_SkillTree
{
    class Solution
    {
        static public int solution(string skill, string[] skill_trees)
        {
            int answer = 0;
            bool check;
            int char_index; // 비교하고자 하는 단어의 위치

            foreach (string skill_tree in skill_trees)
            {
                check = true;
                for (int i = skill.Length - 1; i > 0; i--) // skill의 마지막부터 비교함
                {
                    char_index = skill_tree.IndexOf(skill.Substring(i, 1));

                    if (char_index != -1) // 비교하고자 하는 단어가 문자열에 있을 경우
                    {
                        // 선행 스킬이 앞에 없을 경우, false
                        if (!skill_tree.Substring(0, char_index + 1).Contains(skill.Substring(i - 1, 1)))
                            check = false;
                    }
                }

                if (check)
                {
                    Console.WriteLine($"{skill_tree} => O");
                    answer++;
                }
                else
                    Console.WriteLine($"{skill_tree} => X");
            }

            return answer;
        }

        static void Main(string[] args)
        {
            string skill = "CBD";
            string[] skill_trees = { "BACDE", "CBADF", "AECB", "BDA" };

            Console.WriteLine($"skill => {skill}");
            Console.WriteLine($"가능한 스킬트리는 총 {solution(skill, skill_trees)}개 입니다.");
        }
    }
}
