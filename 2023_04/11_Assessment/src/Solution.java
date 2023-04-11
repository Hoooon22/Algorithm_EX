/*
 알고리즘 문제 : 프로그래머스 - 인사고과
 실습 날짜 : 2023-04-11
 문제 : https://school.programmers.co.kr/learn/courses/30/lessons/152995
*/

import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }

    public int solution(int[][] scores) {
        int answer = 0;
        int[] wanho = {scores[0][0], scores[0][1]};

        // 오름차순 정렬
        Arrays.sort(scores, ((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return Integer.compare(o1[1], o2[1]);
            } else {
                return Integer.compare(o1[0], o2[0]);
            }
        }));

        

        return answer;
    }
}
