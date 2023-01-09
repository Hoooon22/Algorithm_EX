/*
 알고리즘 문제 : 프로그래머스 - 마법의 엘리베이터
 실습 날짜 : 2023-01-05
 문제 : https://school.programmers.co.kr/learn/courses/30/lessons/148653?language=java
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        System.out.println(solution(555));
    }

    public static int solution(int storey) {
        int answer = 0;
        int tmp = storey;
        boolean check = false;

        while (tmp > 0) {
            int number = tmp % 10;

            // if over half
            if (number > 5 && tmp < 10 && !check) {
                answer += 10 - number;
            }
            else if (number >= 5 && tmp > 10) {
                answer += 10 - number;
                if (check) {
                    answer -= 1;
                }
                check = true;
            }
            else if (check) {
                answer += 10 - number + 1;
                check = false;
            }
            else {
                answer += number;
            }

            tmp /= 10;
        }
        return answer;
    }
}